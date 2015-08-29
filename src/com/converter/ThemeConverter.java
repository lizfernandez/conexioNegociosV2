package com.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.entities.vo.UsuarioVo;
import com.service.ThemeService;


@FacesConverter("themeConverter")
public class ThemeConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	UsuarioVo paisVo= new UsuarioVo();
        if(value != null && value.trim().length() > 0) {
            try {
               ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
                List<UsuarioVo> pais=(List<UsuarioVo>) service.listaEmpresa();
                for(UsuarioVo pa:pais){
	                if(String.valueOf(pa.getiUsuarioId()).equals(value)){
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
        	UsuarioVo pais = (UsuarioVo) object;
           // return object.toString();//String.valueOf(((PaisVo) object).getiPaisId());
        	  return String.valueOf(pais.getiUsuarioId());
        }
        else {
            return null;
        }
    }   
}         
         