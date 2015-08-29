package com.entities.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entitie.Mensajes;
import com.util.Fechas;


/**
 * The persistent class for the mensajes database table.
 * 
 */

public class MensajesVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int iMensajesId;
	private String cEstadoCodigo;	
	private Date dFechaActualiza;
	private String dFechaInserta;
	private int iUsuarioActualiza;
	private UsuarioVo usuarioEnvia;
	private int iUsuarioInserta;
	private UsuarioVo usuarioRecibe = new UsuarioVo();
	private String vEmotion;
	private String vIdentidicador;
	private String vMensaje;
	private String cEstadoMensaje;
	private List<MensajesVo> listaMensajes = new ArrayList<MensajesVo>();
  
	public MensajesVo() {
	}

	
	public MensajesVo(Mensajes mensaje) {
		
		this.iMensajesId = mensaje.getiMensajesId();
		this.cEstadoCodigo = mensaje.getcEstadoCodigo();
		this.dFechaActualiza = mensaje.getdFechaActualiza();
		this.dFechaInserta = mensaje.getdFechaInserta()!=null? Fechas.fechaDDMMYY(mensaje.getdFechaInserta()):null;
		this.iUsuarioActualiza = mensaje.getiUsuarioActualiza();
		this.usuarioEnvia = mensaje.getUsuarioEnvia()!=null? new UsuarioVo(mensaje.getUsuarioEnvia()):null;
		this.iUsuarioInserta = mensaje.getiUsuarioInserta();
		this.usuarioRecibe = mensaje.getUsuarioRecibe()!=null? new UsuarioVo(mensaje.getUsuarioRecibe()):null;
		this.vEmotion = mensaje.getvEmotion();
		this.vIdentidicador = mensaje.getvIdentidicador();
		this.vMensaje = mensaje.getvMensaje();
		this.cEstadoMensaje = mensaje.getcEstadoMensaje();
	}


	/**
	 * @return the iMensajesId
	 */
	public int getiMensajesId() {
		return iMensajesId;
	}

	/**
	 * @param iMensajesId the iMensajesId to set
	 */
	public void setiMensajesId(int iMensajesId) {
		this.iMensajesId = iMensajesId;
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
	public String getdFechaInserta() {
		return dFechaInserta;
	}

	/**
	 * @param dFechaInserta the dFechaInserta to set
	 */
	public void setdFechaInserta(String dFechaInserta) {
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
	 * @return the cEstadoMensaje
	 */
	public String getcEstadoMensaje() {
		return cEstadoMensaje;
	}


	/**
	 * @param cEstadoMensaje the cEstadoMensaje to set
	 */
	public void setcEstadoMensaje(String cEstadoMensaje) {
		this.cEstadoMensaje = cEstadoMensaje;
	}


	/**
	 * @return the vEmotion
	 */
	public String getvEmotion() {
		return vEmotion;
	}

	/**
	 * @param vEmotion the vEmotion to set
	 */
	public void setvEmotion(String vEmotion) {
		this.vEmotion = vEmotion;
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

	/**
	 * @return the vMensaje
	 */
	public String getvMensaje() {
		return vMensaje;
	}

	/**
	 * @param vMensaje the vMensaje to set
	 */
	public void setvMensaje(String vMensaje) {
		this.vMensaje = vMensaje;
	}


	/**
	 * @return the listaMensajes
	 */
	public List<MensajesVo> getListaMensajes() {
		return listaMensajes;
	}


	/**
	 * @param listaMensajes the listaMensajes to set
	 */
	public void setListaMensajes(List<MensajesVo> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}


	
	


	
}