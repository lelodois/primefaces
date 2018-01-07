package br.com.lelo.primefaces.mbean.core;

import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;

import br.com.lelo.primefaces.commons.FacesContextUtil;
import br.com.lelo.primefaces.model.Comprador;

public class LoginSessionRules {

	private static String USUARIO_PRINCIPAL = "usuarioPrincipal";
	private static String DATA_VENCIMENTO_SESSAO = "dataVencimentoSessao";
	private static String TEMPO_RESTANTE_SESSAO = "tempoRestanteSessao";

	public static void login(Comprador comprador) {
		getSessionMap().put(USUARIO_PRINCIPAL, comprador);
		updateDataVencimentoSession();
	}

	public static void logout() {
		getSessionMap().remove(USUARIO_PRINCIPAL);
		getSessionMap().remove(TEMPO_RESTANTE_SESSAO);
	}

	public static boolean isLogged() {
		return getSessionMap().containsKey(USUARIO_PRINCIPAL);
	}

	public static Date getExpirationDate() {
		return (Date) getSessionMap().get(DATA_VENCIMENTO_SESSAO);
	}

	public static boolean isValidSession() {
		boolean valid = false;
		if (isLogged()) {
			Date expirationDate = getExpirationDate();
			Date now = new Date();
			if (now.after(expirationDate)) {
				logout();
			} else {
				valid = true;
				getSessionMap().put(TEMPO_RESTANTE_SESSAO, new Date(expirationDate.getTime() - now.getTime()));
			}
		}
		return valid;
	}

	private static Map<String, Object> getSessionMap() {
		return FacesContextUtil.getSessionMap();
	}

	private static void updateDataVencimentoSession() {
		getSessionMap().put(DATA_VENCIMENTO_SESSAO, DateTime.now().plusMinutes(10).toDate());
	}

}
