package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.Author;
import ptithcm.entity.Category;

@Transactional
@Controller
@RequestMapping("author")
public class AuthorController {
	@Autowired
	SessionFactory factory;
	@RequestMapping(value="insertadmintt",method=RequestMethod.GET)
	public String insert(ModelMap model){
		model.addAttribute("author", new Author());
		return "author/insert";
	}
	@RequestMapping(value="insertadmintt",method=RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("author")Author author){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try{
			session.save(author);
			t.commit();
			return "redirect:/author/indexadmintt.htm";
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message","Thêm mới thất bại");
		}finally {
			session.close();
		}
		return "author/insert";
	}
	
	@RequestMapping(value="indexadmintt")
	public String index(ModelMap model){
		Session session = factory.getCurrentSession();
		String hql = "FROM Author";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Author> list = query.list();
		model.addAttribute("authors", list);
		return "author/index";
	}
	@RequestMapping(value="index")
	public String indexReader(ModelMap model){
		Session session = factory.getCurrentSession();
		String hql = "FROM Author";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Author> list = query.list();
		model.addAttribute("authors", list);
		return "author/indexReader";
	}
	
	@RequestMapping(value="upload/{id}",method=RequestMethod.GET)
	public String upload(ModelMap model,@PathVariable("id")Integer id){
		Session session = factory.getCurrentSession();
		String hql = "FROM Author A WHERE A.id = :author_id";
		Query query = session.createQuery(hql);
		query.setParameter("author_id", id);
		@SuppressWarnings("unchecked")
		List<Author> list = query.list();
		model.addAttribute("author", list.get(0));
		return "author/upload";
	}
	
	@RequestMapping(value="upload/{id}",method=RequestMethod.POST)
	public String upload(ModelMap model,@PathVariable("id")Integer id,@ModelAttribute("author")Author author){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		author.setId(id);
		try{
			session.update(author);
			t.commit();
			return "redirect:/author/indexadmintt.htm";
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message","Sửa thất bại");
		}finally {
			session.close();
		}
		return "author/upload";
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
	
	@RequestMapping(value="delete/{id}")
	public String delete(ModelMap model,@PathVariable("id")Integer id,@ModelAttribute("author")Author author){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		author.setId(id);
		try{
			session.delete(author);
			t.commit();
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message", "Xóa thất bại");
		}finally {
			session.close();
		}
		return "redirect:/author/indexadmintt.htm";
	}
}
