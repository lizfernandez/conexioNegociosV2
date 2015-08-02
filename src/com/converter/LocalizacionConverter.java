package com.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.entities.vo.PaisVo;
import com.service.LocalizacionService;


@FacesConverter("localizacionConverter")
public class LocalizacionConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	PaisVo paisVo= new PaisVo();
        if(value != null && value.trim().length() > 0) {
            try {
                LocalizacionService service = (LocalizacionService) fc.getExternalContext().getApplicationMap().get("localizacionService");
                List<PaisVo> pais=(List<PaisVo>) service.getListPais();
                for(PaisVo pa:pais){
	                if(String.valueOf(pa.getiPaisId()).equals(value)){
	                	paisVo=pa;
	                }
                }
                return paisVo;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
        	System.out.println("hola");
        	PaisVo pais = (PaisVo) object;
           // return object.toString();//String.valueOf(((PaisVo) object).getiPaisId());
        	  return String.valueOf(pais.getiPaisId());
        }
        else {
            return null;
        }
    }   
}         
         