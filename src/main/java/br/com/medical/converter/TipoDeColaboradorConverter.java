package br.com.medical.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.infra.commons.entity.TipoDeColaborador;
import br.com.medical.bean.ColaboradorMB;

@ManagedBean(name = "tipoDeColaboradorConverterMB")
@RequestScoped
public class TipoDeColaboradorConverter implements Converter {

	@ManagedProperty(value = "#{colaboradorMB}")
	private ColaboradorMB colaboradorMB;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return getTipoDeColaborador(Long.parseLong(value));
		} catch (NumberFormatException e) {
			return new TipoDeColaborador();
		}
	}
	
	private TipoDeColaborador getTipoDeColaborador(Long id) {
		for (TipoDeColaborador tipoDeColaborador : colaboradorMB.getTipoDeColaboradores()) {
			if (id.equals(tipoDeColaborador.getId()))
				return tipoDeColaborador;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
		else {
			TipoDeColaborador tipoDeColaborador = (TipoDeColaborador) value;
			return tipoDeColaborador.getId().toString();
		}
	}

	public ColaboradorMB getColaboradorMB() {
		return colaboradorMB;
	}

	public void setColaboradorMB(ColaboradorMB colaboradorMB) {
		this.colaboradorMB = colaboradorMB;
	}

}
