package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.MensajesVo;
import com.entities.vo.UsuarioVo;
import com.util.Fechas;

import java.util.Date;
import java.math.BigInteger;
import java.text.ParseException;


/**
 * The persistent class for the mensajes database table.
 * 
 */
@Entity
@Table(name="mensajes")
public class Mensajes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iMensajesId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private int iUsuarioActualiza;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iUsuarioEnviaId")
	private Usuario usuarioEnvia;

	private int iUsuarioInserta;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iUsuarioRecibeId")
	private Usuario usuarioRecibe;

	private String vEmotion;

	private String vIdentidicador;

	private String vMensaje;
	
	private String cEstadoMensaje;

	public Mensajes() {
	}
public Mensajes(MensajesVo mensaje) throws ParseException {
		
		this.iMensajesId = mensaje.getiMensajesId();
		this.cEstadoCodigo = mensaje.getcEstadoCodigo();
		this.dFechaActualiza = mensaje.getdFechaActualiza();
		this.dFechaInserta =mensaje.getdFechaInserta()!=null? Fechas.fechaDate(mensaje.getdFechaInserta()):null;		
		this.iUsuarioActualiza = mensaje.getiUsuarioActualiza();
		this.usuarioEnvia = mensaje.getUsuarioEnvia()!=null? new Usuario(mensaje.getUsuarioEnvia()):null;
		this.iUsuarioInserta = mensaje.getiUsuarioInserta();
		this.usuarioRecibe = mensaje.getUsuarioRecibe()!=null? new Usuario(mensaje.getUsuarioRecibe()):null;
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
	 * @return the usuarioEnvia
	 */
	public Usuario getUsuarioEnvia() {
		return usuarioEnvia;
	}
	/**
	 * @param usuarioEnvia the usuarioEnvia to set
	 */
	public void setUsuarioEnvia(Usuario usuarioEnvia) {
		this.usuarioEnvia = usuarioEnvia;
	}
	/**
	 * @return the usuarioRecibe
	 */
	public Usuario getUsuarioRecibe() {
		return usuarioRecibe;
	}
	/**
	 * @param usuarioRecibe the usuarioRecibe to set
	 */
	public void setUsuarioRecibe(Usuario usuarioRecibe) {
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

	
	
	
}