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
import com.util.Constantes;

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
	public List<PlantillaVo> listaPlantillaCategoria(String  iCategoriaId){
		  List<PlantillaVo> listVo = new ArrayList<PlantillaVo>();	
		  String where="";
		  if(iCategoriaId.equals("t")){
			  where=" p.cEstadoCodigo='"+Constantes.estadoActivo+"'";
		  }
		  else if(iCategoriaId.equals("g")){
			  where=" p.fPrecio IS NULL and p.cEstadoCodigo='"+Constantes.estadoActivo+"'";
		  }
		  else if(iCategoriaId.equals("p")){
			  where=" p.fPrecio IS NOT NULL and p.cEstadoCodigo='"+Constantes.estadoActivo+"'";
		  }
		  else{
		  where=" p.categoria.iCategoriaId="+Integer.parseInt(iCategoriaId);
		  }  
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
    
	public PlantillaVo findPlantilla(int iPlantillaId){
			
	      Plantilla  list = (Plantilla) genericaDao.findEndidad(Plantilla.class, iPlantillaId);	            	
	      PlantillaVo vo= new PlantillaVo(list);  
	      return vo;
		  
		
	}
	
}
