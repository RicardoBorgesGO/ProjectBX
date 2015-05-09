package br.com.medical.dao.impl;

import java.io.Serializable;
import java.util.List;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.TipoDeColaborador;
import br.com.medical.dao.IColaboradorDAO;
import br.com.medical.proxy.client.ClientMedicalProxy;
import br.com.medical.proxy.client.IClientMedicalProxy;

public class ColaboradorDAOImpl implements Serializable, IColaboradorDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1399942256627972660L;
	
	//TODO Colocar Inject
	private IClientMedicalProxy clientProxy = new ClientMedicalProxy();
	
	@Override
	public List<Colaborador> getColaboradores() {
		return clientProxy.getColaboradores();
	}

	@Override
	public List<TipoDeColaborador> getTiposDeColaboradores() {
		return clientProxy.getTiposDeColaboradores();
	}
	
}
