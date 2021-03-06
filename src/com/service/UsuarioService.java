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
import com.entitie.Menutitulo;
import com.entitie.Permiso;
import com.entitie.Usuario;
import com.entities.vo.MenutituloVo;
import com.entities.vo.PerfilVo;
import com.entities.vo.PermisoVo;
import com.entities.vo.UsuarioVo;
import com.util.Constantes;
import com.util.FaceContext;
import com.util.Fechas;

 
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
			
			HttpSession session = FaceContext.getSession();
			session.setAttribute("Usuario", vo);
            session.setAttribute("iUsuarioId", vo.getiUsuarioId());
            
			if(mode.equals("I")){
				PerfilVo perfil = new PerfilVo();
				perfil.setiPerfilId("1");
				vo.setPerfil(perfil);
				/** se crea un nuevo usuario **/
				Usuario usuario= new Usuario(vo);
				usuario.setvUsuario(vo.getPersona().getvEmail());				
				usuario.setdFechaInserta(Fechas.getDate());
				usuario.setcEstadoCodigo(Constantes.estadoActivo);
			    
				//usuario.setPerfil(genericaDao.findEndidad(Perfil.class, 1));
				genericaDao.persistEndidad(usuario);	
			}
			
			resultado=	genericaDao.commitEndidad(transaccion);
			session.setAttribute("MisPermisos",this.usuarioPermisos());
			
		  
		    
			} catch (Exception e) {
			   e.printStackTrace();
			   genericaDao.limpiarInstancia();
			}
		return resultado;
    	
    }
    public List<PermisoVo> usuarioPermisos() {
        
        List<Permiso> list=genericaDao.findEndidadBDList(Permiso.class, " p.perfil.iPerfilId="+FaceContext.getUsuario().getPerfil().getiPerfilId());
        List<PermisoVo> listVo= new ArrayList<PermisoVo>();
        for(Permiso bean:list) {        	
        	PermisoVo vo= new PermisoVo(bean);           
            listVo.add(vo); 
            
        }
        List<Permiso> list1=genericaDao.findEndidadBDList(Permiso.class, " p.usuario.iUsuarioId="+FaceContext.getUsuario().getiUsuarioId());
       
        for(Permiso bean:list1) {        	
        	PermisoVo vo= new PermisoVo(bean);           
            listVo.add(vo); 
            
        }
        
         
        return listVo;
    }
    public List<UsuarioVo> listaUsuarioEmpresa(){
    	 List<Usuario> list=genericaDao.findEndidadBDList(Usuario.class, " p.usuario.iUsuarioId="+FaceContext.getUsuario().getiUsuarioId());
         List<UsuarioVo> listVo= new ArrayList<UsuarioVo>();
         for(Usuario bean:list) {        	
        	 UsuarioVo vo= new UsuarioVo(bean);           
             listVo.add(vo); 
             
         }
		return listVo;
    }
    public List<MenutituloVo> listaMenu(){
    	List<Menutitulo> list=genericaDao.listaEntidadGenerica(Menutitulo.class);
        List<MenutituloVo> listVo= new ArrayList<MenutituloVo>();
        for(Menutitulo bean:list) {        	
        	MenutituloVo vo= new MenutituloVo(bean);           
            listVo.add(vo); 
            
        }
         
        return listVo;
    }
  
}