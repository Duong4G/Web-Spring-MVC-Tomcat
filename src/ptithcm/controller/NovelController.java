package ptithcm.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.entity.Author;
import ptithcm.entity.Category;
import ptithcm.entity.Chapter;
import ptithcm.entity.Novel;

@Transactional
@Controller
@RequestMapping("novel")
public class NovelController {
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;
	@RequestMapping("indexadmintt")
	public String index(ModelMap model){
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Novel> list = query.list();
		model.addAttribute("novels", list);
		return "novel/index";
	}
	
	@RequestMapping("index")
	public String indexReader(ModelMap model){
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Novel> list = query.list();
		model.addAttribute("novels", list);
		return "novel/indexReader";
	}
	
	@RequestMapping(value="indexadmintt/{id}")
	public String index(ModelMap model,@PathVariable("id")String id){
		if(!id.equals("new")){
			Session session = factory.getCurrentSession();
			String hql = "FROM Novel N WHERE N.category.id = :category_id";
			Query query = session.createQuery(hql);
			query.setParameter("category_id", id);
			@SuppressWarnings("unchecked")
			List<Novel> list = query.list();
			model.addAttribute("novels", list);
			if(list.size()>0){
				model.addAttribute("name", list.get(0).getCategory().getName());
			}
		}else{
			Session session = factory.getCurrentSession();
			String hql = "FROM Novel N ORDER BY N.date DESC";
			Query query = session.createQuery(hql);
			//Lấy 10 truyện mới nhất
			query.setMaxResults(10);
			@SuppressWarnings("unchecked")
			List<Novel> list = query.list();
			model.addAttribute("novels", list);
			model.addAttribute("name", "Danh sách truyện mới");
		}
		
		return "novel/indexWithCategory";
	}
	
	@RequestMapping(value="index/{id}")
	public String indexReader(ModelMap model,@PathVariable("id")String id){
		if(!id.equals("new")){
			Session session = factory.getCurrentSession();
			String hql = "FROM Novel N WHERE N.category.id = :category_id";
			Query query = session.createQuery(hql);
			query.setParameter("category_id", id);
			@SuppressWarnings("unchecked")
			List<Novel> list = query.list();
			model.addAttribute("novels", list);
			if(list.size()>0){
				model.addAttribute("name", list.get(0).getCategory().getName());
			}
		}else{
			Session session = factory.getCurrentSession();
			String hql = "FROM Novel N ORDER BY N.date DESC";
			Query query = session.createQuery(hql);
			//Lấy 10 truyện mới nhất
			query.setMaxResults(10);
			@SuppressWarnings("unchecked")
			List<Novel> list = query.list();
			model.addAttribute("novels", list);
			model.addAttribute("name", "Danh sách truyện mới");
		}
		
		return "novel/indexWithCategoryReader";
	}
	
	@RequestMapping(value="insertadmintt", method=RequestMethod.GET)
	public String insert(ModelMap model){
		model.addAttribute("novel", new Novel());
		Session session = factory.getCurrentSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		model.addAttribute("categories", list);
		
		session = factory.getCurrentSession();
		hql = "FROM Author";
		query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Author> list2 = query.list();
		model.addAttribute("authors", list2);
		return "novel/insert";
	}
	@RequestMapping(value="insertadmintt",method=RequestMethod.POST)
	public String insert(ModelMap model,@ModelAttribute("novel")Novel novel){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		novel.setImage("default.png");
		try{
			novel.setDate(new Date());
			session.save(novel);
			t.commit();
			return "redirect:/novel/indexadmintt.htm";
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message",ex.toString());
		}finally {
			session.close();
		}
		return "novel/insert";
	}
	@RequestMapping(value="chapterlistadmintt/{id}")
	public String showList(ModelMap model,@PathVariable("id")Integer id){
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel N WHERE N.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("novel_id",id);
		@SuppressWarnings("unchecked")
		List<Novel> list = query.list();
		model.addAttribute("novel", list.get(0));
		
		session = factory.getCurrentSession();
		hql = "FROM Chapter C WHERE C.novel.id = :novel_id";
		query = session.createQuery(hql);
		query.setParameter("novel_id",id);
		@SuppressWarnings("unchecked")
		List<Chapter> list2 = query.list();
		model.addAttribute("chapters", list2);
		return "novel/chapterlist";
	}
	@RequestMapping(value="chapterlist/{id}")
	public String showListReader(ModelMap model,@PathVariable("id")Integer id){
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel N WHERE N.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("novel_id",id);
		@SuppressWarnings("unchecked")
		List<Novel> list = query.list();
		model.addAttribute("novel", list.get(0));
		
		session = factory.getCurrentSession();
		hql = "FROM Chapter C WHERE C.novel.id = :novel_id";
		query = session.createQuery(hql);
		query.setParameter("novel_id",id);
		@SuppressWarnings("unchecked")
		List<Chapter> list2 = query.list();
		model.addAttribute("chapters", list2);
		return "novel/chapterlistReader";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="chapterlistadmintt/{id}/{number}")
	public String showChapter(ModelMap model,@PathVariable("number")Integer number, @PathVariable("id")Integer novelId){
		Session session = factory.getCurrentSession();
		String hql = "FROM Chapter C WHERE C.number = :number AND C.novel.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("number",number);
		query.setParameter("novel_id", novelId);
		List<Chapter> list = query.list();
		model.addAttribute("chapter", list.get(0));
		
		hql = "FROM Chapter C WHERE C.novel.id = :novel_id ORDER BY C.number DESC";
		query = session.createQuery(hql);
		query.setParameter("novel_id", novelId);
		list = query.list();
		model.addAttribute("max", list.get(0).getNumber());
		return "novel/chapter";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="chapterlist/{id}/{number}")
	public String showChapterReader(ModelMap model,@PathVariable("number")Integer number, @PathVariable("id")Integer novelId){
		Session session = factory.getCurrentSession();
		String hql = "FROM Chapter C WHERE C.number = :number AND C.novel.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("number",number);
		query.setParameter("novel_id", novelId);
		List<Chapter> list = query.list();
		model.addAttribute("chapter", list.get(0));
		
		hql = "FROM Chapter C WHERE C.novel.id = :novel_id ORDER BY C.number DESC";
		query = session.createQuery(hql);
		query.setParameter("novel_id", novelId);
		list = query.list();
		model.addAttribute("max", list.get(0).getNumber());
		return "novel/chapterReader";
	}
	@RequestMapping(value="chapterlistadmintt/insert/{id}",method=RequestMethod.GET)
	public String insertChapter(ModelMap model,@PathVariable("id")Integer id){
		model.addAttribute("chapter", new Chapter());
		
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel N WHERE N.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("novel_id",id);
		@SuppressWarnings("unchecked")
		List<Chapter> list = query.list();
		model.addAttribute("novel", list.get(0));
		return "novel/insert2";
	}
	
	@RequestMapping(value="chapterlistadmintt/insert/{id}",method=RequestMethod.POST)
	public String insertChapter(ModelMap model,@ModelAttribute("chapter")Chapter chapter,
			@ModelAttribute("novel")Novel novel,
			@PathVariable("id")Integer id){
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try{
			chapter.setNovel(novel);
			session.save(chapter);
			t.commit();
			return "redirect:/novel/chapterlistadmintt/" + id + ".htm";
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message","Thêm mới thất bại");
		}finally {
			session.close();
		}
		return "novel/insert2";
	}
	
	@RequestMapping(value="chapterlistadmintt/{novelId}/{id}/upload",method=RequestMethod.GET)
	public String uploadChapter(ModelMap model,@PathVariable("novelId")Integer novelId, @PathVariable("id")Integer id){
		Session session = factory.getCurrentSession();
		String hql = "FROM Chapter C WHERE C.id = :chapter_id";
		Query query = session.createQuery(hql);
		query.setParameter("chapter_id",id);
		@SuppressWarnings("unchecked")
		List<Chapter> list = query.list();
		model.addAttribute("chapter", list.get(0));
		return "novel/upload";
	}
	
	@RequestMapping(value="chapterlistadmintt/{novelId}/{id}/upload",method=RequestMethod.POST)
	public String uploadChapter(ModelMap model, @ModelAttribute("chapter")Chapter chapter,@PathVariable("novelId")Integer novelId){
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel N WHERE N.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("novel_id",novelId);
		@SuppressWarnings("unchecked")
		List<Novel> list = query.list();
		
		session = factory.openSession();
		Transaction t = session.beginTransaction();
		try{
			chapter.setNovel(list.get(0));
			session.update(chapter);
			t.commit();
			return "redirect:/novel/chapterlistadmintt/" +novelId+".htm";
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message","Lưu thất bại");
		}finally {
			session.close();
		}
		return "novel/upload";
	}
	
	@RequestMapping(value="chapterlistadmintt/{novelId}/delete")
	public String deleteNovel(ModelMap model,@PathVariable("novelId")Integer novelId){
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Novel novel = new Novel();
		novel.setId(novelId);
		try{
			session.delete(novel);
			t.commit();
			return "redirect:/novel/indexadmintt.htm";
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message","Xóa thất bại");
		}finally {
			session.close();
		}
		return "novel/uploadNovel";
	}
	
	@RequestMapping(value="chapterlistadmintt/{novelId}/upload",method=RequestMethod.GET)
	public String uploadNovel(ModelMap model,@PathVariable("novelId")Integer novelId){
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel N WHERE N.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("novel_id",novelId);
		@SuppressWarnings("unchecked")
		List<Novel> list = query.list();
		model.addAttribute("novel", list.get(0));
		
		session = factory.getCurrentSession();
		hql = "FROM Category";
		query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list1 = query.list();
		model.addAttribute("categories", list1);
		
		session = factory.getCurrentSession();
		hql = "FROM Author";
		query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Author> list2 = query.list();
		model.addAttribute("authors", list2);
		return "novel/uploadNovel";
	}
	
	@RequestMapping(value="chapterlistadmintt/{novelId}/upload",method=RequestMethod.POST)
	public String uploadNovel(ModelMap model,@RequestParam("photo")MultipartFile image,@RequestParam("name")String name,
			@RequestParam("country")String country,
			@PathVariable("novelId")Integer novelId){
		String path = "C:\\Users\\Duong\\workspace\\DoAnCuoiKy\\WebContent\\images\\";
		String imageName = null;
		if(image.isEmpty()){
			imageName = "default.png";
		}else{
			try{
				String photoPath =  path + image.getOriginalFilename();
				image.transferTo(new File(photoPath));
				imageName = image.getOriginalFilename();
				
			}catch(Exception ex){
				model.addAttribute("message", path);
			}
		}
		
		Session session = factory.getCurrentSession();
		String hql = "FROM Novel N WHERE N.id = :novel_id";
		Query query = session.createQuery(hql);
		query.setParameter("novel_id",novelId);
		@SuppressWarnings("unchecked")
		List<Novel> list = query.list();
		Novel novel = list.get(0);
		if(!imageName.equals("default.png")){
			novel.setImage(imageName);
		}
		novel.setName(name);
		novel.setCountry(country);
		model.addAttribute("novel", novel);
		
		Session session1 = factory.openSession();
		Transaction t = session1.beginTransaction();
		try{
			session.update(novel);
			t.commit();
			return "redirect:/novel/indexadmintt.htm";
		}catch(Exception ex){
			t.rollback();
			model.addAttribute("message","Sửa thất bại");
		}finally {
			session1.close();
		}
		return "novel/uploadNovel";
	}
	
	@RequestMapping(value="chapterlistadmintt/{novelId}/{id}/delete")
	public String deleteChapter(ModelMap model,@PathVariable("novelId")Integer novelId,@PathVariable("id")Integer id){
		Session session = factory.getCurrentSession();
		String hql = "FROM Chapter C WHERE C.id = :chapter_id";
		Query query = session.createQuery(hql);
		query.setParameter("chapter_id",id);
		@SuppressWarnings("unchecked")
		List<Chapter> list = query.list();
		Chapter chapter = list.get(0);
		
		Session session1 = factory.openSession();
		Transaction t = session1.beginTransaction();
		try{
			session.delete(chapter);
			t.commit();
			return "redirect:/novel/chapterlistadmintt/" + novelId + ".htm";
		}catch(Exception ex){
			t.rollback();
		}finally {
			session1.close();
		}
		
		return "redirect:/novel/chapterlistadmintt/" + novelId + ".htm";
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
