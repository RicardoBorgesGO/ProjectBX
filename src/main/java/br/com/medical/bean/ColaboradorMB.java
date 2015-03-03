package br.com.medical.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.commons.constant.EnumAtivoInativo;
import br.com.commons.constant.EnumEspecialidadesOdontologicas;
import br.com.commons.constant.EnumEstadoCivil;
import br.com.commons.constant.EnumSexo;

import com.google.gson.reflect.TypeToken;
import com.upschool.entity.Colaborador;
import com.upschool.util.UtilConverter;
import com.upschool.util.UtilJson;

@ViewScoped
@ManagedBean
public class ColaboradorMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763643560114401069L;

	private Colaborador colaborador;

	private List<Colaborador> colaboradores;

	public Colaborador getColaborador() {
		Colaborador colaboradorThis = (Colaborador) getFlashScoped().get("colaborador");
		
		if (colaboradorThis != null) 
			colaborador = colaboradorThis;
		else if (colaborador == null) 
			colaborador = new Colaborador();
		
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public List<Colaborador> getColaboradores() {
		if (colaboradores == null)
			colaboradores = UtilJson.getAllObjectJson("http://localhost:8080/spring-jpa/rest/colaborador/getColaboradores", new TypeToken<ArrayList<Colaborador>>() {}.getType());
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaborador) {
		this.colaboradores = colaborador;
	}

	public EnumSexo[] getSexos() {
		return EnumSexo.values();
	}

	public EnumEstadoCivil[] getEstadosCivis() {
		return EnumEstadoCivil.values();
	}
	
	public EnumEspecialidadesOdontologicas[] getEspecialidadesOdontológicas() {
		return EnumEspecialidadesOdontologicas.values();
	}
	
	public EnumAtivoInativo[] getStatus() {
		return EnumAtivoInativo.values();
	}
	
	public String salvar() {
		if (getColaborador() != null)
			getFlashScoped().remove(getColaborador());
		return "cadastro?faces-redirect=true";
	} 

	public String salvarColaborador() {
		String colaboradorJson = UtilConverter.objectToJson(colaborador);

		// TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson(
				"http://localhost:8080/spring-jpa/rest/colaborador/setColaborador",
				colaboradorJson);

		return "";
	}
	
	public String atualizar() {
		getFlashScoped().put("colaborador", colaborador);
		return "cadastro?faces-redirect=true";
	}

}
