package com.view;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringEscapeUtils;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import com.entities.vo.MensajesVo;
import com.entities.vo.SeguidoreVo;
import com.service.MensajesService;
import com.util.FaceContext;

@ManagedBean(name="mensajesView")
@RequestScoped

public class MensajesView implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{mensajesService}")
	private MensajesService service;
    private List<MensajesVo> listaMensaje = new ArrayList<MensajesVo>();
    private List<MensajesVo> listaMensajeDetalle = new ArrayList<MensajesVo>();
    private MensajesVo mensaje;
    private MensajesVo detalleCabecera = new MensajesVo();
    private final EventBus eventBus = EventBusFactory.getDefault().eventBus();
    
   
	@PostConstruct
	public void init(){
		mensaje= new MensajesVo();
	}
    public void listaMensajes(){
    	Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String usuarioEnvia =  params.get("usuarioEnvia");
		String usuarioRecibe =  params.get("usuarioRecibe");
	    if(usuarioEnvia==null){
	    	listaMensaje = service.listaMensajes(FaceContext.getUserId());
	    }
	    
		
    	
	}
    public List<MensajesVo> listaMensajesUsuario(){
    	
	    	listaMensaje = service.listaMensajes(FaceContext.getUserId());
	   
    	return listaMensaje;
	}
    public void listaMensajesDetalle(){
		
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	/*	String usuarioEnvia =  params.get("usuarioEnvia");
		String usuarioRecibe =  params.get("usuarioRecibe");
	*/
		String vIdentidicador =  params.get("vIdentidicador");
		listaMensajeDetalle = service.listaMensajesDetalle( vIdentidicador);
		for(MensajesVo vo: listaMensajeDetalle){
			if(vo.getUsuarioRecibe()!=null){
				detalleCabecera=vo;
			break;
			}
		}
		
		
    	
	}
	public List<SeguidoreVo> listaSeguidores(){
		List<SeguidoreVo> lista= new ArrayList<SeguidoreVo>();
    	lista = service.listaSeguidores(FaceContext.getUserId());
    	return lista;
    }
	public void enviarMensaje(String mode) {
		/*Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String usuarioEnvia =  params.get("usuarioEnvia");
		String usuarioRecibe =  params.get("usuarioRecibe");
		String vIdentidicador =  params.get("vIdentidicador");
		*/
		

		mensaje.setUsuarioEnvia(FaceContext.getUsuario());
		mensaje.setUsuarioRecibe(service.usuarioMensaje(detalleCabecera.getUsuarioRecibe().getiUsuarioId()));
		mensaje.setvIdentidicador(detalleCabecera.getvIdentidicador());
		
		service.iduMensaje(mensaje, mode);
		
		//listaMensajeDetalle = service.listaMensajesDetalle(detalleCabecera.getvIdentidicador());
		
        
        
        notificarPUSH(mensaje);
    }

    public void notificarPUSH(MensajesVo mensaje) {

        String summary =mensaje.getUsuarioEnvia().getiUsuarioId()
        		        +":"+mensaje.getUsuarioRecibe().getiUsuarioId()
        		        +":"+mensaje.getvIdentidicador()
        		        +":"+mensaje.getUsuarioEnvia().getPersona().getvFoto()
        		        +":"+mensaje.getUsuarioRecibe().getPersona().getvFoto();
        String detail =  mensaje.getvMensaje();
        String CHANNEL = "/notify";

     ///   EventBus eventBus = EventBusFactory.getDefault().eventBus();
        
       eventBus.publish(CHANNEL, new FacesMessage(StringEscapeUtils.escapeHtml3(summary), StringEscapeUtils.escapeHtml3(detail)));
       //eventBus.publish(CHANNEL, mensaje.getUsuarioEnvia().getiUsuarioId() + ": " + mensaje.getvMensaje());
    }
   
	



	/**
	 * @return the service
	 */
	public MensajesService getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(MensajesService service) {
		this.service = service;
	}
	/**
	 * @return the listaPlantilla
	 */
	/**
	 * @return the listaMensaje
	 */
	public List<MensajesVo> getListaMensaje() {
		return listaMensaje;
	}
	/**
	 * @param listaMensaje the listaMensaje to set
	 */
	public void setListaMensaje(List<MensajesVo> listaMensaje) {
		this.listaMensaje = listaMensaje;
	}
	/**
	 * @return the mensaje
	 */
	public MensajesVo getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(MensajesVo mensaje) {
		this.mensaje = mensaje;
	}
	
	
	/**
	 * @return the detalleCabecera
	 */
	public MensajesVo getDetalleCabecera() {
		return detalleCabecera;
	}
	/**
	 * @param detalleCabecera the detalleCabecera to set
	 */
	public void setDetalleCabecera(MensajesVo detalleCabecera) {
		this.detalleCabecera = detalleCabecera;
	}
	/**
	 * @return the listaMensajeDetalle
	 */
	public List<MensajesVo> getListaMensajeDetalle() {
		return listaMensajeDetalle;
	}
	/**
	 * @param listaMensajeDetalle the listaMensajeDetalle to set
	 */
	public void setListaMensajeDetalle(List<MensajesVo> listaMensajeDetalle) {
		this.listaMensajeDetalle = listaMensajeDetalle;
	}
	
	



	
	
}
