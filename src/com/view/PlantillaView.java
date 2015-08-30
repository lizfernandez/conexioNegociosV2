package com.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.entities.vo.CategoriaVo;
import com.entities.vo.PlantillaVo;
import com.service.PlantillaService;

@ManagedBean(name="plantillaView")
@ViewScoped
public class PlantillaView implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{plantillaService}")
	private PlantillaService service;
	private List<PlantillaVo> listaPlantilla;
	
	@PostConstruct
	public void listaPlantillaCategoria(){
		
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String CategoriaId =  params.get("iCategoriaId");
		String iCategoriaId;
		if(CategoriaId==null){
			/*
			 * t: todos
			 **/			
			iCategoriaId = "t";
		}
		else{
			iCategoriaId = CategoriaId;
		}
		
		listaPlantilla = service.listaPlantillaCategoria(iCategoriaId);
    	
	}
	public List<CategoriaVo> listaCategoria(){
		List<CategoriaVo> lista= new ArrayList<CategoriaVo>();
    	lista = service.listaCategoria();
    	return lista;
    }
    
	


	/**
	 * @return the service
	 */
	public PlantillaService getService() {
		return service;
	}



	/**
	 * @param service the service to set
	 */
	public void setService(PlantillaService service) {
		this.service = service;
	}

	/**
	 * @return the listaPlantilla
	 */
	public List<PlantillaVo> getListaPlantilla() {
		return listaPlantilla;
	}

	/**
	 * @param listaPlantilla the listaPlantilla to set
	 */
	public void setListaPlantilla(List<PlantillaVo> listaPlantilla) {
		this.listaPlantilla = listaPlantilla;
	}



	
	
}
