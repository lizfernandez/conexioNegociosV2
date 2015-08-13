package com.service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityTransaction;

import com.dao.GenericaDao;
import com.entitie.Empresa;
import com.entitie.Plantilla;
import com.entitie.Plantillausuario;
import com.entitie.Tiposeccion;
import com.entities.vo.EmpresaVo;
import com.entities.vo.PlantillausuarioVo;
import com.entities.vo.TiposeccionVo;
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
	 
	
    public List<PlantillausuarioVo> listaSeccionPlantilla(String tipoSeccion) {
        List<Plantillausuario> list = new ArrayList<Plantillausuario>();
        List<PlantillausuarioVo> listVo = new ArrayList<PlantillausuarioVo>();
        String where = " p.usuario.iUsuarioId="+FaceContext.getUserId()
        		+" and p.tipoSeccion.iTipoSeccionId="+tipoSeccion
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
        String whereEmpresa = " p.vNombreDirectorio='"+nombreDirectorio+"'";        		
        List<Empresa>  empresa = genericaDao.findEndidadBDList(Empresa.class, whereEmpresa);
        
       
      
         
        String where = " p.empresa.iEmpresaId="+empresa.get(0).getiEmpresaId()
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
    	    obj.setEmpresa(genericaDao.findEndidad(Empresa.class, FaceContext.getiEmpresaId()));
    		obj.setcEstadoCodigo(Constantes.estadoActivo);
			transaction.begin();
			if(mode.equals("I")){
				
				for(PlantillausuarioVo v: seccionActivo){
					if(v.getTipoSeccion().getvNombre().equals(tipoSeccion.getvNombre())){
						
						obj.setTipoSeccion(new Tiposeccion(v.getTipoSeccion()));
						obj.setPlantilla(new Plantilla(v.getPlantilla()));
						Plantillausuario vActivo = new Plantillausuario(v);
						vActivo.setcEstadoCodigo(Constantes.estadoInactivo);
						genericaDao.mergeEndidad(vActivo);
					}
				 }
				
				obj.setdFechaInserta(Fechas.getDate());	
				obj.setiUsuarioInserta(FaceContext.getUserId());
				genericaDao.persistEndidad(obj);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			genericaDao.limpiarInstancia();
		} finally {
			transaction = null;
		}
    }
  public List<EmpresaVo> listaEmpresa(){
	  List<EmpresaVo> listVo = new ArrayList<EmpresaVo>();	
      List<Empresa>  list = genericaDao.listaEntidadGenerica(Empresa.class);
      
      for(Empresa bean:list) {        	
      	EmpresaVo vo= new EmpresaVo(bean);           
          listVo.add(vo);
          
      }
       
      return listVo;
	  
  }
}