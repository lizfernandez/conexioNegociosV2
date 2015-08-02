package com.entitie;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entities.vo.MenutituloVo;


/**
 * The persistent class for the menutitulo database table.
 * 
 */
@Entity
public class Menutitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMenuTituloId;

	@Temporal(TemporalType.DATE)
	private Date dFechaActualiza;

	@Temporal(TemporalType.DATE)
	private Date dFechaInserta;

	private String estadoCodigo;

	private String vCodigo;

	private String vMenuTitulo;
	
	@OneToMany(mappedBy="menuTitulo")
	private List<Menuopcione> menuOpciones;

	public Menutitulo() {
	}

	
	public Menutitulo(MenutituloVo menuTitulo) {
		
		this.iMenuTituloId = menuTitulo.getiMenuTituloId();
		this.dFechaActualiza = menuTitulo.getdFechaActualiza();
		this.dFechaInserta = menuTitulo.getdFechaInserta();
		this.estadoCodigo = menuTitulo.getEstadoCodigo();
		this.vCodigo = menuTitulo.getvCodigo();
		this.vMenuTitulo = menuTitulo.getvMenuTitulo();
		
		 
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
	 * @return the vMenuTitulo
	 */
	public String getvMenuTitulo() {
		return vMenuTitulo;
	}

	/**
	 * @param vMenuTitulo the vMenuTitulo to set
	 */
	public void setvMenuTitulo(String vMenuTitulo) {
		this.vMenuTitulo = vMenuTitulo;
	}


	/**
	 * @return the menuOpciones
	 */
	public List<Menuopcione> getMenuOpciones() {
		return menuOpciones;
	}


	/**
	 * @param menuOpciones the menuOpciones to set
	 */
	public void setMenuOpciones(List<Menuopcione> menuOpciones) {
		this.menuOpciones = menuOpciones;
	}

	

}