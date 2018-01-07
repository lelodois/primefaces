package br.com.lelo.primefaces.commons;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.lelo.primefaces.mbean.core.LoginSessionRules;

public class LoginPhasesListener implements PhaseListener {

    private static final long serialVersionUID = 3792535723825621207L;

    @Override
    public void afterPhase(PhaseEvent event) {
        if (FacesContextUtil.getViewId().equalsIgnoreCase("/page/login.xhtml") == false) {
            if (LoginSessionRules.isValidSession() == false) {
                FacesContextMessageUtil.addInfoMessage("Sess�o expirada, entre novamente.");
                FacesContextUtil.handleNavigation(null, "login?faces-redirect=true");
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {}

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
