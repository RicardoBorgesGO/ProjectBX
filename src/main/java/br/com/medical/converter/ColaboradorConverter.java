package br.com.medical.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.infra.commons.entity.Colaborador;

@FacesConverter(value = "br.com.medical.converter.ColaboradorConverter")
public class ColaboradorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String data) {
		if (data != null) {
			Colaborador colaborador = new Colaborador();
			colaborador.setId(Long.parseLong(data));
			
			return colaborador;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
		if (o != null) {
			Colaborador colaborador = (Colaborador) o;
			return colaborador.getId().toString();
		}
		return null;
	}

}
