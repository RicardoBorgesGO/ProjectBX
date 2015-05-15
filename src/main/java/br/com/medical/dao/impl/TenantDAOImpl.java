package br.com.medical.dao.impl;

import br.com.medical.dao.ITenantDAO;
import br.com.medical.proxy.client.IClientMedicalProxy;
import br.com.medical.proxy.client.impl.ClientMedicalProxy;

public class TenantDAOImpl implements ITenantDAO {

	private IClientMedicalProxy clientProxy = new ClientMedicalProxy();
	
	@Override
	public void setTenant(String tenant) {
		clientProxy.setTenant(tenant);
	}

}
