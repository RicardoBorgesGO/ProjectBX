package br.com.medical.dao;

import java.util.List;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.TipoDeColaborador;

public interface IColaboradorDAO {

	public List<Colaborador> getColaboradores();
	
	public List<TipoDeColaborador> getTiposDeColaboradores();
}
