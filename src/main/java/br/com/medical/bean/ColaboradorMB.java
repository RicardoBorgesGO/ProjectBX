package br.com.medical.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.infra.commons.constant.EnumAtivoInativo;
import br.com.infra.commons.constant.EnumEspecialidadesOdontologicas;
import br.com.infra.commons.constant.EnumEstadoCivil;
import br.com.infra.commons.constant.EnumSexo;
import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.util.UtilConverter;
import br.com.infra.commons.util.UtilJson;

import com.google.gson.reflect.TypeToken;

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
		colaborador = new Colaborador();
		getFlashScoped().put("colaborador", colaborador);
		
		return "cadastro?faces-redirect=true";
	} 

	public String salvarColaborador() {
		String colaboradorJson = UtilConverter.objectToJson(colaborador);

		// TODO Colocar url em um arquivo ou classe de configuracao
		String mensagem = UtilJson.postJson(
				"http://localhost:8080/spring-jpa/rest/colaborador/setColaborador",
				colaboradorJson);
		
		addMensagemSucesso(mensagem);
		
		return "index";
	}
	
	public String atualizar() {
		getFlashScoped().put("colaborador", colaborador);
		return "cadastro?faces-redirect=true";
	}

}