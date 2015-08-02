package com.service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.GenericaDao;
import com.entitie.Promocione;
import com.entities.vo.PromocioneVo;

 
@ManagedBean(name = "promocioneService")
@ApplicationScoped
public class PromocioneService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	GenericaDao genericaDao= new GenericaDao();  
     
    public List<PromocioneVo> listaPromociones() {
        List<Promocione> list = new ArrayList<Promocione>();
        List<PromocioneVo> listVo = new ArrayList<PromocioneVo>();
        list=genericaDao.listaEntidadGenerica(Promocione.class);
        int i=1;
        for(Promocione bean:list) {
        	
            PromocioneVo vo= new PromocioneVo(bean);
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