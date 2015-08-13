package com.entities.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.entitie.Empresa;


/**
 * The persistent class for the empresa database table.
 * 
 */

public class EmpresaVo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int iEmpresaId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private BigInteger iUsuarioActualizaId;
	private UsuarioVo usuario;
	private BigInteger iUsuarioInsertaId;
	private String vDireccionEnvio;

	private String vRazonSocial;

	private String vRuc;

	private String vNombreDirectorio;

	private String vUbigeo;
	private String vFoto;
	private String vDescripcion;
	public EmpresaVo() {
	}
    
	public EmpresaVo(Empresa empresa) {
		
		this.iEmpresaId = empresa.getiEmpresaId();
		this.cEstadoCodigo = empresa.getcEstadoCodigo();
		this.dFechaActualiza = empresa.getdFechaActualiza();
		this.dFechaInserta = empresa.getdFechaInserta();
		this.iUsuarioActualizaId = empresa.getiUsuarioActualizaId();		
		this.iUsuarioInsertaId = empresa.getiUsuarioInsertaId();
		this.vDireccionEnvio = empresa.getvDireccionEnvio();
		this.vRazonSocial = empresa.getvRazonSocial();
		this.vRuc = empresa.getvRuc();
		this.vNombreDirectorio = empresa.getvNombreDirectorio();
		this.vUbigeo = empresa.getvUbigeo();
		this.vFoto=empresa.getvFoto();
		this.vDescripcion=empresa.getvDescripcion();
		
	}

	/**
	 * @return the iEmpresaId
	 */
	public int getiEmpresaId() {
		return iEmpresaId;
	}

	/**
	 * @param iEmpresaId the iEmpresaId to set
	 */
	public void setiEmpresaId(int iEmpresaId) {
		this.iEmpresaId = iEmpresaId;
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
	 * @return the iUsuarioActualizaId
	 */
	public BigInteger getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
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
	 * @return the iUsuarioInsertaId
	 */
	public BigInteger getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the vDireccionEnvio
	 */
	public String getvDireccionEnvio() {
		return vDireccionEnvio;
	}

	/**
	 * @param vDireccionEnvio the vDireccionEnvio to set
	 */
	public void setvDireccionEnvio(String vDireccionEnvio) {
		this.vDireccionEnvio = vDireccionEnvio;
	}

	/**
	 * @return the vRazonSocial
	 */
	public String getvRazonSocial() {
		return vRazonSocial;
	}

	/**
	 * @param vRazonSocial the vRazonSocial to set
	 */
	public void setvRazonSocial(String vRazonSocial) {
		this.vRazonSocial = vRazonSocial;
	}

	/**
	 * @return the vRuc
	 */
	public String getvRuc() {
		return vRuc;
	}

	/**
	 * @param vRuc the vRuc to set
	 */
	public void setvRuc(String vRuc) {
		this.vRuc = vRuc;
	}

	

	/**
	 * @return the vNombreDirectorio
	 */
	public String getvNombreDirectorio() {
		return vNombreDirectorio;
	}

	/**
	 * @param vNombreDirectorio the vNombreDirectorio to set
	 */
	public void setvNombreDirectorio(String vNombreDirectorio) {
		this.vNombreDirectorio = vNombreDirectorio;
	}

	/**
	 * @return the vUbigeo
	 */
	public String getvUbigeo() {
		return vUbigeo;
	}

	/**
	 * @param vUbigeo the vUbigeo to set
	 */
	public void setvUbigeo(String vUbigeo) {
		this.vUbigeo = vUbigeo;
	}

	/**
	 * @return the vFoto
	 */
	public String getvFoto() {
		return vFoto;
	}

	/**
	 * @param vFoto the vFoto to set
	 */
	public void setvFoto(String vFoto) {
		this.vFoto = vFoto;
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