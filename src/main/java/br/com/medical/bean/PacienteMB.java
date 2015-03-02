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
import com.upschool.entity.Paciente;
import com.upschool.util.UtilConverter;
import com.upschool.util.UtilJson;

@ManagedBean
@ViewScoped
public class PacienteMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3008717343099503499L;

	private Paciente paciente;

	private List<Paciente> pacientes;

	private List<Dentista> dentistas;

	public Paciente getPaciente() {
		Paciente pacienteThis = (Paciente) getFlashScoped().get("paciente");
		
		if (pacienteThis != null) 
			paciente = pacienteThis;
		else if (paciente == null) 
			paciente = new Paciente();
		
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

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

	public List<Paciente> getPacientes() {
		if (pacientes == null)
			pacientes = UtilJson.getAllObjectJson("http://localhost:8080/spring-jpa/rest/paciente/getPacientes", new TypeToken<ArrayList<Paciente>>() {
							}.getType());
		return pacientes;
	}

	public List<Dentista> getDentistas() {
		if (dentistas == null)
			dentistas = UtilJson
					.getAllObjectJson(
							"http://localhost:8080/spring-jpa/rest/dentista/getDentistas",
							new TypeToken<ArrayList<Dentista>>() {
							}.getType());
		return dentistas;
	}
	
	public String salvarDentista() {
		String pacienteJson = UtilConverter.objectToJson(paciente);

		// TODO Colocar url em um arquivo ou classe de configuracao
		UtilJson.postJson(
				"http://localhost:8080/spring-jpa/rest/dentista/setPaciente",
				pacienteJson);

		return "";
	}
	
	public String salvar() {
		if (getPaciente() != null)
			getFlashScoped().remove(getPaciente());
		return "cadastro?faces-redirect=true";
	}
	
	public String atualizar() {
		getFlashScoped().put("paciente", paciente);
		return "cadastro?faces-redirect=true";
	}

}
