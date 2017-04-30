package model;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@FacesConverter(value = "positionConverter", forClass = Position.class)
public class PositionConvetrer implements Converter {

//	@Inject
//	EntityManager entityManager;

//	@Override
//	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
//		EntityManagerEJB rhb= FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(fc, "#{entityManagerEJB}", EntityManagerEJB.class);
//	    EntityManager em = rhb.getEm();
//		return em.find(Position.class, Integer.parseInt(string));
//	}
//
//	@Override
//	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
//		return Integer.toString(((Position) o).getIdPosition());
//	}
	
	@Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String positionId) {
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{position_controller}", PositionController.class);

        PositionController positions = (PositionController)vex.getValue(ctx.getELContext());
        System.out.println("-----NAME-----" + positions.getOnePosition(Integer.valueOf(positionId)).getIdPosition());
        return positions.getOnePosition(Integer.valueOf(positionId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object position) {
    	String idPosition = Integer.toString(((Position)position).getIdPosition());
    	System.out.println("-----ID POSITION---- " + idPosition);
        return idPosition;
    }

}