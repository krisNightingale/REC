package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "category_controller")
@RequestScoped
public class CategoryController {

	@EJB
	private CategoryEJB categoryEJB;
	private Category category = new Category();
	private List<Category> list = new ArrayList<>();

	public List<Category> getCategoryList() {
		list = categoryEJB.findCategories();
		return list;
	}

	public String addNewCategory() {
		category = categoryEJB.addNewCategory(category);
		list = categoryEJB.findCategories();
		return "category_list.xhtml";
	}

	public CategoryEJB getCategoryEJB() {
		return categoryEJB;
	}

	public void setCategoryEJB(CategoryEJB categoryEJB) {
		this.categoryEJB = categoryEJB;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public List<Category> getList() {
		return getCategoryList();
	}
	
	public Category getOneCategory(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Category category : getCategoryList()){
            if (id.equals(category.getIdCategory())){
                return category;
            }
        }
        return null;
    }
	
}
