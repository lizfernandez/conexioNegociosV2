package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.PersonaVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iPersonaId;

	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaNacimiento;

	private float fSueldo;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	private String vApellidos;

	private String vDireccionEnvio;

	private String vEmail;
	
	private String vTelefono;

	private String vNombres;

	private String vUbicacion;
	
    private String vFoto;
    
    private String vRazonSocial;
    
    private String vRuc;
    
    private String vNombreDirectorio;
    
    private String vUbigeo;
    
    private String vDescripcion;
    
	public Persona() {
	}
	public Persona(PersonaVo persona) {
		
		this.iPersonaId = persona.getiPersonaId();
		this.cEstadoCodigo = persona.getcEstadoCodigo();
		this.dFechaActualiza = persona.getdFechaActualiza();
		this.dFechaInserta = persona.getdFechaInserta();
		this.dFechaNacimiento = persona.getdFechaNacimiento();
		this.fSueldo = persona.getfSueldo();
		this.iUsuarioActualizaId = persona.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = persona.getiUsuarioInsertaId();
		this.vApellidos = persona.getvApellidos();
		this.vDireccionEnvio = persona.getvDireccionEnvio();
		this.vEmail = persona.getvEmail();
		this.vTelefono = persona.getvTelefono();
		this.vNombres = persona.getvNombres();
		this.vUbicacion = persona.getvUbicacion();
		this.vFoto = persona.getvFoto();
		this.vRazonSocial= persona.getvRazonSocial();
		this.vRuc=persona.getvRuc();
		this.vNombreDirectorio= persona.getvNombreDirectorio();
		this.vUbigeo = persona.getvUbigeo();
		this.vDescripcion=persona.getvDescripcion();
	}

	/**
	 * @return the iPersonaId
	 */
	public int getiPersonaId() {
		return iPersonaId;
	}

	/**
	 * @param iPersonaId the iPersonaId to set
	 */
	public void setiPersonaId(int iPersonaId) {
		this.iPersonaId = iPersonaId;
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
	 * @return the dFechaNacimiento
	 */
	public Date getdFechaNacimiento() {
		return dFechaNacimiento;
	}

	/**
	 * @param dFechaNacimiento the dFechaNacimiento to set
	 */
	public void setdFechaNacimiento(Date dFechaNacimiento) {
		this.dFechaNacimiento = dFechaNacimiento;
	}

	/**
	 * @return the fSueldo
	 */
	public float getfSueldo() {
		return fSueldo;
	}

	/**
	 * @param fSueldo the fSueldo to set
	 */
	public void setfSueldo(float fSueldo) {
		this.fSueldo = fSueldo;
	}

	/**
	 * @return the iUsuarioActualizaId
	 */
	public BigInteger getiUsuarioActualizaId() {
		return iUsuarioActualizaId;
	}

	/**
	 * @param iUsuarioActualizaId the iUsuarioActualizaId to set
	 */
	public void setiUsuarioActualizaId(BigInteger iUsuarioActualizaId) {
		this.iUsuarioActualizaId = iUsuarioActualizaId;
	}

	/**
	 * @return the iUsuarioInsertaId
	 */
	public BigInteger getiUsuarioInsertaId() {
		return iUsuarioInsertaId;
	}

	/**
	 * @param iUsuarioInsertaId the iUsuarioInsertaId to set
	 */
	public void setiUsuarioInsertaId(BigInteger iUsuarioInsertaId) {
		this.iUsuarioInsertaId = iUsuarioInsertaId;
	}

	/**
	 * @return the vApellidos
	 */
	public String getvApellidos() {
		return vApellidos;
	}

	/**
	 * @param vApellidos the vApellidos to set
	 */
	public void setvApellidos(String vApellidos) {
		this.vApellidos = vApellidos;
	}

	/**
	 * @return the vDireccionEnvio
	 */
	public String getvDireccionEnvio() {
		return vDireccionEnvio;
	}

	/**
	 * @param vDireccionEnvio the vDireccionEnvio to set
	 */
	public void setvDireccionEnvio(String vDireccionEnvio) {
		this.vDireccionEnvio = vDireccionEnvio;
	}

	/**
	 * @return the vEmail
	 */
	public String getvEmail() {
		return vEmail;
	}

	/**
	 * @param vEmail the vEmail to set
	 */
	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}

	/**
	 * @return the vNombres
	 */
	public String getvNombres() {
		return vNombres;
	}

	/**
	 * @param vNombres the vNombres to set
	 */
	public void setvNombres(String vNombres) {
		this.vNombres = vNombres;
	}

	/**
	 * @return the vUbicacion
	 */
	public String getvUbicacion() {
		return vUbicacion;
	}

	/**
	 * @param vUbicacion the vUbicacion to set
	 */
	public void setvUbicacion(String vUbicacion) {
		this.vUbicacion = vUbicacion;
	}
	/**
	 * @return the vTelefono
	 */
	public String getvTelefono() {
		return vTelefono;
	}
	/**
	 * @param vTelefono the vTelefono to set
	 */
	public void setvTelefono(String vTelefono) {
		this.vTelefono = vTelefono;
	}
	/**
	 * @return the vFoto
	 */
	public String getvFoto() {
		return vFoto;
	}
	/**
	 * @param vFoto the vFoto to set
	 */
	public void setvFoto(String vFoto) {
		this.vFoto = vFoto;
	}
	/**
	 * @return the vRazonSocial
	 */
	public String getvRazonSocial() {
		return vRazonSocial;
	}
	/**
	 * @param vRazonSocial the vRazonSocial to set
	 */
	public void setvRazonSocial(String vRazonSocial) {
		this.vRazonSocial = vRazonSocial;
	}
	/**
	 * @return the vRuc
	 */
	public String getvRuc() {
		return vRuc;
	}
	/**
	 * @param vRuc the vRuc to set
	 */
	public void setvRuc(String vRuc) {
		this.vRuc = vRuc;
	}
	/**
	 * @return the vNombreDirectorio
	 */
	public String getvNombreDirectorio() {
		return vNombreDirectorio;
	}
	/**
	 * @param vNombreDirectorio the vNombreDirectorio to set
	 */
	public void setvNombreDirectorio(String vNombreDirectorio) {
		this.vNombreDirectorio = vNombreDirectorio;
	}
	/**
	 * @return the vUbigeo
	 */
	public String getvUbigeo() {
		return vUbigeo;
	}
	/**
	 * @param vUbigeo the vUbigeo to set
	 */
	public void setvUbigeo(String vUbigeo) {
		this.vUbigeo = vUbigeo;
	}
	/**
	 * @return the vDescripcion
	 */
	public String getvDescripcion() {
		return vDescripcion;
	}
	/**
	 * @param vDescripcion the vDescripcion to set
	 */
	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	

}