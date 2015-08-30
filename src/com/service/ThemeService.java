package com.service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityTransaction;
import com.dao.GenericaDao;
import com.entitie.Plantilla;
import com.entitie.Plantillausuario;
import com.entitie.Tiposeccion;
import com.entitie.Usuario;
import com.entities.vo.PlantillausuarioVo;
import com.entities.vo.TiposeccionVo;
import com.entities.vo.UsuarioVo;
import com.util.Constantes;
import com.util.FaceContext;
import com.util.Fechas;

 
@ManagedBean(name = "themeService")
@ApplicationScoped
public class ThemeService  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GenericaDao genericaDao= new GenericaDao();  
	 
	
    public List<PlantillausuarioVo> listaSeccionPlantilla(String tipoSeccion, String nombreDirectorio) {
        List<Plantillausuario> list = new ArrayList<Plantillausuario>();
        List<PlantillausuarioVo> listVo = new ArrayList<PlantillausuarioVo>();
        String where = " p.usuario.persona.vNombreDirectorio='"+nombreDirectorio+"'"
        		+ "and p.tipoSeccion.iTipoSeccionId="+tipoSeccion
        		+" order by p.dFechaInserta desc";
        list=genericaDao.findEndidadBDList(Plantillausuario.class,where);
        
        for(Plantillausuario bean:list) {        	
        	PlantillausuarioVo vo= new PlantillausuarioVo(bean);           
            listVo.add(vo);
            
        }
         
        return listVo;
    }
    public List<PlantillausuarioVo> listaSeccionPlantillaActiva(String nombreDirectorio) {
        List<Plantillausuario> list = new ArrayList<Plantillausuario>();
        List<PlantillausuarioVo> listVo = new ArrayList<PlantillausuarioVo>();
        String whereEmpresa = " p.persona.vNombreDirectorio='"+nombreDirectorio+"'";        		
        List<Usuario>  empresa = genericaDao.findEndidadBDList(Usuario.class, whereEmpresa);
        
       
      
         
        String where = " p.usuario.iUsuarioId="+empresa.get(0).getiUsuarioId()
        		+" and p.cEstadoCodigo='"+Constantes.estadoActivo+"'"
        		+" order by p.tipoSeccion.iTipoSeccionId";
        list=genericaDao.findEndidadBDList(Plantillausuario.class,where);
        
        for(Plantillausuario bean:list) {        	
        	PlantillausuarioVo vo= new PlantillausuarioVo(bean);           
            listVo.add(vo);
            
        }
         
        return listVo;
    }
    
     
    public void iduTheme(PlantillausuarioVo vo,TiposeccionVo tipoSeccion,List<PlantillausuarioVo> seccionActivo,  String mode){
    	EntityTransaction transaction = null;
    	try {
    		
    		transaction = genericaDao.entityTransaction();
    		
    		Plantillausuario obj= new Plantillausuario(vo);
    	    obj.setUsuario(new Usuario(FaceContext.getUsuario()) );
    		obj.setcEstadoCodigo(Constantes.estadoActivo);
			transaction.begin();
			if(mode.equals("I")){
				
				for(PlantillausuarioVo v: seccionActivo){
					if(v.getTipoSeccion().getvNombre().equals(tipoSeccion.getvNombre())){
						
						obj.setTipoSeccion(new Tiposeccion(v.getTipoSeccion()));
						obj.setPlantilla(new Plantilla(v.getPlantilla()));
						Plantillausuario vActivo = new Plantillausuario(v);
						vActivo.setcEstadoCodigo(Constantes.estadoInactivo);
						vActivo.getUsuario().getPersona().setvFoto(obj.getvFoto());
						genericaDao.mergeEndidad(vActivo);
						break;
					}
				 }
				/***
				 * Actualizamo la foto de la empresa
				 */
				Usuario em= genericaDao.findEndidad(Usuario.class,FaceContext.getUsuario().getiUsuarioId());	
				em.getPersona().setvFoto(obj.getvFoto());
				genericaDao.mergeEndidad(em);
				
				obj.setdFechaInserta(Fechas.getDate());	
				obj.setiUsuarioInserta(FaceContext.getUserId());
				genericaDao.persistEndidad(obj);
				genericaDao.commitEndidad(transaction);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			genericaDao.limpiarInstancia();
		} finally {			
			transaction = null;
			
		}
    }
  public List<UsuarioVo> listaEmpresa(){
	  List<UsuarioVo> listVo = new ArrayList<UsuarioVo>();	
	  String where=" p.persona.vRazonSocial IS NOT NULL";
      List<Usuario>  list = genericaDao.findEndidadBDList(Usuario.class,where);
      
      for(Usuario bean:list) {        	
    	  UsuarioVo vo= new UsuarioVo(bean);           
          listVo.add(vo);
          
      }
       
      return listVo;
	  
  }
}