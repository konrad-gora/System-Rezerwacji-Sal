/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Tomek
 */
public class UzytkownicyConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Integer id = new Integer(string);
        UzytkownicyController controller = (UzytkownicyController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "uzytkownicy");
        return controller.getJpaController().findUzytkownicy(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Uzytkownicy) {
            Uzytkownicy o = (Uzytkownicy) object;
            return o.getId() == null ? "" : o.getId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: src.Uzytkownicy");
        }
    }
    
}
