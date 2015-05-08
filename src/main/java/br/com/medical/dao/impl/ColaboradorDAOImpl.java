package br.com.medical.dao.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.TipoDeColaborador;
import br.com.medical.dao.IColaboradorDAO;
import br.com.medical.proxy.client.IClientMedicalProxy;

public class ColaboradorDAOImpl implements IColaboradorDAO {

	@Inject
	private IClientMedicalProxy clientProxy;
	
	@Override
	public List<Colaborador> getColaboradores() {
		return clientProxy.getColaboradores();
	}

	@Override
	public List<TipoDeColaborador> getTiposDeColaboradores() {
		return clientProxy.getTiposDeColaboradores();
	}
	
}
