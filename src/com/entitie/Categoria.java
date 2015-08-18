package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.CategoriaVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iCategoriaId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualiza;	

	private BigInteger iUsuarioInserta;

	private String vNombre;

	public Categoria() {
	}

	
	public Categoria(CategoriaVo categoria) {
		
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
	public int getiCategoriaId() {
		return iCategoriaId;
	}

	/**
	 * @param iCategoriaId the iCategoriaId to set
	 */
	public void setiCategoriaId(int iCategoriaId) {
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