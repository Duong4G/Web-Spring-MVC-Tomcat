package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.bean.Mailer;
import ptithcm.entity.Category;

@Transactional
@Controller
@RequestMapping("mailer")
public class MailerController {
	@Autowired
	Mailer mailer;
	
	@Autowired
	SessionFactory factory;
	@RequestMapping("form")
	public String index(){
		return "mailer/form";
	}
	
	@RequestMapping("send")
	public String send(ModelMap model,@RequestParam("to")String to){
		String subject = "Chào bạn " + to;
		String body = "Cảm ơn bạn đã luôn ủng hộ trang web chúng tôi!"
				+ "\n Số điện thoại: 0387418431 (Dương);"
				+ "\n Email cá nhân: vinacafe11vn@gmail.com;"
				+ "\n Facebook: https://www.facebook.com/profile.php?id=100005361367805";
		String from = "duongthichkhampha@gmail.com";
		try{
			mailer.send(from, to, subject, body);
			model.addAttribute("message", "Gửi mail thành công");
		}catch(Exception ex){
			model.addAttribute("message", "Gửi mail thất bại!");
		}
		return "mailer/form";
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
