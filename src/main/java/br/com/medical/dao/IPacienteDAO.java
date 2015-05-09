package br.com.medical.dao;

import java.util.List;

import br.com.infra.commons.entity.Paciente;

public interface IPacienteDAO {

	public List<Paciente> getPacientes();
}
