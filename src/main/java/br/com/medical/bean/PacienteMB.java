package br.com.medical.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.infra.commons.constant.EnumEstadoCivil;
import br.com.infra.commons.constant.EnumOperadoraCelular;
import br.com.infra.commons.constant.EnumSexo;
import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.Paciente;
import br.com.infra.commons.util.UtilConverter;
import br.com.infra.commons.util.UtilJson;

import com.google.gson.reflect.TypeToken;

@ManagedBean
@ViewScoped
public class PacienteMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3008717343099503499L;

	private Paciente paciente;

	private List<Paciente> pacientes;

	private List<Colaborador> colaboradores;

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
	 * Retorna operadores de celular
	 * @return
	 */
	public EnumOperadoraCelular[]  getOperadorasDeCelular() {
		return EnumOperadoraCelular.values();
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
			pacientes = UtilJson
					.getAllObjectJson(
							getInitialParameter("url-service") + "/rest/paciente/getPacientes",
							new TypeToken<ArrayList<Paciente>>() {
							}.getType());
		return pacientes;
	}

	public List<Colaborador> getColaboradores() {
		if (colaboradores == null)
			colaboradores = UtilJson
					.getAllObjectJson(
							getInitialParameter("url-service") + "/rest/colaborador/getColaboradores",
							new TypeToken<ArrayList<Colaborador>>() {
							}.getType());
		return colaboradores;
	}

	public String salvarPaciente() {
		String pacienteJson = UtilConverter.objectToJson(paciente);

		// TODO Colocar url em um arquivo ou classe de configuracao
		String mensagem = UtilJson.postJson(
				getInitialParameter("url-service") + "/rest/paciente/setPaciente",
				pacienteJson);

		addMensagemSucesso(mensagem);

		return "index";
	}

	public String salvar() {
		paciente = new Paciente();
		getFlashScoped().put("paciente", paciente);
		return "cadastro?faces-redirect=true";
	}

	public String atualizar() {
		getFlashScoped().put("paciente", paciente);
		return "cadastro?faces-redirect=true";
	}

}
