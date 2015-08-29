package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityTransaction;

import com.dao.GenericaDao;
import com.entitie.Mensajes;
import com.entitie.Seguidore;
import com.entitie.Usuario;
import com.entities.vo.MensajesVo;
import com.entities.vo.SeguidoreVo;
import com.entities.vo.UsuarioVo;
import com.util.Constantes;
import com.util.FaceContext;
import com.util.Fechas;

@ManagedBean(name = "mensajesService")
@ApplicationScoped
public class MensajesService {
	GenericaDao genericaDao= new GenericaDao();
	
	public List<SeguidoreVo> listaSeguidores(int iUsuarioDestId){
		  List<SeguidoreVo> listVo = new ArrayList<SeguidoreVo>();	
		  String where=" p.usuarioRecibe.iUsuarioId="+iUsuarioDestId;		     
	      List<Seguidore>  list = genericaDao.findEndidadBDList(Seguidore.class, where);	      
	      for(Seguidore bean:list) {        	
	    	  SeguidoreVo vo= new SeguidoreVo(bean);           
	          listVo.add(vo);
	      }
	      return listVo;
		  
	  }
	public List<MensajesVo> listaMensajesDetalle(String vIdentidicador ){
		  List<MensajesVo> listVo = new ArrayList<MensajesVo>();	
		  String where=" p.vIdentidicador='"+vIdentidicador+"' order by p.dFechaInserta asc";
				        
		     
	      List<Mensajes>  list = genericaDao.findEndidadBDList(Mensajes.class, where);
	      int i=-1;
	      for(Mensajes bean:list) {  
	    	  MensajesVo vo= null;	
	    	  if(bean.getUsuarioEnvia().getiUsuarioId()==FaceContext.getUserId()){	    		 	    	  
	    		  vo= new MensajesVo(bean);	
	    		  vo.setUsuarioRecibe(null);	    		  
	    		  if(i>=0){
	    			  if(listVo.get(i).getUsuarioEnvia()!=null){
			    		 if(listVo.get(i).getUsuarioEnvia().getiUsuarioId()!=vo.getUsuarioEnvia().getiUsuarioId()){
			    			 listVo.add(vo); 	
			    			 i++; 
			    		 }  else{
			    			 listVo.get(i).getListaMensajes().add(vo) ;
			    		 }
	    			  }
	    			  else{
	    				  vo.getListaMensajes().add(vo);
	    				  listVo.add(vo); 	
			    			 i++;  
	    			  }
		    		 }
		    		 else{
		    			 vo.getListaMensajes().add(vo);
		    			 listVo.add(vo); 
		    			 i++; 
		    		 }
	    	  }
	    	  else{
	    		  vo= new MensajesVo(bean);
	    		  vo.setUsuarioRecibe(vo.getUsuarioEnvia());
	    		  vo.setUsuarioEnvia(null);	    		  
	    		 if(i>=0){
	    			 if(listVo.get(i).getUsuarioRecibe()!=null){
			    		 if(listVo.get(i).getUsuarioRecibe().getiUsuarioId()!=vo.getUsuarioRecibe().getiUsuarioId()){
			    			 listVo.add(vo); 	
			    			 i++; 
			    		 } 
			    		 else{
			    			 listVo.get(i).getListaMensajes().add(vo) ;
			    		 }
	    			 }
	    			 else{
	    				 vo.getListaMensajes().add(vo);
	    				 listVo.add(vo); 	
		    			 i++;
	    			 }
	    		 }
	    		 else{
	    			 vo.getListaMensajes().add(vo);
	    			 listVo.add(vo); 
	    			 i++; 
	    		 }
	    		 
	    	  }
	    	            
	      }
	      return listVo;
		  
	  }
	public List<MensajesVo> listaMensajes(int iUsuarioRecibeId ){
		  List<MensajesVo> listVo = new ArrayList<MensajesVo>();	
		  String where=" (p.usuarioRecibe.iUsuarioId="+iUsuarioRecibeId + " or p.usuarioEnvia.iUsuarioId="+iUsuarioRecibeId +")"
				  +" and p.cEstadoMensaje= '"+Constantes.estadoUltimo +"' "
			//	  +" group by p.vIdentidicador " 
				  +" order by p.dFechaInserta desc ";

				        
		     
	      List<Mensajes>  list = genericaDao.findEndidadBDList(Mensajes.class, where);	
	     
	  	

			
	      for(Mensajes bean:list) {        	
	    	  MensajesVo vo= new MensajesVo(bean);	    	   
	            listVo.add(vo);	           
	      }
	      return listVo;
		  
	  }
	public UsuarioVo usuarioMensaje(int iUsuarioId){
		UsuarioVo usu =  new UsuarioVo(genericaDao.findEndidad(Usuario.class, iUsuarioId));
		return usu;
	}
	
	public void iduMensaje(MensajesVo vo, String mode){
		EntityTransaction transaction = null;
    	try {
    		
    		transaction = genericaDao.entityTransaction();
    		
    		Mensajes obj= new Mensajes(vo);
    		obj.setcEstadoCodigo(Constantes.estadoActivo);
			transaction.begin();
			if(mode.equals("I")){
				obj.setcEstadoMensaje(Constantes.estadoInactivo);
				obj.setdFechaInserta(Fechas.getDate());	
				obj.setiUsuarioInserta(FaceContext.getUserId());
				genericaDao.persistEndidad(obj);	
			}
			genericaDao.commitEndidad(transaction);
			
		} catch (Exception e) {
			e.printStackTrace();
			genericaDao.limpiarInstancia();
		} finally {			
			transaction = null;
			
		}
	}
	
}
