package com.dao;



import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;


import com.interfaces.dao.IGenerica;
import com.util.Constantes;
import com.util.FormatosNumeros;

public class GenericaDao  implements IGenerica, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3684383685578181407L;
	private static final String PERSISTENCE_UNIT_NAME = "conexioNegociosV001";
	//private static EntityManagerFactory factory;
	private static EntityManager em;
	boolean resultado = true;
	
	@Override
	public EntityManager getInstancia() {
		if(em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
		}
		return em;
	}
	
	public EntityManager setIntancia(){
		em=null;
		return em;
	}

	public void limpiarInstancia(){
		em = null;
	}
	
    public EntityTransaction entityTransaction() {
		EntityTransaction trx = null;
		if(trx == null) {
			trx = getInstancia().getTransaction();			
		}
		return trx;
	}
   
	public <E> Long totalLista(E entidad) {
		Query q = getInstancia().createQuery("select Count(p) from "+entidad.getClass().getSimpleName()+" p " +
                   " where p.cEstadoCodigo = :EstadoCodigo");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		Long total = (Long) q.setParameter("EstadoCodigo", Constantes.estadoActivo)
				  .getSingleResult(); 
		return total;
	}


	@Override
	public <G> List<G> listaEntidadGenerica(Class<G> entidad) {

		Query q = getInstancia().createQuery("select p from " + entidad.getSimpleName() + "  p" + " where p.cEstadoCodigo = :EstadoCodigo");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		@SuppressWarnings("unchecked")
		List<G> lista = q.setParameter("EstadoCodigo", Constantes.estadoActivo).getResultList();
		return lista;
	}
	
	@Override
	public <G> List<G> listaEntidadGenericaSinCodigo(String entidad) {
		Query q =  getInstancia().createQuery("select p from "+entidad +"  p");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		@SuppressWarnings("unchecked")
		List<G> lista = q.getResultList(); 
		return lista;
	}


//	@Override
//	public <E> E findEndidad(E entidad, int iEntidadId) {
//		HashMap findProperties = new HashMap();
//		findProperties.put(QueryHints.CACHE_RETRIEVE_MODE, CacheRetrieveMode.BYPASS);
//		findProperties.put(QueryHints.CACHE_STORE_MODE, CacheStoreMode.USE);
//		@SuppressWarnings("unchecked")
//		E objeto = (E) getInstancia().find(entidad.getClass(), iEntidadId,findProperties);		
//		return objeto;
//	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <E> E findEndidad(Class<E> entidad, int iEntidadId) {
		HashMap findProperties = new HashMap();
		findProperties.put(QueryHints.CACHE_RETRIEVE_MODE, CacheRetrieveMode.BYPASS);
		findProperties.put(QueryHints.CACHE_STORE_MODE, CacheStoreMode.USE);
		E objeto = (E) getInstancia().find(entidad, iEntidadId,findProperties);		
		return objeto;
	}
	
//	@Override
//	public <E> E findEndidadBD(E entidad, String siEntidadId , int iEntidadId) {
//
//		Query q = getInstancia().createQuery("select p from " + entidad.getClass().getSimpleName() + "  p" + " where p."+siEntidadId+" = :iEntidadId");
//		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
//		@SuppressWarnings("unchecked")
//		E objeto = (E)q.setParameter("iEntidadId", iEntidadId).getSingleResult();
//		return objeto;
//	}
	
	@Override
	public <E> E findEndidadBD(Class<E> entidad, String siEntidadId , int iEntidadId) {

		Query q = getInstancia().createQuery("select p from " + entidad.getSimpleName() + "  p" + " where p."+siEntidadId+" = :iEntidadId");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		@SuppressWarnings("unchecked")
		E objeto = (E)q.setParameter("iEntidadId", iEntidadId).getSingleResult();
		return objeto;
	}
	@Override
	public <E> List<E> findEndidadBDList(Class<E> entidad, String siEntidadId) {

		Query q = getInstancia().createQuery("select p from " + entidad.getSimpleName() + "  p" + " where "+siEntidadId);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		@SuppressWarnings("unchecked")
		List<E> objeto = (List<E>)q.getResultList();
		return objeto;
	}
	public <E> List<E> createNativeQuery(Class<E> entidad, Object o, String siEntidadId){
		List<E> objetoDestino = new ArrayList<E>();
		
		Query q = getInstancia().createNativeQuery("select * from " + entidad.getSimpleName() + "  p" + " where "+siEntidadId);		
		@SuppressWarnings("unchecked")
		List<E> objeto = (List<E>)q.getResultList();
		
		for (int i = 0; i < objeto.size(); i++) {
			Object[] objOrigen = (Object[]) objeto.get(i);
			E  objDestino =  (E) o;
			Field[] fields = objDestino.getClass().getDeclaredFields();
			int j=0;
			for (Field f : fields) {
				try {
					String fieldOrigen = f.getName();
					f.setAccessible(true);
					if(!Constantes.CAMPO_SERAILIZABLE.equals(fieldOrigen)){
									
					
					//Object fieldValue = f.get(objDestino);
					
					if (objOrigen[j] != null) {
						if (!objOrigen[j].toString().equals("0")) {
							System.out.println(f.getType());
							//if(f.getType().equals(obj))
							f.set(objDestino, objOrigen[j]);
							System.out.println("fDestino +"+f.get(objDestino));
							
							}
					}
					j++;
				 }
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			objetoDestino.add((E) objDestino);
		}
		return objetoDestino;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public <G> List<G> listaEntidadPaginada(String sentencia, int pagInicio, int pagFin) {
		Query query;
		List<G> listaEntidad = null;
		query = getInstancia().createQuery(sentencia);
		query.setHint(QueryHints.REFRESH, HintValues.TRUE);

		listaEntidad = query.setFirstResult(pagInicio).setMaxResults(pagFin).getResultList();

		return listaEntidad;
	}
	
	@Override
	public boolean commitEndidad(EntityTransaction ext) {
		boolean resultado = true;
		try {
			
			ext.commit();
			// ext= null;
		} catch (Exception re) {
			resultado = false;
//			if (ext.isActive()) {
				//revertirCambios(ext);
				// resultado = false;
//			} // or could attempt to fix error and retry
			re.printStackTrace();
			limpiarInstancia();
		} finally {
			ext = null;
			//limpiarInstancia();
			// em=null;
		}
		return resultado;

	}
	
	@Override
	public <E> void persistEndidad(E entidad) {
			getInstancia().persist(entidad);
	   
	}
	@Override
	public <E> boolean insertarUnaEndidad(E entidad) {
		// TODO Auto-generated method stub
		EntityTransaction ext;
		try {
			resultado = false;
			ext = entityTransaction();
			ext.begin();
			getInstancia().persist(entidad);
			resultado = commitEndidad(ext);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ext = null;
		}

		return resultado;
	}
	
	@Override
	public <E> void refreshEndidad(E entidad) {
		getInstancia().refresh(entidad);
		limpiarInstancia();

	}
	
	@Override
	public <E> void mergeEndidad(E entidad) {
		getInstancia().merge(entidad);		
	}
	
	@Override
	public <E> boolean actualizarUnaEndidad(E entidad) {
		EntityTransaction ext;
		try {
			resultado = false;
			ext = entityTransaction();
			ext.begin();
			getInstancia().merge(entidad);
			resultado = commitEndidad(ext);
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			ext = null;
		}		
		return resultado;
	}

	@Override
	public <E> void eliminarUnaEndidad(E entidad, String sEntidadId, String iEntidadId) {
		Query q;
		q = getInstancia().createQuery("Update " + entidad.getClass().getSimpleName()
								+ " p SET p.cEstadoCodigo = :EstadoCodigo "
								+ " where p." + sEntidadId + " IN ("
								+ iEntidadId + ")").
								setParameter("EstadoCodigo", Constantes.estadoInactivo);
		q.executeUpdate();

	}
	

	@Override
	public <E> String callSPCalculoCodigo(E entidad) {
		// TODO Auto-generated method stub
		Query q;

		String codigoGenerado = "";
		try {
			/*ext = entityTransaction();
			ext.begin();
*/
			q = getInstancia().createNativeQuery("{ CALL SP_CALCULO_CODIGO(?) }") // createNamedQuery("SP_IDU_PERFIL_PERMISOS")
					.setParameter(1, entidad.getClass().getSimpleName());
			// q.executeUpdate();// SOBRA, el getSingleResult lo hace por el
			codigoGenerado = (String) q.getSingleResult();
		 // resultado = commitEndidad(ext);

		} catch (Exception ex) {
			ex.printStackTrace();
			limpiarInstancia();
		}
		return codigoGenerado;

	}

	@Override
	public int callSPPeriodoActual() {

		Query q;
		int iPeriodoId = 0;
		try {
			/*ext = entityTransaction();
			ext.begin();
*/
			q = em.createNativeQuery("{ CALL SP_PERIODO_ACTUAL() }");
			// q.executeUpdate();// SOBRA, el getSingleResult lo hace por el
			iPeriodoId = (Integer) q.getSingleResult();
			//resultado = commitEndidad(ext);
		} catch (Exception ex) {
			ex.printStackTrace();
			limpiarInstancia();
		}
		return iPeriodoId;
	}

	@Override
	public void revertirCambios(EntityTransaction ext) {
		try {
			if (ext != null) {
				ext.rollback();
			}
		} catch (Exception e) {
			System.err.println("Error al ejecutar roolback: " + e);
			e.printStackTrace();
			limpiarInstancia();
		} finally {
			ext = null;
		}
	}
	@Override
	public String callSPNro_Documento(int iTipoDocumentoId,String tabla, String campoTablaNumeroDoc, int iSucursalId) {
		Query q;

		String nroDocumento = "";

		try {

//			getInstancia().getTransaction().begin();
			q = getInstancia()
					.createNativeQuery("{ CALL SP_NRO_DOCUMENTO(?,?,?,?) }")// createNamedQuery("SP_IDU_PERFIL_PERMISOS")
					.setParameter(1, iTipoDocumentoId)
					.setParameter(2, tabla)
					.setParameter(3, campoTablaNumeroDoc)
			        .setParameter(4, iSucursalId);

			nroDocumento = (String) q.getSingleResult();
//			getInstancia().getTransaction().commit();
			/***** q.executeUpdate(); **/
		} catch (Exception ex) {
			ex.printStackTrace();
			limpiarInstancia();
		}

		return nroDocumento;
	}
	
}




	



