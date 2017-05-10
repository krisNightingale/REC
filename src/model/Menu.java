package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_menu")
	private int idMenu;

	@Lob
	private String consist;

	private String name;

	private float price;

	private float weight;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category")
	private Category categoryBean;

	//bi-directional many-to-many association to Check
	@ManyToMany(mappedBy="menus", fetch = FetchType.EAGER)
	private Set<Check> checks;

	public Menu() {
		checks = new HashSet<Check>();
	}

	public int getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getConsist() {
		return this.consist;
	}

	public void setConsist(String consist) {
		this.consist = consist;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Category getCategoryBean() {
		return this.categoryBean;
	}

	public void setCategoryBean(Category categoryBean) {
		this.categoryBean = categoryBean;
	}

	public Set<Check> getChecks() {
		return this.checks;
	}

	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}

	@Override
	public boolean equals(Object obj) {
		// Basic checks.
        if (obj == this) return true;
        if (!(obj instanceof Menu)) return false;

        // Property checks.
        Menu other = (Menu) obj;
        return Objects.equals(idMenu, other.idMenu)
            && Objects.equals(name, other.name)
            && Objects.equals(price, other.price)
            && Objects.equals(weight, other.weight);
	}

	@Override
	public int hashCode() {
		return idMenu;
	}
	
}