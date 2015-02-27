package br.com.medical.bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class GenericMB {

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
