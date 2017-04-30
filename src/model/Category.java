package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Objects;
import java.util.Set;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_category")
	private int idCategory;

	private String name;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="categoryBean")
	private Set<Menu> menus;

	public Category() {
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setCategoryBean(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setCategoryBean(null);

		return menus;
	}

	@Override
	public boolean equals(Object obj) {
		// Basic checks.
        if (obj == this) return true;
        if (!(obj instanceof Category)) return false;

        // Property checks.
        Category other = (Category) obj;
        return Objects.equals(idCategory, other.idCategory)
            && Objects.equals(name, other.name);
	}
}