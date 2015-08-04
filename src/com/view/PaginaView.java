package com.view;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="paginaView")
@ViewScoped
public class PaginaView implements Serializable {

	
	public String create() throws IOException {
    	String url=null;
    	System.out.println("entro");
    	try {		
    		url="/pagina.xhtml?faces-redirect=true";
            return url;
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
    }
}
