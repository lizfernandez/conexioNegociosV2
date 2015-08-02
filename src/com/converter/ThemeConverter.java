package com.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.entities.vo.EmpresaVo;
import com.service.ThemeService;


@FacesConverter("themeConverter")
public class ThemeConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	EmpresaVo paisVo= new EmpresaVo();
        if(value != null && value.trim().length() > 0) {
            try {
               ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
                List<EmpresaVo> pais=(List<EmpresaVo>) service.listaEmpresa();
                for(EmpresaVo pa:pais){
	                if(String.valueOf(pa.getiEmpresaId()).equals(value)){
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
        	EmpresaVo pais = (EmpresaVo) object;
           // return object.toString();//String.valueOf(((PaisVo) object).getiPaisId());
        	  return String.valueOf(pais.getiEmpresaId());
        }
        else {
            return null;
        }
    }   
}         
         