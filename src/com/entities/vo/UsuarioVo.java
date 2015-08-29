package com.entities.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.entitie.Usuario;


public class UsuarioVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int iUsuarioId;
	private String cEstadoCodigo;
	private Date dFechaActualiza;
	private Date dFechaInserta;	
	private PerfilVo perfil;
	private PersonaVo persona = new PersonaVo();
	private BigInteger iUsuarioActualizaId;
	private BigInteger iUsuarioInsertaId;
	private String vContrasena;
	private String vIdentificador;
	private String vUsuario;
	private List<UsuarioVo> listaUsuarios;
	private String cConectado;

	public UsuarioVo() {
		super();
	}

	public UsuarioVo(Usuario usuario) {
		this.iUsuarioId = usuario.getiUsuarioId();
		this.cEstadoCodigo =usuario.getcEstadoCodigo();
		this.dFechaActualiza = usuario.getdFechaActualiza();
		this.dFechaInserta = usuario.getdFechaInserta();
		this.perfil = usuario.getPerfil()!= null?  new PerfilVo(usuario.getPerfil()) : null;
		this.persona = usuario.getPersona()!= null?  new PersonaVo(usuario.getPersona()):null ;
		this.iUsuarioActualizaId = usuario.getiUsuarioActualizaId();
		this.iUsuarioInsertaId = usuario.getiUsuarioInsertaId();
		this.vContrasena = usuario.getvContrasena();
		this.vIdentificador = usuario.getvIdentificador();
		this.vUsuario = usuario.getvUsuario();
		this.cConectado= usuario.getcConectado();
		if(usuario.getListaUsuarios()!=null){	
			this.listaUsuarios = new ArrayList<UsuarioVo>();
			for(Usuario em:usuario.getListaUsuarios()){
				UsuarioVo e= new UsuarioVo(em);
				this.listaUsuarios.add(e)		;	
			}
		}
		     
	}

	/**
	 * @return the iUsuarioId
	 */
	public int getiUsuarioId() {
		return iUsuarioId;
	}

	/**
	 * @param iUsuarioId the iUsuarioId to set
	 */
	public void setiUsuarioId(int iUsuarioId) {
		this.iUsuarioId = iUsuarioId;
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
	 * @return the perfil
	 */
	public PerfilVo getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilVo perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the persona
	 */
	public PersonaVo getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaVo persona) {
		this.persona = persona;
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
	 * @return the vContrasena
	 */
	public String getvContrasena() {
		return vContrasena;
	}

	/**
	 * @param vContrasena the vContrasena to set
	 */
	public void setvContrasena(String vContrasena) {
		this.vContrasena = vContrasena;
	}

	/**
	 * @return the vIdentificador
	 */
	public String getvIdentificador() {
		return vIdentificador;
	}

	/**
	 * @param vIdentificador the vIdentificador to set
	 */
	public void setvIdentificador(String vIdentificador) {
		this.vIdentificador = vIdentificador;
	}

	/**
	 * @return the vUsuario
	 */
	public String getvUsuario() {
		return vUsuario;
	}

	/**
	 * @param vUsuario the vUsuario to set
	 */
	public void setvUsuario(String vUsuario) {
		this.vUsuario = vUsuario;
	}

	

	/**
	 * @return the listaUsuarios
	 */
	public List<UsuarioVo> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(List<UsuarioVo> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * @return the cConectado
	 */
	public String getcConectado() {
		return cConectado;
	}

	/**
	 * @param cConectado the cConectado to set
	 */
	public void setcConectado(String cConectado) {
		this.cConectado = cConectado;
	}

	
}
