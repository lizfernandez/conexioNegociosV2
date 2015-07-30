package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.PermisoVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the permisos database table.
 * 
 */
@Entity
@Table(name="permisos")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iPermisoId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iPerfilId")
	private Perfil perfil ;

	private BigInteger iUsuarioActualiza;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iUsuarioId")
	private Usuario usuario;

	private int iUsuarioInserta;

	private String vCodigoPermiso;

	public Permiso() {
	}

	
	public Permiso(PermisoVo permiso) {
		
		this.iPermisoId = permiso.getiPermisoId();
		this.cEstadoCodigo =permiso.getcEstadoCodigo();
		this.dFechaActualiza = permiso.getdFechaActualiza();
		this.dFechaInserta = permiso.getdFechaInserta();
		this.perfil = permiso.getPerfil()!=null? new Perfil(permiso.getPerfil()):null;
		this.iUsuarioActualiza = permiso.getiUsuarioActualiza();
		this.usuario = permiso.getUsuario()!=null? new Usuario(permiso.getUsuario()):null;
		this.iUsuarioInserta = permiso.getiUsuarioInserta();
		this.vCodigoPermiso = permiso.getvCodigoPermiso();
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
	public Perfil getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
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

	

}