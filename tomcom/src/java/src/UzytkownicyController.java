/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import src.util.JsfUtil;
import src.exceptions.NonexistentEntityException;
import src.util.PagingInfo;

/**
 *
 * @author Tomek
 */
public class UzytkownicyController {

    public UzytkownicyController() {
        pagingInfo = new PagingInfo();
        converter = new UzytkownicyConverter();
    }
    private Uzytkownicy uzytkownicy = null;
    private List<Uzytkownicy> uzytkownicyItems = null;
    private UzytkownicyJpaController jpaController = null;
    private UzytkownicyConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().getUzytkownicyCount());
        }
        return pagingInfo;
    }

    public UzytkownicyJpaController getJpaController() {
        if (jpaController == null) {
            jpaController = new UzytkownicyJpaController(javax.persistence.Persistence.createEntityManagerFactory("tomcomPU"));
        }
        return jpaController;
    }

    public SelectItem[] getUzytkownicyItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findUzytkownicyEntities(), false);
    }

    public SelectItem[] getUzytkownicyItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findUzytkownicyEntities(), true);
    }

    public Uzytkownicy getUzytkownicy() {
        if (uzytkownicy == null) {
            uzytkownicy = (Uzytkownicy) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentUzytkownicy", converter, null);
        }
        if (uzytkownicy == null) {
            uzytkownicy = new Uzytkownicy();
        }
        return uzytkownicy;
    }

    public String listSetup() {
        reset(true);
        return "uzytkownicy_list";
    }

    public String createSetup() {
        reset(false);
        uzytkownicy = new Uzytkownicy();
        return "uzytkownicy_create";
    }

    public String create() {
        try {
            getJpaController().create(uzytkownicy);
            JsfUtil.addSuccessMessage("Uzytkownicy was successfully created.");
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("uzytkownicy_detail");
    }

    public String editSetup() {
        return scalarSetup("uzytkownicy_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        uzytkownicy = (Uzytkownicy) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentUzytkownicy", converter, null);
        if (uzytkownicy == null) {
            String requestUzytkownicyString = JsfUtil.getRequestParameter("jsfcrud.currentUzytkownicy");
            JsfUtil.addErrorMessage("The uzytkownicy with id " + requestUzytkownicyString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String uzytkownicyString = converter.getAsString(FacesContext.getCurrentInstance(), null, uzytkownicy);
        String currentUzytkownicyString = JsfUtil.getRequestParameter("jsfcrud.currentUzytkownicy");
        if (uzytkownicyString == null || uzytkownicyString.length() == 0 || !uzytkownicyString.equals(currentUzytkownicyString)) {
            String outcome = editSetup();
            if ("uzytkownicy_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit uzytkownicy. Try again.");
            }
            return outcome;
        }
        try {
            getJpaController().edit(uzytkownicy);
            JsfUtil.addSuccessMessage("Uzytkownicy was successfully updated.");
        } catch (NonexistentEntityException ne) {
            JsfUtil.addErrorMessage(ne.getLocalizedMessage());
            return listSetup();
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String destroy() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentUzytkownicy");
        Integer id = new Integer(idAsString);
        try {
            getJpaController().destroy(id);
            JsfUtil.addSuccessMessage("Uzytkownicy was successfully deleted.");
        } catch (NonexistentEntityException ne) {
            JsfUtil.addErrorMessage(ne.getLocalizedMessage());
            return relatedOrListOutcome();
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if (relatedControllerOutcome != null) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<Uzytkownicy> getUzytkownicyItems() {
        if (uzytkownicyItems == null) {
            getPagingInfo();
            uzytkownicyItems = getJpaController().findUzytkownicyEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return uzytkownicyItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "uzytkownicy_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "uzytkownicy_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        uzytkownicy = null;
        uzytkownicyItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Uzytkownicy newUzytkownicy = new Uzytkownicy();
        String newUzytkownicyString = converter.getAsString(FacesContext.getCurrentInstance(), null, newUzytkownicy);
        String uzytkownicyString = converter.getAsString(FacesContext.getCurrentInstance(), null, uzytkownicy);
        if (!newUzytkownicyString.equals(uzytkownicyString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
