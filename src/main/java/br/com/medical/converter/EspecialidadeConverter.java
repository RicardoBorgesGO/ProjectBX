package br.com.medical.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.infra.commons.entity.Especialidade;
import br.com.infra.commons.entity.TipoDeColaborador;
import br.com.medical.bean.ColaboradorMB;

@ManagedBean(name = "especialidadeConverterMB")
@RequestScoped
public class EspecialidadeConverter implements Converter {

	@ManagedProperty(value = "#{colaboradorMB}")
	private ColaboradorMB colaboradorMB;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return getEspecialidade(Long.parseLong(value));
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	private Especialidade getEspecialidade(Long id) {
		for (TipoDeColaborador tipoDeColaborador : colaboradorMB.getTipoDeColaboradores()) {
			if (!tipoDeColaborador.getEspecialidades().isEmpty()) {
				for (Especialidade especialidade : tipoDeColaborador.getEspecialidades()) {
					if (especialidade.getId().equals(id))
						return especialidade;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
		else {
			Especialidade especialidade = (Especialidade) value;
			return especialidade.getId().toString();
		}
	}

	public ColaboradorMB getColaboradorMB() {
		return colaboradorMB;
	}

	public void setColaboradorMB(ColaboradorMB colaboradorMB) {
		this.colaboradorMB = colaboradorMB;
	}

}
