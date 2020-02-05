package ptithcm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.entity.Category;
import ptithcm.entity.User;

@Transactional
@Controller
public class UserController {
	@Autowired
	SessionFactory factory;
	@RequestMapping("home")
	public String home(ModelMap model,@ModelAttribute("fullname")String fullname){
		model.addAttribute("fullname", fullname);
		return "indexReader";
		
	}
	@RequestMapping("homeWithAdministrator")
	public String homeWithAdministator(ModelMap model,@ModelAttribute("fullname")String fullname){
		model.addAttribute("fullname", fullname);
		return "index";
		
	}
	@RequestMapping(value="user/form",method=RequestMethod.GET)
	public String showForm(ModelMap model){
		model.addAttribute("user", new User());
		return "user/form";
	}
	@RequestMapping(value="user/form",method=RequestMethod.POST)
	public String showForm(ModelMap model,@ModelAttribute("user")User user,@RequestParam("repeatpassword")String repeatpassword,BindingResult errors){
		if(user.getId().trim().length()==0){
			errors.rejectValue("id", "user", "Vui lòng nhập tên đăng nhập");
		}
		if(user.getPassword().trim().length()==0){
			errors.rejectValue("password", "user", "Vui lòng nhập mật khẩu");
		}
		if(user.getFullname().trim().length()==0){
			errors.rejectValue("fullname","user", "Vui lòng nhập họ tên");
		}
		if(errors.hasErrors()){
			model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
			return "user/form";
		}
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		if(!user.getPassword().equals(repeatpassword)){
			model.addAttribute("message","Mật khẩu không trùng nhau");
			return "user/form";
		}
		try{
			user.setAdministrator(false);
			session.save(user);
			t.commit();
			model.addAttribute("message","Thêm mới thành công");
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message","Thêm mới thất bại");
		}finally {
			session.close();
		}
		return "user/form";
	}
	@RequestMapping(value="user/apply",method=RequestMethod.GET)
	public String apply(ModelMap model, HttpServletRequest request){
		model.addAttribute("user", new User());
		return "user/apply";
	}
	
	@RequestMapping(value="user/apply",method=RequestMethod.POST)
	public String apply(ModelMap model,@ModelAttribute("user")User user, BindingResult errors){
		if(user.getId().trim().length()==0){
			errors.rejectValue("id", "user", "Vui lòng nhập tên đăng nhập");
		}
		if(user.getPassword().trim().length()==0){
			errors.rejectValue("password", "user", "Vui lòng nhập mật khẩu");
		}
		if(errors.hasErrors()){
			model.addAttribute("message", "Vui lòng sửa các lỗi sau");
			return "user/apply";
		}
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		for(int i=0;i<list.size();i++){
			if(user.getId().equals(list.get(i).getId())&&user.getPassword().equals(list.get(i).getPassword())){
				if(list.get(i).getAdministrator()){
					model.addAttribute("fullname", "Administrator");
					return "redirect:/homeWithAdministrator.htm";
				}else{
					model.addAttribute("fullname", list.get(i).getFullname());
					return "redirect:/home.htm";
				}
			}
		}
		model.addAttribute("message","Sai thông tin đăng nhập");
		return "user/apply";
	}
	
	@ModelAttribute("categorylist")
	public List<Category> getCategoryList(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		return list;
	}
}
