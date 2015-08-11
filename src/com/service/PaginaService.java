package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.GenericaDao;
import com.entitie.Categoria;
import com.entities.vo.CategoriaVo;

@ManagedBean(name = "paginaService")
@ApplicationScoped
public class PaginaService {
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
}
