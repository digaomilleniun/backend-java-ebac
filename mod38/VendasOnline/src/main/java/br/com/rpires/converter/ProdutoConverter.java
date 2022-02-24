/**
 * 
 */
package br.com.rpires.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.com.rpires.domain.Produto;

/**
 * @author rodrigo.pires
 *
 */
@Named
@FacesConverter(value = "produtoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter {
	
	private static final String key = "br.com.rpires.converter.ProdutoConverter";
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty()) {
	        return null;
	    }
	    return getViewMap(context).get(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object produto) {
		String id = ((Produto)produto).getId().toString();
		getViewMap(context).put(id, produto);
	    return id;
	}
	
	private Map<String, Object> getViewMap(FacesContext context) {
	    Map<String, Object> viewMap = context.getViewRoot().getViewMap();
	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    Map<String, Object> idMap = (Map) viewMap.get(key);
	    if (idMap == null) {
	        idMap = new HashMap<String, Object>();
	        viewMap.put(key, idMap);
	    }
	    return idMap;
	}

}
