package br.com.lelo.precojsf.commons;

import javax.faces.application.FacesMessage;

public class FacesContextMessageUtil {

    public static void addInfoMessage(String message) {
        FacesContextUtil.getContext().addMessage(null, new FacesMessage(message));
    }

    public static void addInfoMessage(String id, String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, id);
        FacesContextUtil.getContext().addMessage(id, facesMessage);
    } 

}
