package br.com.lelo.precojsf.mbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.lelo.precojsf.business.CompradorBusiness;
import br.com.lelo.precojsf.commons.FacesContextMessageUtil;
import br.com.lelo.precojsf.mbean.core.LoginSessionRules;
import br.com.lelo.precojsf.model.Comprador;
import br.com.lelo.precojsf.model.Filial;
import br.com.lelo.precojsf.model.Fornecedor;
import br.com.lelo.precojsf.model.enums.TipoPessoaEnum;

@ManagedBean(name = "beanLogin")
@SessionScoped
public class LoginManagedBean {

	private Comprador comprador = new Comprador();
	private CompradorBusiness compradorBusiness = new CompradorBusiness();

	public String login() {

		if (compradorBusiness.isBlank(getComprador()) == false) {
			Comprador byLogin = compradorBusiness.findByLogin(getComprador().getEmail());

			if (byLogin == null) {
				FacesContextMessageUtil.addInfoMessage("login:txtLogin", "Usuário não cadastrado");
			} else {

				if (getComprador().getPassword().equalsIgnoreCase(byLogin.getPassword()) == false) {
					FacesContextMessageUtil.addInfoMessage("login:txtUserPassword", "Senha inválida");
				} else {
					LoginSessionRules.login(this.comprador);
					return "produto?faces-redirect=true";
				}
			}
		}
		return null;
	}

	public String logout() {
		LoginSessionRules.logout();
		return "login?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		Filial filial1 = new Filial();
		filial1.setNome("Filial Cohab II - " + filial1.getCodigo());
		filial1.save();

		Filial filial2 = new Filial();
		filial2.setNome("Filial Grajau - " + filial2.getCodigo());
		filial2.save();

		Filial filial3 = new Filial();
		filial3.setNome("Filial Tiradentes - " + filial3.getCodigo());
		filial3.save();

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Fornecedor Base - " + fornecedor.getCodigo());
		fornecedor.setDocumento("90.312.321.333");
		fornecedor.setTipoPessoa(TipoPessoaEnum.JURIDICA);
		fornecedor.save();

		this.comprador = new Comprador();
		comprador.setEmail("teste@teste.com");
		comprador.setPassword("teste");
		comprador.setNome("Teste " + comprador.getCodigo());
		comprador.save();
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

}
