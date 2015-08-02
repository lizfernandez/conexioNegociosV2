package com.entities.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entitie.Menuopcione;
import com.entitie.Menutitulo;


/**
 * The persistent class for the menutitulo database table.
 * 
 */

public class MenutituloVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iMenuTituloId;
    private Date dFechaActualiza;
	private Date dFechaInserta;

	private String estadoCodigo;

	

	private String vCodigo;

	private String vMenuTitulo;
	
	private List<MenuopcioneVo> menuOpciones;

	public MenutituloVo() {
	}
    public MenutituloVo(Menutitulo menuTitulo) {
		
		this.iMenuTituloId = menuTitulo.getiMenuTituloId();
		this.dFechaActualiza = menuTitulo.getdFechaActualiza();
		this.dFechaInserta = menuTitulo.getdFechaInserta();
		this.estadoCodigo = menuTitulo.getEstadoCodigo();
		this.vCodigo = menuTitulo.getvCodigo();
		this.vMenuTitulo = menuTitulo.getvMenuTitulo();
		
		if(menuOpciones!=null){
			this.menuOpciones = new ArrayList<MenuopcioneVo>();
			 for(Menuopcione vo:menuTitulo.getMenuOpciones()){				
					MenuopcioneVo e= new MenuopcioneVo(vo);
					this.menuOpciones.add(e);
				}
		}
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
	public List<MenuopcioneVo> getMenuOpciones() {
		return menuOpciones;
	}
	/**
	 * @param menuOpciones the menuOpciones to set
	 */
	public void setMenuOpciones(List<MenuopcioneVo> menuOpciones) {
		this.menuOpciones = menuOpciones;
	}

	

}