package com.view;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.entities.vo.PermisoVo;
import com.entities.vo.UsuarioVo;
import com.service.EmailService;
import com.service.UsuarioService;
import com.util.FaceContext;
import com.util.Util;


@ManagedBean(name="usuarioView")
@ViewScoped
public class UsuarioView implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private UsuarioVo usuarioVo = new UsuarioVo();
    private String mode;
   
    boolean resultado = false; 
    
    @ManagedProperty("#{usuarioService}")
	private UsuarioService service;
    
    @ManagedProperty("#{emailService}")
   	private EmailService emailService;
	
	public void iduUsuario() throws Exception{
		
		usuarioVo.setvIdentificador(Util.cadenaAlfanumAleatoria(6));
		resultado= service.iduUsuario(usuarioVo, mode);
		if(resultado==true){
			FaceContext.addMessageInfo("messages",FaceContext.getMessageResource("msnExito", "", "literales"));
			String emailContent="Esto es una prueba de envio de <b>email en html</b>";			
		//	emailService.sendEmail(usuarioVo.getPersona().getvEmail(),emailContent);			
			/*List<String> adjuntos = new ArrayList<String>();
	        adjuntos.add("c:/pruebas.txt");*/
			emailService.enviarMailHtml("seguridad@conexionegocios.com", usuarioVo.getPersona().getvEmail(), "Codigo de Seguridad", emailContent, null);
		}
		else{
			FaceContext.addMessageError("messages",FaceContext.getMessageResource("msnError", "", "literales"));
			
          }
		
	    }

   

	/**
	 * @return the usuarioVo
	 */
	public UsuarioVo getUsuarioVo() {
		return usuarioVo;
	}


	/**
	 * @param usuarioVo the usuarioVo to set
	 */
	public void setUsuarioVo(UsuarioVo usuarioVo) {
		this.usuarioVo = usuarioVo;
	}



	/**
	 * @return the service
	 */
	public UsuarioService getService() {
		return service;
	}



	/**
	 * @param service the service to set
	 */
	public void setService(UsuarioService service) {
		this.service = service;
	}



	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}



	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the emailService
	 */
	public EmailService getEmailService() {
		return emailService;
	}

	/**
	 * @param emailService the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}


	
	    
}
