package com.service;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.servlet.http.HttpSession;

import com.dao.GenericaDao;
import com.dao.UsuarioDao;

import com.entitie.Usuario;

import com.entities.vo.UsuarioVo;

import com.util.FaceContext;
import com.util.Fechas;
import com.util.Util;

 
@ManagedBean(name = "usuarioService")
@ApplicationScoped
public class UsuarioService  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GenericaDao genericaDao= new GenericaDao();  
    UsuarioDao usuarioDao = new UsuarioDao();
	HttpSession session = FaceContext.getSession(); 
	
    public List<UsuarioVo> login(String usuario, String pass) {
       
        List<Usuario> list=usuarioDao.login(usuario,pass);
        List<UsuarioVo> listVo= new ArrayList<UsuarioVo>();
        for(Usuario bean:list) {        	
        	UsuarioVo vo= new UsuarioVo(bean);           
            listVo.add(vo); 
            
        }
         
        return listVo;
    }
  
  
}