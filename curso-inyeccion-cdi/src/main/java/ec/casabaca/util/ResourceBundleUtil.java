package ec.casabaca.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
@ApplicationScoped
public class ResourceBundleUtil {
	private ResourceBundle bundlePropiedadesCurso;
	
	@PostConstruct
	public void inicializar () {
		bundlePropiedadesCurso = getBundle("propiedadesComunes");
	}
	
	public ResourceBundle getBundle(String nombre) {
		ResourceBundle bundle = null;
        FacesContext context = FacesContext.getCurrentInstance();
        bundle = context.getApplication().getResourceBundle(context, nombre);
        return bundle;
    }
	
    public String getValuePropiedadesCurso(String key) {
        String result = null;
        try {
            result = bundlePropiedadesCurso.getString(key);
        } catch (MissingResourceException e) {
            result = "???" + key + "??? not found";
        }
        return result;
    }
    
    public String getValuePropiedadesCurso(MensajeId id) {
        String result = null;
        try {
            result = bundlePropiedadesCurso.getString(id.getKey());
        } catch (MissingResourceException e) {
            result = "???" + id.getKey() + "??? not found";
        }
        return result;
    }
}	
