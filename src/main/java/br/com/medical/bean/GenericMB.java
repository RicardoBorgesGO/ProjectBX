package br.com.medical.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class GenericMB {

	protected void addMensagemSucesso(String message) {
		addMensagemSucesso(message, "");
	}

	protected void addMensagemSucesso(String message, String details) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, message, null);
		facesMessage.setDetail(details);

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	protected void addMensagemErro(String message) {
		addMensagemErro(message, "");
	}

	protected void addMensagemErro(String message, String details) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, message, null);
		facesMessage.setDetail(details);

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	protected String getInitialParameter(String data) {
		return getExternalContext().getInitParameter(data);
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	protected ExternalContext getExternalContext() {
		return (ExternalContext) getFacesContext().getExternalContext();
	}

	protected Flash getFlashScoped() {
		return getExternalContext().getFlash();
	}
}
