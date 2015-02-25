package br.com.medical.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.commons.constant.EnumEstadoCivil;
import br.com.commons.constant.EnumSexo;

import com.google.gson.reflect.TypeToken;
import com.upschool.entity.Dentista;
import com.upschool.util.UtilJson;

@ManagedBean
@ViewScoped
public class PacienteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3008717343099503499L;

	private List<Dentista> dentistas;

	/**
	 * Retorna todos os sexos
	 * 
	 * @return
	 */
	public EnumSexo[] getSexos() {
		return EnumSexo.values();
	}

	/**
	 * Retorna os estados civis
	 * 
	 * @return
	 */
	public EnumEstadoCivil[] getEstadosCivis() {
		return EnumEstadoCivil.values();
	}

	public List<Dentista> getDentistas() {
		if (dentistas == null)
			dentistas = UtilJson.getAllObjectJson("http://localhost:8080/spring-jpa/rest/dentista/getDentistas", new TypeToken<ArrayList<Dentista>>() {}.getType());
		return dentistas;
	}

}
