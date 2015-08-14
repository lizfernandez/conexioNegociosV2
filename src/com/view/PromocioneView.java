package com.view;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



import com.entities.vo.PromocioneVo;
import com.service.PromocioneService;

@ManagedBean(name="promocioneView")
@SessionScoped
public class PromocioneView implements Serializable {
	     
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		private List<PromocioneVo> promociones;
		
	         
	    @ManagedProperty("#{promocioneService}")
	    private PromocioneService service;
	   
	    @PostConstruct
	    public void init() {
	    	/**
	    	 * cargamos las promociones activas
	    	 */
	    	promociones =  service.listaPromociones();
	    	
	    }

		/**
		 * @return the promociones
		 */
		public List<PromocioneVo> getPromociones() {
			return promociones;
		}


		/**
		 * @param service the service to set
		 */
		public void setService(PromocioneService service) {
			this.service = service;
		}

		
	 
	   
}
