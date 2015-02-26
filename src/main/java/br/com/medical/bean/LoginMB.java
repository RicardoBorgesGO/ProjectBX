package br.com.medical.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.upschool.entity.Usuario;
import com.upschool.util.MensagemRespostaServico;
import com.upschool.util.UtilConverter;
import com.upschool.util.UtilJson;

@ManagedBean
@ViewScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 2122351638380116753L;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		setUsuario(new Usuario());
	}

	public String logar() {
		String usuarioJson = UtilConverter.objectToJson(getUsuario());

		// TODO Colocar url em um arquivo ou classe de configuracao
		MensagemRespostaServico resposta = UtilJson.postJson(
				"http://localhost:8080/spring-jpa/rest/usuario/realizarLogin",
				usuarioJson);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(resposta.getMensagem()));
		return "blank.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
