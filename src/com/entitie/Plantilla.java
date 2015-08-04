package com.entitie;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.CategoriaVo;
import com.entities.vo.PlantillaVo;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the plantilla database table.
 * 
 */
@Entity
public class Plantilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String iPlantillaId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iCategoriaId")
	private Categoria categoria;
	
	private String cEstadoCodigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaActualiza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaInserta;

	private float fPrecio;

	private BigInteger iUsuarioActualizaId;

	private BigInteger iUsuarioInsertaId;

	private String vNombrePlantilla;
	
	private String vFoto;

	public Plantilla() {
	}
	public Plantilla(PlantillaVo plantilla) {
		super();
		this.iPlantillaId = plantilla.getiPlantillaId();
		this.cEstadoCodigo = plantilla.getcEstadoCodigo();
		this.dFechaActualiza = plantilla.getdFechaActualiza();
		this.dFechaInserta = plantilla.getdFechaInserta();
		this.fPrecio = plantilla.getfPrecio();
		this.iUsuarioActualizaId = plantilla.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = plantilla.getiUsuarioInsertaId();
		this.vNombrePlantilla = plantilla.getvNombrePlantilla();
		this.vFoto= plantilla.getvFoto(); 
		this.categoria = plantilla.getCategoria()!=null? new Categoria(plantilla.getCategoria()): null;

	}
	/**
	 * @return the iPlantillaId
	 */
	public String getiPlantillaId() {
		return iPlantillaId;
	}

	/**
	 * @param iPlantillaId the iPlantillaId to set
	 */
	public void setiPlantillaId(String iPlantillaId) {
		this.iPlantillaId = iPlantillaId;
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
	 * @return the fPrecio
	 */
	public float getfPrecio() {
		return fPrecio;
	}

	/**
	 * @param fPrecio the fPrecio to set
	 */
	public void setfPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
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
	 * @return the vNombrePlantilla
	 */
	public String getvNombrePlantilla() {
		return vNombrePlantilla;
	}

	/**
	 * @param vNombrePlantilla the vNombrePlantilla to set
	 */
	public void setvNombrePlantilla(String vNombrePlantilla) {
		this.vNombrePlantilla = vNombrePlantilla;
	}
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	
}