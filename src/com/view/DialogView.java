package com.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

@ManagedBean(name="dialogView")
@ViewScoped
public class DialogView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void showDialogLogo() {
		
			        Map<String, Object> options = new HashMap<String, Object>();
	
			        options.put("modal", true);
		
			        options.put("draggable", false);
		
			        options.put("resizable", false);
		
			        options.put("contentWidth", 500);
		
			        options.put("contentHeight", 100);
		
			        options.put("includeViewParams", true);
		
			 
		
			        Map<String, List<String>> params = new HashMap<String, List<String>>();
		
			        List<String> values = new ArrayList<String>();
		
			      //  values.add(bookName);
		
			        params.put("bookName", values);
		
			 
			        RequestContext.getCurrentInstance().openDialog("/plantillasBase/dialogLogo", options, params);
		
			    }
	 public void oncancel() {
		 RequestContext.getCurrentInstance().execute("PF('statusDialog').hide()");
	    }
}
