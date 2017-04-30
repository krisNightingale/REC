package model;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "employeeConverter", forClass = Employee.class)
public class EmployeeConverter implements Converter {

	@Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String employeeId) {
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{employee_controller}", EmployeeController.class);

        EmployeeController employees = (EmployeeController)vex.getValue(ctx.getELContext());
        System.out.println("-----NAME-----" + employees.getOneEmployee(Integer.valueOf(employeeId)).getIdEmployee());
        return employees.getOneEmployee(Integer.valueOf(employeeId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object employee) {
    	String idEmployee = Integer.toString(((Employee)employee).getIdEmployee());
    	System.out.println("-----ID CATEGORY---- " + idEmployee);
        return idEmployee;
    }

}
