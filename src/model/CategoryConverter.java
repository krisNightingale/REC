package model;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoryConverter", forClass = Category.class)
public class CategoryConverter implements Converter {

	@Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String categoryId) {
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{category_controller}", CategoryController.class);

        CategoryController categories = (CategoryController)vex.getValue(ctx.getELContext());
        System.out.println("-----NAME-----" + categories.getOneCategory(Integer.valueOf(categoryId)).getIdCategory());
        return categories.getOneCategory(Integer.valueOf(categoryId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object category) {
    	String idCategory = Integer.toString(((Category)category).getIdCategory());
    	System.out.println("-----ID CATEGORY---- " + idCategory);
        return idCategory;
    }

}
