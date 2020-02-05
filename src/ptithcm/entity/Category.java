package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Category {
	@Id
	private String id;
	private String name;
	
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private Collection<Novel> novels;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the novels
	 */
	public Collection<Novel> getNovels() {
		return novels;
	}

	/**
	 * @param novels the novels to set
	 */
	public void setNovels(Collection<Novel> novels) {
		this.novels = novels;
	}

	

}
