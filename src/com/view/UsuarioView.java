package com.view;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.event.ActionEvent;

import javax.persistence.EntityTransaction;

import com.dao.GenericaDao;

import com.entitie.Usuario;

import com.entities.vo.UsuarioVo;

import com.util.Constantes;
import com.util.FaceContext;
import com.util.Fechas;

@ManagedBean(name="usuarioView")
@ViewScoped
public class UsuarioView implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private UsuarioVo usuarioVo = new UsuarioVo();
    
	GenericaDao genericaDao= new GenericaDao();
	
	public void buttonRegistrar(ActionEvent actionEvent){
		EntityTransaction transaccion;
		
		try {
			transaccion = genericaDao.entityTransaction();
			transaccion.begin();
			/** se crea un nuevo usuario **/
			Usuario usuario= new Usuario(usuarioVo); 
			usuario.setdFechaInserta(Fechas.getDate());
			usuario.setcEstadoCodigo(Constantes.estadoActivo);
			//usuario.setPerfil(genericaDao.findEndidad(Perfil.class, 1));
			genericaDao.persistEndidad(usuario);
			genericaDao.commitEndidad(transaccion);
			
			
		    FaceContext.addMessageInfo("mensajes","Usuario Correcto");
		    
			} catch (Exception e) {
			   e.printStackTrace();
			   genericaDao.limpiarInstancia();
			}
	    }



	/**
	 * @return the usuarioVo
	 */
	public UsuarioVo getUsuarioVo() {
		return usuarioVo;
	}


	/**
	 * @param usuarioVo the usuarioVo to set
	 */
	public void setUsuarioVo(UsuarioVo usuarioVo) {
		this.usuarioVo = usuarioVo;
	}


	
	    
}
