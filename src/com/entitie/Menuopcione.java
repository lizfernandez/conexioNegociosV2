package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.MenuopcioneVo;

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iMenuTituloId")
	private Menutitulo menuTitulo;

	private String vCodigo;

	private String vOpciones;

	public Menuopcione() {
	}

	
	public Menuopcione(MenuopcioneVo menuopcione) {
	
		this.iMenuOpcionesId = menuopcione.getiMenuOpcionesId();
		this.dFechaActualiza = menuopcione.getdFechaActualiza();
		this.dFechaInserta = menuopcione.getdFechaInserta();
		this.estadoCodigo = menuopcione.getEstadoCodigo();
		this.menuTitulo = menuopcione.getMenuTitulo()!=null? new Menutitulo(menuopcione.getMenuTitulo()):null;
		this.vCodigo = menuopcione.getvCodigo();
		this.vOpciones =menuopcione.getvOpciones();
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
	 * @return the menuTitulo
	 */
	public Menutitulo getMenuTitulo() {
		return menuTitulo;
	}

	/**
	 * @param menuTitulo the menuTitulo to set
	 */
	public void setMenuTitulo(Menutitulo menuTitulo) {
		this.menuTitulo = menuTitulo;
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