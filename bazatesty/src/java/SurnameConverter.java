/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kasiula
 */
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("surnameConv")
public class SurnameConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        String name = value;
        
        //pierwsza litera zawsze wielka
        if(!name.isEmpty()){
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        String urlRegex = "[a-zA-Z]+";

        if (!name.matches(urlRegex)) {

            FacesMessage msg
                    = new FacesMessage("Nazwisko zawiera niepozadane znaki",
                            "Invalid surname.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }

        //URLObject urlobj = new URLObject(url.toString());
        UserBean user = new UserBean(name, false);
        
        //return urlobj;
        return user.getNazwisko();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {

        return value.toString();

    }
}
