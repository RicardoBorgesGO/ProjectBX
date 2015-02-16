package br.com.medical.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.upschool.entity.Evento;
import com.upschool.util.UtilConverter;

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
		System.out.println(eventJson);

		return "";
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
