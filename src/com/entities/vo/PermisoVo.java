package com.entities.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.entitie.Permiso;


/**
 * The persistent class for the permisos database table.
 * 
 */

public class PermisoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iPermisoId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private PerfilVo perfil;
	private BigInteger iUsuarioActualiza;
	private UsuarioVo usuario;

	private int iUsuarioInserta;

	private String vCodigoPermiso;
	private String vDescripcion;

	public PermisoVo() {
	}
	
    public PermisoVo(Permiso permiso) {
		
		this.iPermisoId = permiso.getiPermisoId();
		this.cEstadoCodigo =permiso.getcEstadoCodigo();
		this.dFechaActualiza = permiso.getdFechaActualiza();
		this.dFechaInserta = permiso.getdFechaInserta();
		this.perfil = permiso.getPerfil()!=null? new PerfilVo(permiso.getPerfil()):null;
		this.iUsuarioActualiza = permiso.getiUsuarioActualiza();
		this.usuario = permiso.getUsuario()!=null? new UsuarioVo(permiso.getUsuario()):null;
		this.iUsuarioInserta = permiso.getiUsuarioInserta();
		this.vCodigoPermiso = permiso.getvCodigoPermiso();
		this.vDescripcion=permiso.getvDescripcion();
	}
	/**
	 * @return the iPermisoId
	 */
	public String getiPermisoId() {
		return iPermisoId;
	}

	/**
	 * @param iPermisoId the iPermisoId to set
	 */
	public void setiPermisoId(String iPermisoId) {
		this.iPermisoId = iPermisoId;
	}

	/**
	 * @return the cEstadoCodigo
	 */
	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	/**
	 * @param cEstadoCodigo the cEstadoCodigo to set
	 */
	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	/**
	 * @return the dFechaActualiza
	 */
	public Date getdFechaActualiza() {
		return dFechaActualiza;
	}

	/**
	 * @param dFechaActualiza the dFechaActualiza to set
	 */
	public void setdFechaActualiza(Date dFechaActualiza) {
		this.dFechaActualiza = dFechaActualiza;
	}

	/**
	 * @return the dFechaInserta
	 */
	public Date getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(Date dFechaInserta) {
		this.dFechaInserta = dFechaInserta;
	}

	

	/**
	 * @return the iUsuarioActualiza
	 */
	public BigInteger getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}

	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(BigInteger iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
	}

	
	/**
	 * @return the perfil
	 */
	public PerfilVo getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilVo perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioVo getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioVo usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the iUsuarioInserta
	 */
	public int getiUsuarioInserta() {
		return iUsuarioInserta;
	}

	/**
	 * @param iUsuarioInserta the iUsuarioInserta to set
	 */
	public void setiUsuarioInserta(int iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	/**
	 * @return the vCodigoPermiso
	 */
	public String getvCodigoPermiso() {
		return vCodigoPermiso;
	}

	/**
	 * @param vCodigoPermiso the vCodigoPermiso to set
	 */
	public void setvCodigoPermiso(String vCodigoPermiso) {
		this.vCodigoPermiso = vCodigoPermiso;
	}

	/**
	 * @return the vDescripcion
	 */
	public String getvDescripcion() {
		return vDescripcion;
	}

	/**
	 * @param vDescripcion the vDescripcion to set
	 */
	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	

}