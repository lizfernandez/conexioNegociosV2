package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.TiposeccionVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the tiposeccion database table.
 * 
 */
@Entity
public class Tiposeccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iTipoSeccionId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private BigInteger iUsuarioActualiza;

	private BigInteger iUsuarioInserta;

	private String vNombre;
	
	private String vDimensionFoto;

	public Tiposeccion() {
	}
    public Tiposeccion(TiposeccionVo tiposeccion) {
		
		this.iTipoSeccionId = tiposeccion.getiTipoSeccionId();
		this.cEstadoCodigo = tiposeccion.getcEstadoCodigo();
		this.dFechaActualiza = tiposeccion.getdFechaActualiza();
		this.dFechaInserta = tiposeccion.getdFechaInserta();
		this.iUsuarioActualiza = tiposeccion.getiUsuarioActualiza();
		this.iUsuarioInserta = tiposeccion.getiUsuarioInserta();
		this.vNombre = tiposeccion.getvNombre();
		this.vDimensionFoto = tiposeccion.getvDimensionFoto();
	}
	/**
	 * @return the iTipoSeccionId
	 */
	public int getiTipoSeccionId() {
		return iTipoSeccionId;
	}

	/**
	 * @param iTipoSeccionId the iTipoSeccionId to set
	 */
	public void setiTipoSeccionId(int iTipoSeccionId) {
		this.iTipoSeccionId = iTipoSeccionId;
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

	/**
	 * @return the vDimensionFoto
	 */
	public String getvDimensionFoto() {
		return vDimensionFoto;
	}

	/**
	 * @param vDimensionFoto the vDimensionFoto to set
	 */
	public void setvDimensionFoto(String vDimensionFoto) {
		this.vDimensionFoto = vDimensionFoto;
	}

	

}