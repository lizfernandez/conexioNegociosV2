package com.service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dao.GenericaDao;
import com.entitie.Producto;
import com.entities.vo.ProductoVo;
import com.util.Constantes;

 
@ManagedBean(name = "productoService")
@ApplicationScoped
public class ProductoService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	GenericaDao genericaDao= new GenericaDao();  
     
    public List<ProductoVo> listaPromociones() {
        List<Producto> list = new ArrayList<Producto>();
        List<ProductoVo> listVo = new ArrayList<ProductoVo>();
        String where=" p.vTipoProducto='"+Constantes.tipoProductoPromocion+"'";
        list=genericaDao.findEndidadBDList(Producto.class, where);
        int i=1;
        for(Producto bean:list) {
        	
            ProductoVo vo= new ProductoVo(bean);
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