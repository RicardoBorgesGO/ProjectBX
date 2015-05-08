package br.com.medical.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;

import br.com.infra.commons.constant.EnumAtivoInativo;
import br.com.infra.commons.constant.EnumEspecialidadesOdontologicas;
import br.com.infra.commons.constant.EnumEstadoCivil;
import br.com.infra.commons.constant.EnumSexo;
import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.TipoDeColaborador;
import br.com.infra.commons.util.UtilConverter;
import br.com.infra.commons.util.UtilJson;
import br.com.medical.dao.IColaboradorDAO;

@ViewScoped
@ManagedBean
public class ColaboradorMB extends GenericMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763643560114401069L;

	private Colaborador colaborador;

	private List<Colaborador> colaboradores;
	
	private List<TipoDeColaborador> tipoDeColaboradores;
	
	@Inject
	private IColaboradorDAO colaboradorDAO;

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
	
	public List<TipoDeColaborador> getTipoDeColaboradores() {
		if (tipoDeColaboradores == null) {
//			tipoDeColaboradores = UtilJson.getAllObjectJson(getInitialParameter("url-service") + "/rest/colaborador/getTiposDeColaboradores", new TypeToken<ArrayList<TipoDeColaborador>>() {}.getType());
			tipoDeColaboradores = colaboradorDAO.getTiposDeColaboradores();
		}
		return tipoDeColaboradores;
	}

	public List<Colaborador> getColaboradores() {
		if (colaboradores == null) {
//			colaboradores = UtilJson.getAllObjectJson(getInitialParameter("url-service") + "/rest/colaborador/getColaboradores", new TypeToken<ArrayList<Colaborador>>() {}.getType());
			colaboradores = colaboradorDAO.getColaboradores();
		}
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
	
	public void alterarEspecialidade(AjaxBehaviorEvent event) {
		colaborador.setEspecialidade(null);
	}

	public String salvarColaborador() {
		String colaboradorJson = UtilConverter.objectToJson(colaborador);
		
		// TODO Colocar url em um arquivo ou classe de configuracao
		String mensagem = UtilJson.postJson(
				getInitialParameter("url-service") + "/rest/colaborador/setColaborador",
				colaboradorJson);
		
		addMensagemSucesso(mensagem);
		
		return "index?faces-redirect=true";
	}
	
	public String atualizar() {
		getFlashScoped().put("colaborador", colaborador);
		return "cadastro?faces-redirect=true";
	}
	
	public String acessarAgenda() {
		getFlashScoped().put("colaborador", colaborador);
		return "agenda?faces-redirect=true&colaborador=" + colaborador.getId();
	}

}
