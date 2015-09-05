package com.entities.vo;

import java.io.Serializable;
import java.util.Date;

import com.entitie.Seguidore;


/**
 * The persistent class for the seguidores database table.
 * 
 */

public class SeguidoreVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iSeguidorId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;
	private int iUsuarioActualiza;
	private UsuarioVo usuarioEnvia;
	private int iUsuarioInserta;
	private UsuarioVo usuarioRecibe;
	private String vIdentidicador;

	public SeguidoreVo() {
	}
	

	public SeguidoreVo(Seguidore seguidores) {
		this.iSeguidorId = seguidores.getiSeguidorId();
		this.cEstadoCodigo = seguidores.getcEstadoCodigo();
		this.dFechaActualiza = seguidores.getdFechaActualiza();
		this.dFechaInserta = seguidores.getdFechaInserta();
		this.iUsuarioActualiza = seguidores.getiUsuarioActualiza();
		this.usuarioEnvia = seguidores.getUsuarioEnvia()!=null? new UsuarioVo(seguidores.getUsuarioEnvia()): null;
		this.iUsuarioInserta = seguidores.getiUsuarioInserta();
		this.usuarioRecibe = seguidores.getUsuarioRecibe()!=null? new UsuarioVo(seguidores.getUsuarioRecibe()):null;
		this.vIdentidicador=seguidores.getvIdentidicador();
	}


	/**
	 * @return the iSeguidorId
	 */
	public int getiSeguidorId() {
		return iSeguidorId;
	}


	/**
	 * @param iSeguidorId the iSeguidorId to set
	 */
	public void setiSeguidorId(int iSeguidorId) {
		this.iSeguidorId = iSeguidorId;
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
	public int getiUsuarioActualiza() {
		return iUsuarioActualiza;
	}


	/**
	 * @param iUsuarioActualiza the iUsuarioActualiza to set
	 */
	public void setiUsuarioActualiza(int iUsuarioActualiza) {
		this.iUsuarioActualiza = iUsuarioActualiza;
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
	 * @return the usuarioEnvia
	 */
	public UsuarioVo getUsuarioEnvia() {
		return usuarioEnvia;
	}


	/**
	 * @param usuarioEnvia the usuarioEnvia to set
	 */
	public void setUsuarioEnvia(UsuarioVo usuarioEnvia) {
		this.usuarioEnvia = usuarioEnvia;
	}


	/**
	 * @return the usuarioRecibe
	 */
	public UsuarioVo getUsuarioRecibe() {
		return usuarioRecibe;
	}


	/**
	 * @param usuarioRecibe the usuarioRecibe to set
	 */
	public void setUsuarioRecibe(UsuarioVo usuarioRecibe) {
		this.usuarioRecibe = usuarioRecibe;
	}


	/**
	 * @return the vIdentidicador
	 */
	public String getvIdentidicador() {
		return vIdentidicador;
	}


	/**
	 * @param vIdentidicador the vIdentidicador to set
	 */
	public void setvIdentidicador(String vIdentidicador) {
		this.vIdentidicador = vIdentidicador;
	}


	
	
	

}