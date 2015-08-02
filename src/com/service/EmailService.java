package com.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@ManagedBean(name = "emailService")
@ApplicationScoped
public class EmailService {
private final Properties properties = new Properties();
	
	private Session session;
	private String from,to,subject;
	 
	    /** MultiPart para crear mensajes compuestos. */
	    MimeMultipart multipart = new MimeMultipart("related");
 
	private void init() {
 
		properties.put("mail.smtp.host", "send.one.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port",465);
		properties.put("mail.smtp.mail.sender","seguridad@conexionegocios.com");
		properties.put("mail.smtp.user", "seguridad@conexionegocios.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
	public void sendEmail() throws UnsupportedEncodingException{		 
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			
			/*message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender"),"ConexioNegocios"));*/
			
			
			message.setFrom(new InternetAddress(this.getFrom(),"ConexioNegocios"));	
	        message.setSubject(this.getSubject());	       
	        message.addRecipient(Message.RecipientType.TO,new InternetAddress(this.getTo()));
	        // put everything together
	        message.setContent(multipart);
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "seguridad123456");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
                        //Aqui se deberia o mostrar un mensaje de error o en lugar
                        //de no hacer nada con la excepcion, lanzarla para que el modulo
                        //superior la capture y avise al usuario con un popup, por ejemplo.
			me.getStackTrace();
			return;
		}
		
	}
	public void enviarMailHtml(String from, String to, String subject, String body, List<String> adjuntos) throws Exception{
        // propiedades de conexion al servidor de correo      
		 this.from = from;
	     this.subject = subject;
	     this.to = to;
        String ipServidor = "localhost";
        String puertoServidor = "8080";
        String nombreAplicacion = "miAplicacion";
        String parametros = "misParametros";
 
        String cabecera = "<HTML><BODY><img src='cid:cidcabecera' /> <br/> <br/>";
        String pie = "<br/> <br/> <img src='cid:cidpie' /></BODY></HTML>";
        String boton = "<table><tr><td><form method='post' target='blank' action='http://"+ipServidor+":"+puertoServidor+"/"+nombreAplicacion+"/servlet/MiServlet?param="+parametros+"'> <input name='miBoton' type='submit' value='Boton' /></form>";
        String formulario = String.format("%s%s%s%s%s", cabecera, body, "<br/> <br/>",boton, pie);
 
        addContent(formulario);
 
        //añadir imagenes
        addCID("cidcabecera", "D:/PROYECTOS/conexioNegociosV001/WebContent/conexioNegocios/media/images/logo.png");
        addCID("cidpie","D:/PROYECTOS/conexioNegociosV001/WebContent/conexioNegocios/media/images/LOGdO.png");
 
        // enviar adjuntos
        if (adjuntos!=null){
            for (String adjunto : adjuntos) {
                addAttach(adjunto); //ruta donde se encuentra el fichero que queremos adjuntar.
            }
        }
 
        // enviar el correo MULTIPART
        sendEmail();
    } 
	public void addContent(String htmlText ) throws Exception
	{
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(htmlText, "text/html");
		// add it
		this.multipart.addBodyPart(messageBodyPart);
	}
	public void addCID(String cidname,String pathname) throws Exception
    {
        DataSource fds = new FileDataSource(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID","<"+cidname+">");
        this.multipart.addBodyPart(messageBodyPart);
    }
	public void addAttach(String pathname) throws Exception
    {
        File file = new File(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource ds = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(ds));
        messageBodyPart.setFileName(file.getName());
        messageBodyPart.setDisposition(Part.ATTACHMENT);
        this.multipart.addBodyPart(messageBodyPart);
    }
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
