package com.service;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.GenericaDao;
import com.entitie.Pais;

import com.entities.vo.PaisVo;


 
@ManagedBean(name = "localizacionService")
@ApplicationScoped
public class LocalizacionService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GenericaDao genericaDao= new GenericaDao();  
	private List<PaisVo> listPais = new ArrayList<PaisVo>();
	
    
    @PostConstruct
    public void init() {
       List<Pais> list = new ArrayList<Pais>();
    	list=genericaDao.listaEntidadGenerica(Pais.class);
        for(Pais p:list){        	
        	listPais.add(new PaisVo(p));
        }
         
    	
    }


	/**
	 * @return the listPais
	 */
	public List<PaisVo> getListPais() {
		return listPais;
	}


	/**
	 * @param listPais the listPais to set
	 */
	public void setListPais(List<PaisVo> listPais) {
		this.listPais = listPais;
	}
	
  
}