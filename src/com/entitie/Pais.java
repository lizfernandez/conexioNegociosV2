package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.PaisVo;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iPaisId;

	private String cEstadoCodigo;

	private String vIdioma;

	private String vImagen;

	private String vNombre;

	public Pais() {
	}
	public Pais(PaisVo pais) {
		super();
		this.iPaisId = pais.getiPaisId();
		this.cEstadoCodigo = pais.getcEstadoCodigo();
		this.vIdioma = pais.getvIdioma();
		this.vImagen = pais.getvImagen();
		this.vNombre = pais.getvNombre();
	}
	/**
	 * @return the iPaisId
	 */
	public int getiPaisId() {
		return iPaisId;
	}

	/**
	 * @param iPaisId the iPaisId to set
	 */
	public void setiPaisId(int iPaisId) {
		this.iPaisId = iPaisId;
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
	 * @return the vIdioma
	 */
	public String getvIdioma() {
		return vIdioma;
	}

	/**
	 * @param vIdioma the vIdioma to set
	 */
	public void setvIdioma(String vIdioma) {
		this.vIdioma = vIdioma;
	}

	/**
	 * @return the vImagen
	 */
	public String getvImagen() {
		return vImagen;
	}

	/**
	 * @param vImagen the vImagen to set
	 */
	public void setvImagen(String vImagen) {
		this.vImagen = vImagen;
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

	
}