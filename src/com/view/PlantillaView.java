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
import javax.servlet.http.HttpSession;

import org.kohsuke.rngom.parse.Parseable;

import com.entities.vo.CategoriaVo;
import com.entities.vo.PlantillaVo;
import com.service.PlantillaService;
import com.util.FaceContext;

@ManagedBean(name="plantillaView")
@ViewScoped
public class PlantillaView implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{plantillaService}")
	private PlantillaService service;
	private List<PlantillaVo> listaPlantilla;
	private boolean todosTema = true;  
	private boolean gratis;
	private boolean premiun;  
	private boolean todosPlantilla = true;
	
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
    
	public void agregarPlantilla(String iPlantillaId){
        
		PlantillaVo plantilla = (PlantillaVo) service.findPlantilla(Integer.parseInt(iPlantillaId));
		HttpSession session = FaceContext.getSession();
		session.removeAttribute("PlantillaUsuario");
        session.setAttribute("PlantillaUsuario",plantilla);
        
		
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
	/**
	 * @return the todosTema
	 */
	public boolean isTodosTema() {
		return todosTema;
	}
	/**
	 * @param todosTema the todosTema to set
	 */
	public void setTodosTema(boolean todosTema) {
		this.todosTema = todosTema;
	}
	/**
	 * @return the gratis
	 */
	public boolean isGratis() {
		return gratis;
	}
	/**
	 * @param gratis the gratis to set
	 */
	public void setGratis(boolean gratis) {
		this.gratis = gratis;
	}
	/**
	 * @return the premiun
	 */
	public boolean isPremiun() {
		return premiun;
	}
	/**
	 * @param premiun the premiun to set
	 */
	public void setPremiun(boolean premiun) {
		this.premiun = premiun;
	}
	/**
	 * @return the todosPlantilla
	 */
	public boolean isTodosPlantilla() {
		return todosPlantilla;
	}
	/**
	 * @param todosPlantilla the todosPlantilla to set
	 */
	public void setTodosPlantilla(boolean todosPlantilla) {
		this.todosPlantilla = todosPlantilla;
	}



	
	
}
