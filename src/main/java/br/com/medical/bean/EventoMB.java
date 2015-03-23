package br.com.medical.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.Evento;
import br.com.infra.commons.util.UtilConverter;
import br.com.infra.commons.util.UtilJson;

@ManagedBean
@ViewScoped
public class EventoMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9148064236378193923L;
	
	private Evento evento;
	
	private Colaborador colaborador;
	
	@PostConstruct
	public void init() {
		colaborador = (Colaborador) getFlashScoped().get("colaborador");
		evento = new Evento();
	}
	
	public String adicionarEventoParaColaborador() {
		String eventJson = UtilConverter.objectToJson(evento);
		
		//TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson(getInitialParameter("url-service") + "/rest/evento/setEvento", eventJson);

		return "agenda?faces-redirect=true&colaborador=" + evento.getColaborador().getId();
	}

	public String adicionarEvento() {
		String eventJson = UtilConverter.objectToJson(evento);
		
		//TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson(getInitialParameter("url-service") + "/rest/evento/setEvento", eventJson);

		return "";
	}
	
	public String removeEvento() {
		String eventJson = UtilConverter.objectToJson(evento);
		
		//TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson(getInitialParameter("url-service") + "/rest/evento/deleteEvento", eventJson);
		
		return "";
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}
