package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.model.CroppedImage;
import org.primefaces.model.UploadedFile;

import com.entitie.Usuario;
import com.entities.vo.UsuarioVo;

public class FaceContext {
	public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
 
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance()
                .getExternalContext().getResponse();
    }
    public static void addMessageInfo(String idAtribute,String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(idAtribute, message);
    }
    public static void addMessageWarn(String idAtribute,String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary,  null);
        FacesContext.getCurrentInstance().addMessage(idAtribute, message);
    }
    public static void addMessageError(String idAtribute,String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage(idAtribute, message);
    }
    public static UsuarioVo getUsuario() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        UsuarioVo usuario=(UsuarioVo) session.getAttribute("Usuario");
        return usuario;
    }
 
    public static int getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return Integer.parseInt(session.getAttribute("iUsuarioId").toString());
        else
            return (Integer) null;
    }
    public static String getUrlDirectorioExterno(String nombreDirectorio) throws IOException{
		  
		//accedemos a valCampoNumerico
    	Object[] valores = new Object[1];
		valores[0] = nombreDirectorio;
		String prueba = getMessageResource("urlDirectorio", valores, "literales");
		/*String pruebas = getMessageResource("btnBienvenido", "", "literales");*/

		/**
		 * //accedemos a valFormatoDecimal
		Object[] valores = new Object[3];
		valores[0] = "Importe";
		valores[1] = 3;
		valores[2] = 3;
		String prueba3 = MiClase.getMessageResource("valCampoNumerico", valores, "validaciones");
        **/
		
		 
		return prueba;
	 }
	public static String getUrlDirectorioInterno(String nombreDirectorio){
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String newFileName = servletContext.getRealPath("") + File.separator + nombreDirectorio+ File.separator + "media" + File.separator + "images" + File.separator;
       return newFileName;
	}
	public static void copyFile(UploadedFile file, CroppedImage croImage, String UrlDirectorioImagen) {
        try {
           
           
             String newFileName=UrlDirectorioImagen;
            // OutputStream out = new FileOutputStream(new File(newFileName));
             
           
             /*int read = 0;
             byte[] bytes = new byte[1024];             
             while ((read = in.read(bytes)) != -1) {
                 out.write(bytes, 0, read);
             }
             */
             FileImageOutputStream imageOutput;
             imageOutput = new FileImageOutputStream(new File(newFileName));
             if(file!=null)
               imageOutput.write(file.getContents(), 0, file.getContents().length);
             else
               imageOutput.write(croImage.getBytes(), 0, croImage.getBytes().length); 
             imageOutput.close();
             System.out.println("newFileName ="+UrlDirectorioImagen);
            /* in.close();
             out.flush();
             out.close();
             outs.flush();
             outs.close();
           */
           
             } catch (IOException e) {
               e.printStackTrace();
             }
      }
	public static String getMessageResource(String key, Object[] arguments, String messagesBaseName) {

		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();// new Locale("es", "ES", ""); //ControllerUtil.getController().getUsuario().getLocale();

		FacesContext context = FacesContext.getCurrentInstance();

		if (locale == null || context == null) {
			locale = Locale.getDefault();
		} else {
			if (context.getViewRoot() != null) {
				locale = context.getViewRoot().getLocale();
			}
		}

		String resourceString;

		try {
			Application app = context.getApplication();
			String messageBundle = context.getApplication().getMessageBundle();
		    ResourceBundle bundle1 = ResourceBundle.getBundle(messageBundle,locale);
			//ResourceBundle bundle = app.getResourceBundle(context,"msg");
			
			//resourceString = bundle.getString(key);
			 resourceString = bundle1.getString(key);
		} catch(MissingResourceException e) {
			e.printStackTrace();
			return key;
		}

		if(arguments == null) {
			return resourceString;
		}

		MessageFormat format = new MessageFormat(resourceString,locale);

		return format.format(arguments);
	}
	public static String getMessageResource(String key, String arg, String messagesBaseName) {
		String[] args = {arg};
		return getMessageResource(key, args, messagesBaseName);
	}
}
