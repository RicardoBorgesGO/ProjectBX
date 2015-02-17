package br.com.medical.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.upschool.entity.Evento;
import com.upschool.util.UtilConverter;
import com.upschool.util.UtilJson;

@ManagedBean
@ViewScoped
public class EventoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9148064236378193923L;
	
	private Evento evento;
	
	@SuppressWarnings("rawtypes")
	private List<? extends ArrayList> eventos;

	@PostConstruct
	public void init() {
		evento = new Evento();
		//TODO substituir, e pegar os elementos por Jquery
//		eventos = UtilJson.getAllObjectJson("http://localhost:8080/spring-jpa/rest/evento/getEventos", new ArrayList<Evento>().getClass());
	}

	public String adicionarEvento() {
		String eventJson = UtilConverter.objectToJson(evento);
		
		//TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson("http://localhost:8080/spring-jpa/rest/evento/setEvento", eventJson);

		return "";
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
