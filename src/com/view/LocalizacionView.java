package com.view;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.entities.vo.PaisVo;
import com.service.LocalizacionService;

@ManagedBean(name = "localizacionView", eager = true)
@SessionScoped
public class LocalizacionView implements Serializable  {
   private static final long serialVersionUID = 1L;
   private List<PaisVo> listaPais;
   private PaisVo pais;
   private String vImagen;
   private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
   private String localidad=locale.getDisplayLanguage();
  
   @ManagedProperty("#{localizacionService}")
   private LocalizacionService service;
    
    @PostConstruct
    public void init() {
 	   listaPais =  service.getListPais();
 	   setvImagen(listaPais.get(0).getvImagen());
 	   
    }

 //value change event listener
 public void localeChanged(ValueChangeEvent e){
       String newLocaleValue = e.getNewValue().toString();
       
       for (PaisVo pais:listaPais) {
          if(pais.getvNombre().equals(newLocaleValue)){
        	  	   locale = new Locale(pais.getvIdioma());
        	  	    setLocalidad(pais.getvIdioma());
        	  	    setvImagen(pais.getvImagen());
             FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);         
          }
       }
    }

 /**
  * @return the listaPais
  */
 public List<PaisVo> getListaPais() {
 	return listaPais;
 }

 /**
  * @param listaPais the listaPais to set
  */
 public void setListaPais(List<PaisVo> listaPais) {
 	this.listaPais = listaPais;
 }

/**
 * @return the pais
 */
public PaisVo getPais() {
	return pais;
}

/**
 * @param pais the pais to set
 */
public void setPais(PaisVo pais) {
	this.pais = pais;
}


/**
 * @param service the service to set
 */
public void setService(LocalizacionService service) {
	this.service = service;
}

/**
 * @return the vImagen
 */
public String getvImagen() {
	return vImagen;
}

/**
 * @param vImagen the vImagen to set
 */
public void setvImagen(String vImagen) {
	this.vImagen = vImagen;
}

/**
 * @return the localidad
 */
public String getLocalidad() {
	return localidad;
}

/**
 * @param localidad the localidad to set
 */
public void setLocalidad(String localidad) {
	this.localidad = localidad;
}

/**
 * @return the locale
 */
public Locale getLocale() {
	return locale;
}

/**
 * @param locale the locale to set
 */
public void setLocale(Locale locale) {
	this.locale = locale;
}
 
 
}