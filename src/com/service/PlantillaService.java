package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.GenericaDao;
import com.entitie.Categoria;
import com.entitie.Plantilla;
import com.entities.vo.CategoriaVo;
import com.entities.vo.PlantillaVo;

@ManagedBean(name = "plantillaService")
@ApplicationScoped
public class PlantillaService {
	GenericaDao genericaDao= new GenericaDao();
	
	public List<CategoriaVo> listaCategoria(){
		  List<CategoriaVo> listVo = new ArrayList<CategoriaVo>();	
	      List<Categoria>  list = genericaDao.listaEntidadGenerica(Categoria.class);
	      
	      for(Categoria bean:list) {        	
	      	CategoriaVo vo= new CategoriaVo(bean);           
	          listVo.add(vo);
	      }
	      return listVo;
		  
	  }
	public List<PlantillaVo> listaPlantillaCategoria(int iCategoriaId){
		  List<PlantillaVo> listVo = new ArrayList<PlantillaVo>();	
		  String where=" p.categoria.iCategoriaId="+iCategoriaId;
		     
	      List<Plantilla>  list = genericaDao.findEndidadBDList(Plantilla.class, where);
	      int i=1;
	      for(Plantilla bean:list) {        	
	    	  PlantillaVo vo= new PlantillaVo(bean);           
	          
	          if(i==1)
	               vo.setEvento("fadeInUp");
	            if(i==2)
	            	vo.setEvento("fadeInDown");
	            if(i==3){
	            	vo.setEvento("fadeInUp");
	            	i=0;
	            }
	            listVo.add(vo);
	            i++;
	      }
	      return listVo;
		  
	  }
	
}
