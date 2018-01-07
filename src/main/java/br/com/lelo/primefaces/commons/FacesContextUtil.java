package br.com.lelo.primefaces.commons;

import java.util.Map;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

public class FacesContextUtil {

    private FacesContextUtil() {}

    public static Map<String, Object> getSessionMap() {
        return getContext().getExternalContext().getSessionMap();
    }

    public static String getViewId() {
        return getContext().getViewRoot().getViewId();
    }

    public static void handleNavigation(String param1, String page) {
        FacesContext context = getContext();
        NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
        navigationHandler.handleNavigation(getContext(), null, page);
        context.renderResponse();
    }

    public static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    public static String getBeanByViewId() {
        String viewId = getViewId();
        viewId = StringUtils.replace(viewId, "page", "");
        viewId = StringUtils.replace(viewId, "/", "");
        viewId = StringUtils.replace(viewId, ".xhtml", "");
        return viewId;
    }

}
