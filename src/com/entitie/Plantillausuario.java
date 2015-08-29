package com.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entities.vo.PlantillausuarioVo;


/**
 * The persistent class for the plantillausuario database table.
 * 
 */
@Entity
public class Plantillausuario implements Serializable {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iPlantillaUsuarioId;
	private static final long serialVersionUID = 1L;
	
	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iPlantillaId")
	private Plantilla plantilla;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iUsuarioId")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iTipoSeccionId")	
	private Tiposeccion tipoSeccion ;

	private int iUsuarioActualiza;

	private int iUsuarioInserta;

	private String vAlineado;

	private String vColorBorde;

	private String vColorCabeceraInf;

	private String vColorCabeceraSup;

	private String vColorFondo;

	private String vDescripcion;

	private String vFoto;

	private String vNombre;

	private String vPaginaDestino;

	private String vTipoAnimacion;

	private String vTitulo;

	public Plantillausuario() {
		// TODO Auto-generated constructor stub
	}
	public Plantillausuario(PlantillausuarioVo seccionPlantilla) {
		
		this.iPlantillaUsuarioId = seccionPlantilla.getiPlantillaUsuarioId();
		this.cEstadoCodigo = seccionPlantilla.getcEstadoCodigo();
		this.dFechaActualiza = seccionPlantilla.getdFechaActualiza();
		this.dFechaInserta = seccionPlantilla.getdFechaInserta();
		this.plantilla = seccionPlantilla.getPlantilla()!=null? new Plantilla(seccionPlantilla.getPlantilla()):null;
		this.usuario = seccionPlantilla.getUsuario()!=null? new Usuario(seccionPlantilla.getUsuario()):null;
		this.tipoSeccion = seccionPlantilla.getTipoSeccion()!= null?   new Tiposeccion(seccionPlantilla.getTipoSeccion()) : null;		
		this.iUsuarioActualiza = seccionPlantilla.getiUsuarioActualiza();
		this.iUsuarioInserta = seccionPlantilla.getiUsuarioInserta();
		this.vAlineado = seccionPlantilla.getvAlineado();
		this.vColorBorde = seccionPlantilla.getvColorBorde();
		this.vColorCabeceraInf = seccionPlantilla.getvColorCabeceraInf();
		this.vColorCabeceraSup = seccionPlantilla.getvColorCabeceraSup();
		this.vColorFondo = seccionPlantilla.getvColorFondo();
		this.vDescripcion = seccionPlantilla.getvDescripcion();
		this.vFoto = seccionPlantilla.getvFoto();
		this.vNombre = seccionPlantilla.getvNombre();
		this.vPaginaDestino = seccionPlantilla.getvPaginaDestino();
		this.vTipoAnimacion = seccionPlantilla.getvTipoAnimacion();
		this.vTitulo = seccionPlantilla.getvTitulo();
	}
	

	/**
	 * @return the iPlantillaUsuarioId
	 */
	public String getiPlantillaUsuarioId() {
		return iPlantillaUsuarioId;
	}
	/**
	 * @param iPlantillaUsuarioId the iPlantillaUsuarioId to set
	 */
	public void setiPlantillaUsuarioId(String iPlantillaUsuarioId) {
		this.iPlantillaUsuarioId = iPlantillaUsuarioId;
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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the tipoSeccion
	 */
	public Tiposeccion getTipoSeccion() {
		return tipoSeccion;
	}
	/**
	 * @param tipoSeccion the tipoSeccion to set
	 */
	public void setTipoSeccion(Tiposeccion tipoSeccion) {
		this.tipoSeccion = tipoSeccion;
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
	 * @return the vAlineado
	 */
	public String getvAlineado() {
		return vAlineado;
	}

	/**
	 * @param vAlineado the vAlineado to set
	 */
	public void setvAlineado(String vAlineado) {
		this.vAlineado = vAlineado;
	}

	/**
	 * @return the vColorBorde
	 */
	public String getvColorBorde() {
		return vColorBorde;
	}

	/**
	 * @param vColorBorde the vColorBorde to set
	 */
	public void setvColorBorde(String vColorBorde) {
		this.vColorBorde = vColorBorde;
	}

	/**
	 * @return the vColorCabeceraInf
	 */
	public String getvColorCabeceraInf() {
		return vColorCabeceraInf;
	}

	/**
	 * @param vColorCabeceraInf the vColorCabeceraInf to set
	 */
	public void setvColorCabeceraInf(String vColorCabeceraInf) {
		this.vColorCabeceraInf = vColorCabeceraInf;
	}

	/**
	 * @return the vColorCabeceraSup
	 */
	public String getvColorCabeceraSup() {
		return vColorCabeceraSup;
	}

	/**
	 * @param vColorCabeceraSup the vColorCabeceraSup to set
	 */
	public void setvColorCabeceraSup(String vColorCabeceraSup) {
		this.vColorCabeceraSup = vColorCabeceraSup;
	}

	/**
	 * @return the vColorFondo
	 */
	public String getvColorFondo() {
		return vColorFondo;
	}

	/**
	 * @param vColorFondo the vColorFondo to set
	 */
	public void setvColorFondo(String vColorFondo) {
		this.vColorFondo = vColorFondo;
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
	 * @return the vPaginaDestino
	 */
	public String getvPaginaDestino() {
		return vPaginaDestino;
	}

	/**
	 * @param vPaginaDestino the vPaginaDestino to set
	 */
	public void setvPaginaDestino(String vPaginaDestino) {
		this.vPaginaDestino = vPaginaDestino;
	}

	/**
	 * @return the vTipoAnimacion
	 */
	public String getvTipoAnimacion() {
		return vTipoAnimacion;
	}

	/**
	 * @param vTipoAnimacion the vTipoAnimacion to set
	 */
	public void setvTipoAnimacion(String vTipoAnimacion) {
		this.vTipoAnimacion = vTipoAnimacion;
	}

	/**
	 * @return the vTitulo
	 */
	public String getvTitulo() {
		return vTitulo;
	}

	/**
	 * @param vTitulo the vTitulo to set
	 */
	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}
	/**
	 * @return the plantilla
	 */
	public Plantilla getPlantilla() {
		return plantilla;
	}
	/**
	 * @param plantilla the plantilla to set
	 */
	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	


}