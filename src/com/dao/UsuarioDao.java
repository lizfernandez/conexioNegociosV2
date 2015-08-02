package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entitie.Usuario;
import com.interfaces.dao.IUsuarioDao;
import com.util.Constantes;

public class UsuarioDao extends GenericaDao implements IUsuarioDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public List<Usuario> listaUsuario(int pagInicio, int pagFin, Usuario usuario) {
		Query q ;
		List<Usuario> listaUsuario = null ;
		String where="";
    	
		if(usuario!=null){
			if(usuario.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        }
			if(usuario.getcEstadoCodigo()!=null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+usuario.getcEstadoCodigo()+"%'";
	        }
	       
	        System.out.println(" where ="+ where);
	    	    q = getInstancia().createQuery("select p from Usuario p " + where);/**/
	    	    q.setHint(QueryHints.REFRESH, HintValues.TRUE);
	    	    listaUsuario = q.setFirstResult(pagInicio)
							  .setMaxResults(pagFin)
							  .getResultList(); 

			
		}// lista con busqueda
		
		
        return listaUsuario;
	}

	
	@Override
	public List<Usuario> login(String usuario, String pass) {
		Query q ;
		String cadena = "";
		
			cadena = " and p.vContrasena='"+pass+"'";
	
	  List<Usuario> usua = null;
		q= getInstancia().createQuery("select p from Usuario p " +
                   " where p.vUsuario ='"+usuario+"'"+cadena);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
        usua =  (List<Usuario>) q.getResultList(); 
		return usua;
	}

	
	
}
