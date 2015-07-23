package com.service;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;

import com.dao.GenericaDao;
import com.dao.UsuarioDao;

import com.entitie.Usuario;

import com.entities.vo.UsuarioVo;

import com.util.Constantes;
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
  
    public boolean iduUsuario(UsuarioVo vo, String mode){
	EntityTransaction transaccion;
	boolean resultado= false;
		
		try {
			transaccion = genericaDao.entityTransaction();
			transaccion.begin();
			if(mode.equals("I")){
				/** se crea un nuevo usuario **/
				Usuario usuario= new Usuario(vo);
				usuario.setvUsuario(vo.getPersona().getvEmail());				
				usuario.setdFechaInserta(Fechas.getDate());
				usuario.setcEstadoCodigo(Constantes.estadoActivo);
			
				//usuario.setPerfil(genericaDao.findEndidad(Perfil.class, 1));
				genericaDao.persistEndidad(usuario);	
			}
			
		resultado=	genericaDao.commitEndidad(transaccion);
			
			
		  
		    
			} catch (Exception e) {
			   e.printStackTrace();
			   genericaDao.limpiarInstancia();
			}
		return resultado;
    	
    }
  
}