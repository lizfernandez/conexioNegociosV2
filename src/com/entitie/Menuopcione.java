package com.entitie;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the menuopciones database table.
 * 
 */
@Entity
@Table(name="menuopciones")
public class Menuopcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuOpcionesId;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private String estadoCodigo;

	private int iMenuTituloId;

	private String vCodigo;

	private String vOpciones;

	public Menuopcione() {
	}

	/**
	 * @return the iMenuOpcionesId
	 */
	public int getiMenuOpcionesId() {
		return iMenuOpcionesId;
	}

	/**
	 * @param iMenuOpcionesId the iMenuOpcionesId to set
	 */
	public void setiMenuOpcionesId(int iMenuOpcionesId) {
		this.iMenuOpcionesId = iMenuOpcionesId;
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
	 * @return the estadoCodigo
	 */
	public String getEstadoCodigo() {
		return estadoCodigo;
	}

	/**
	 * @param estadoCodigo the estadoCodigo to set
	 */
	public void setEstadoCodigo(String estadoCodigo) {
		this.estadoCodigo = estadoCodigo;
	}

	/**
	 * @return the iMenuTituloId
	 */
	public int getiMenuTituloId() {
		return iMenuTituloId;
	}

	/**
	 * @param iMenuTituloId the iMenuTituloId to set
	 */
	public void setiMenuTituloId(int iMenuTituloId) {
		this.iMenuTituloId = iMenuTituloId;
	}

	/**
	 * @return the vCodigo
	 */
	public String getvCodigo() {
		return vCodigo;
	}

	/**
	 * @param vCodigo the vCodigo to set
	 */
	public void setvCodigo(String vCodigo) {
		this.vCodigo = vCodigo;
	}

	/**
	 * @return the vOpciones
	 */
	public String getvOpciones() {
		return vOpciones;
	}

	/**
	 * @param vOpciones the vOpciones to set
	 */
	public void setvOpciones(String vOpciones) {
		this.vOpciones = vOpciones;
	}

	

}