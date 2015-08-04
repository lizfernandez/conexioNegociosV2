package com.entities.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.entitie.Categoria;


/**
 * The persistent class for the categoria database table.
 * 
 */

public class CategoriaVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iCategoriaId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;	
	private Date dFechaInserta;
	private BigInteger iUsuarioActualiza;	
	private BigInteger iUsuarioInserta;

	private String vNombre;

	public CategoriaVo() {
	}

	
	public CategoriaVo(Categoria categoria) {
		
		this.iCategoriaId = categoria.getiCategoriaId();
		this.cEstadoCodigo = categoria.getcEstadoCodigo();
		this.dFechaActualiza = categoria.getdFechaActualiza();
		this.dFechaInserta = categoria.getdFechaInserta();
		this.iUsuarioActualiza = categoria.getiUsuarioActualiza();
		this.iUsuarioInserta = categoria.getiUsuarioInserta();
		this.vNombre = categoria.getvNombre();
	}


	/**
	 * @return the iCategoriaId
	 */
	public String getiCategoriaId() {
		return iCategoriaId;
	}

	/**
	 * @param iCategoriaId the iCategoriaId to set
	 */
	public void setiCategoriaId(String iCategoriaId) {
		this.iCategoriaId = iCategoriaId;
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
	 * @return the iUsuarioInserta
	 */
	public BigInteger getiUsuarioInserta() {
		return iUsuarioInserta;
	}

	/**
	 * @param iUsuarioInserta the iUsuarioInserta to set
	 */
	public void setiUsuarioInserta(BigInteger iUsuarioInserta) {
		this.iUsuarioInserta = iUsuarioInserta;
	}

	/**
	 * @return the vNombre
	 */
	public String getvNombre() {
		return vNombre;
	}

	/**
	 * @param vNombre the vNombre to set
	 */
	public void setvNombre(String vNombre) {
		this.vNombre = vNombre;
	}

	

}