package br.com.lelo.precojsf.model;

public class Usuario extends Model {

	private static final long serialVersionUID = -4496679580760866435L;
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
