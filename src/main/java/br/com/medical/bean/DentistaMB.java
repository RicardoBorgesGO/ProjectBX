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
import com.upschool.util.UtilConverter;
import com.upschool.util.UtilJson;
import br.com.medical.bean.GenericMB;

@ViewScoped
@ManagedBean
public class DentistaMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763643560114401069L;

	private Dentista dentista;

	private List<Dentista> dentistas;

	public Dentista getDentista() {
		Dentista dentistaThis = (Dentista) getFlashScoped().get("dentista");
		
		if (dentistaThis != null) dentista = dentistaThis;
		if (dentista == null) dentista = new Dentista();
		
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public List<Dentista> getDentistas() {
		if (dentistas == null)
			dentistas = UtilJson.getAllObjectJson("http://localhost:8080/spring-jpa/rest/dentista/getDentistas", new TypeToken<ArrayList<Dentista>>() {}.getType());
		return dentistas;
	}

	public void setDentistas(List<Dentista> dentistas) {
		this.dentistas = dentistas;
	}

	public EnumSexo[] getSexos() {
		return EnumSexo.values();
	}

	public EnumEstadoCivil[] getEstadosCivis() {
		return EnumEstadoCivil.values();
	}

	public String salvar() {
		String dentistaJson = UtilConverter.objectToJson(dentista);

		// TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson(
				"http://localhost:8080/spring-jpa/rest/dentista/setDentista",
				dentistaJson);

		return "";
	}
	
	public String excluir() {
		String dentistaJson = UtilConverter.objectToJson(dentista);

		// TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson(
				"http://localhost:8080/spring-jpa/rest/dentista/deleteDentista",
				dentistaJson);
		
		return "";
	}
	
	public String atualizar() {
		getFlashScoped().put("dentista", dentista);
		return "cadastro?faces-redirect=true";
	}

}
