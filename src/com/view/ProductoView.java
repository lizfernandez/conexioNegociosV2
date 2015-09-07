package com.view;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



import com.entities.vo.ProductoVo;
import com.service.ProductoService;

@ManagedBean(name="productoView")
@SessionScoped
public class ProductoView implements Serializable {
	     
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		private List<ProductoVo> promociones;
		
	         
	    @ManagedProperty("#{productoService}")
	    private ProductoService service;
	    
	   
	    @PostConstruct
	    public void init() {
	    	/**
	    	 * cargamos las promociones activas
	    	 */
	    	promociones =  service.listaPromociones();
	    	
	    }

		

		/**
		 * @return the service
		 */
		public ProductoService getService() {
			return service;
		}

		/**
		 * @param service the service to set
		 */
		public void setService(ProductoService service) {
			this.service = service;
		}



		/**
		 * @return the promociones
		 */
		public List<ProductoVo> getPromociones() {
			return promociones;
		}



		/**
		 * @param promociones the promociones to set
		 */
		public void setPromociones(List<ProductoVo> promociones) {
			this.promociones = promociones;
		}


		
		
	 
	   
}
