package br.com.medical.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.infra.commons.entity.Usuario;
import br.com.infra.commons.util.UtilConverter;
import br.com.infra.commons.util.UtilJson;

@ManagedBean
@ViewScoped
public class LoginMB extends GenericMB implements Serializable {

	private static final long serialVersionUID = 2122351638380116753L;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		setUsuario(new Usuario());
	}

	public String logar() {
		String usuarioJson = UtilConverter.objectToJson(getUsuario());

		// TODO Colocar url em um arquivo ou classe de configuracao
		String message = UtilJson.postJson(
				"http://localhost:8080/spring-jpa/rest/usuario/realizarLogin",
				usuarioJson);
		
		addMensagemSucesso(message);
		
		return "blank.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
