package model;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "clientConverter", forClass = Client.class)
public class ClientConverter implements Converter {

	@Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String clientId) {
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{client_controller}", ClientController.class);

        ClientController clients = (ClientController)vex.getValue(ctx.getELContext());
        System.out.println("-----NAME-----" + clients.getOneClient(Integer.valueOf(clientId)).getIdClient());
        return clients.getOneClient(Integer.valueOf(clientId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object client) {
    	String idClient = Integer.toString(((Client)client).getIdClient());
    	System.out.println("-----ID CLIENT---- " + idClient);
        return idClient;
    }

}
