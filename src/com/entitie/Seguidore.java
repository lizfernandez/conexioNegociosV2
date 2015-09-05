package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.SeguidoreVo;
import com.entities.vo.UsuarioVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the seguidores database table.
 * 
 */
@Entity
@Table(name="seguidores")
public class Seguidore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iSeguidorId;

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

	
    private String vIdentidicador;
    
	public Seguidore() {
	}
	

	public Seguidore(SeguidoreVo seguidores) {
		this.iSeguidorId = seguidores.getiSeguidorId();
		this.cEstadoCodigo = seguidores.getcEstadoCodigo();
		this.dFechaActualiza = seguidores.getdFechaActualiza();
		this.dFechaInserta = seguidores.getdFechaInserta();
		this.iUsuarioActualiza = seguidores.getiUsuarioActualiza();
		this.usuarioEnvia = seguidores.getUsuarioEnvia()!=null? new Usuario(seguidores.getUsuarioEnvia()): null;
		this.iUsuarioInserta = seguidores.getiUsuarioInserta();
		this.usuarioRecibe = seguidores.getUsuarioRecibe()!=null? new Usuario(seguidores.getUsuarioRecibe()):null;
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