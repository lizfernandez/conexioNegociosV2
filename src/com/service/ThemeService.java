package com.service;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;

import com.dao.GenericaDao;
import com.entitie.Empresa;
import com.entitie.Plantilla;
import com.entitie.Productos;
import com.entitie.Promocione;
import com.entitie.Seccionplantilla;
import com.entitie.Tiposeccion;
import com.entitie.Usuario;
import com.entities.vo.PromocioneVo;
import com.entities.vo.SeccionplantillaVo;
import com.entities.vo.TiposeccionVo;
import com.util.Constantes;
import com.util.FaceContext;
import com.util.Fechas;
import com.util.Util;

 
@ManagedBean(name = "themeService")
@ApplicationScoped
public class ThemeService  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GenericaDao genericaDao= new GenericaDao();  
	HttpSession session = FaceContext.getSession(); 
	
    public List<SeccionplantillaVo> listaSeccionPlantilla(String tipoSeccion) {
        List<Seccionplantilla> list = new ArrayList<Seccionplantilla>();
        List<SeccionplantillaVo> listVo = new ArrayList<SeccionplantillaVo>();
        String where = " p.usuario.iUsuarioId="+FaceContext.getUserId()
        		+" and p.tipoSeccion.iTipoSeccionId="+tipoSeccion
        		+" order by p.dFechaInserta desc";
        list=genericaDao.findEndidadBDList(Seccionplantilla.class,where);
        
        for(Seccionplantilla bean:list) {        	
        	SeccionplantillaVo vo= new SeccionplantillaVo(bean);           
            listVo.add(vo);
            
        }
         
        return listVo;
    }
    public List<SeccionplantillaVo> listaSeccionPlantillaActiva(String nombreDirectorio) {
        List<Seccionplantilla> list = new ArrayList<Seccionplantilla>();
        List<SeccionplantillaVo> listVo = new ArrayList<SeccionplantillaVo>();
        String whereEmpresa = " p.vNombreDirectorio='"+nombreDirectorio+"'";        		
        List<Empresa>  empresa = genericaDao.findEndidadBDList(Empresa.class, whereEmpresa);
        
        String where = " p.usuario.iUsuarioId="+empresa.get(0).getUsuario().getiUsuarioId()
        		+" and p.cEstadoCodigo='"+Constantes.estadoActivo+"'"
        		+" order by p.tipoSeccion.iTipoSeccionId";
        list=genericaDao.findEndidadBDList(Seccionplantilla.class,where);
        
        for(Seccionplantilla bean:list) {        	
        	SeccionplantillaVo vo= new SeccionplantillaVo(bean);           
            listVo.add(vo);
            
        }
         
        return listVo;
    }
    
     
    public void iduTheme(SeccionplantillaVo vo,TiposeccionVo tipoSeccion,List<SeccionplantillaVo> seccionActivo,  String mode){
    	EntityTransaction transaction = null;
    	boolean resultado = false;
    	try {
    		
    		transaction = genericaDao.entityTransaction();
    		
    		Seccionplantilla obj= new Seccionplantilla(vo);
    	    obj.setUsuario(new Usuario(FaceContext.getUsuario()));
    		obj.setcEstadoCodigo(Constantes.estadoActivo);
			transaction.begin();
			if(mode.equals("I")){
				
				for(SeccionplantillaVo v: seccionActivo){
					if(v.getTipoSeccion().getvNombre().equals(tipoSeccion.getvNombre())){
						
						obj.setTipoSeccion(new Tiposeccion(v.getTipoSeccion()));
						obj.setPlantilla(new Plantilla(v.getPlantilla()));
						Seccionplantilla vActivo = new Seccionplantilla(v);
						vActivo.setcEstadoCodigo(Constantes.estadoInactivo);
						genericaDao.mergeEndidad(vActivo);
					}
				 }
				
				obj.setdFechaInserta(Fechas.getDate());	
				obj.setiUsuarioInserta(Integer.parseInt(FaceContext.getUserId()));
				genericaDao.persistEndidad(obj);			
				resultado = genericaDao.commitEndidad(transaction);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			genericaDao.limpiarInstancia();
		} finally {
			transaction = null;
		}
    }
  
}