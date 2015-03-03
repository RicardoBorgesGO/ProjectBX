package br.com.medical.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.infra.commons.entity.Evento;
import br.com.infra.commons.util.UtilConverter;
import br.com.infra.commons.util.UtilJson;

@ManagedBean
@ViewScoped
public class EventoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9148064236378193923L;
	
	private Evento evento;
	
	@PostConstruct
	public void init() {
		evento = new Evento();
	}

	public String adicionarEvento() {
		String eventJson = UtilConverter.objectToJson(evento);
		
		//TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson("http://localhost:8080/spring-jpa/rest/evento/setEvento", eventJson);

		return "";
	}
	
	public String removeEvento() {
		String eventJson = UtilConverter.objectToJson(evento);
		
		//TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson("http://localhost:8080/spring-jpa/rest/evento/deleteEvento", eventJson);
		
		return "";
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
