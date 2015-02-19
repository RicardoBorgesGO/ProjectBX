package br.com.medical.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.commons.constant.EnumEstadoCivil;
import br.com.commons.constant.EnumSexo;
import br.com.commons.constant.EnumTipoTelefone;

import com.upschool.entity.Dentista;
import com.upschool.entity.Telefone;

@ViewScoped
@ManagedBean
public class DentistaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763643560114401069L;

	private Dentista dentista;

	private Telefone telefoneComercial;
	private Telefone telefoneCelular;
	private Telefone telefoneResidencial;

	@PostConstruct
	public void init() {
		dentista = new Dentista();

		telefoneCelular = new Telefone(EnumTipoTelefone.CELULAR);
		telefoneComercial = new Telefone(EnumTipoTelefone.COMERCIAL);
		telefoneResidencial = new Telefone(EnumTipoTelefone.RESIDENCIAL);
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Telefone getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(Telefone telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public Telefone getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(Telefone telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public Telefone getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(Telefone telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public EnumSexo[] getSexos() {
		return EnumSexo.values();
	}

	public EnumEstadoCivil[] getEstadosCivis() {
		return EnumEstadoCivil.values();
	}

	public String salvar() {
		if (telefoneCelular.getNumeroDoTelefone() != null && !telefoneCelular.getNumeroDoTelefone().isEmpty()) dentista.adicionaTelefone(telefoneCelular);
		if (telefoneComercial.getNumeroDoTelefone() != null && telefoneComercial.getNumeroDoTelefone().isEmpty()) dentista.adicionaTelefone(telefoneComercial);
		if (telefoneResidencial.getNumeroDoTelefone() != null && telefoneResidencial.getNumeroDoTelefone().isEmpty()) dentista.adicionaTelefone(telefoneResidencial);
		
		System.out.println(dentista);
		return "";
	}

}
