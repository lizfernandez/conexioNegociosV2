package com.view;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import com.entities.vo.UsuarioVo;
import com.service.UsuarioService;
import com.util.FaceContext;



@ManagedBean(name="loginView")
@ViewScoped
public class LoginView implements Serializable {
	     
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   /***
	    * codigos de auth de twitter.	
	    */
	   private String auth; 
	   private final String CONSUMER_KEY = "ceA17OdqVW3Lih9y4EXS03rQf";
	   private final String CONSUMER_SECRET = "wN3nvWhcbW1kgpmCmlNTRd9nWxSnBvVGMAvN4b5WvqU6MIARGZ";
	   private final String TOKEN_ACCESS = "3332010369-6nBUdz5XVGvapivojsrpMwtY5lpCGNNmIyjJ6o6";
	   private final String TOKEN_SECRET = "sA1jeYUdWQ1zblKpukkPkiVkXgtnKUAgAHF3mmWc0Hi67";
	   private final String USER_NAME ="ConexioNegocio";
	   
	   
	    private UsuarioVo usuarioVo= new UsuarioVo();
	    private String nombreDirectorio;
	    
	    
	    @ManagedProperty("#{usuarioService}")
		private UsuarioService service;
	    
	    boolean resultado = false;
	    
	    @PostConstruct	    
	    public void init() {	    
	        setNombreDirectorio("conexioNegocios");
	    }
	    public String  login() throws IOException {
	    	String url=null;
	    	try {		
	    	
	    	List<UsuarioVo>  UsuarioBean=service.login(usuarioVo.getvUsuario(), usuarioVo.getvContrasena());
	    	
	    	if(UsuarioBean!=null && UsuarioBean.size()>0 )
	        {
	    		HttpSession session = FaceContext.getSession();
	            session.setAttribute("Usuario", UsuarioBean.get(0));
	            session.setAttribute("iUsuarioId", UsuarioBean.get(0).getiUsuarioId());
	            
	            /**obtenermos los permisos del acceso del menu asi como tambien los de sus paginas**/
	            session.setAttribute("MisPermisos",service.usuarioPermisos());
	           
	           
	            resultado = true;
	    	
	            if(UsuarioBean.get(0).getListaUsuarios().size()>0){
	            	/**asignamos el directorio de su empresa**/	            	
	            	setNombreDirectorio(UsuarioBean.get(0).getListaUsuarios().get(0).getPersona().getvNombreDirectorio());	             
	            	url="/home.xhtml?faces-redirect=true";
                   return url;
	            }
	            else{
	            	    setNombreDirectorio("conexioNegocios");	            	
	            	    url="/home.xhtml?faces-redirect=true";
	                   return url;
	            }
	          }
	        else
	        {
	        	
	        	FaceContext.addMessageInfo("messages",FaceContext.getMessageResource("msnErrorLogin", "", "literales"));
	            setNombreDirectorio("conexioNegocios");
	            resultado = false;
	            
	        }
	    	//context.addCallbackParam("loggedIn", loggedIn);
	    	} catch (Exception e) {
				e.printStackTrace();
			}
			return url;
	    }
	  //logout event, invalidate session
	    public String logout() {
	        HttpSession session = FaceContext.getSession();
	        session.invalidate();
	        String url="/index.xhtml?faces-redirect=true";
            return url;
	    }
	   /* public void buttonTwitter(ActionEvent actionEvent) throws IOException, LimitExceededException {
	       
	     	
	     		Token token= new Token(TOKEN_ACCESS, TOKEN_SECRET);
	     		Credential c = new Credential(USER_NAME, CONSUMER_KEY, CONSUMER_SECRET, token);
	     		UserAccountManager m = UserAccountManager.getInstance(c);
	     		 
	     		if (m.verifyCredential()) {
	     		  GeoLocation loc = new GeoLocation("+37.5", "+26.7");
	     		  Tweet t = new Tweet("Cool! Geo-located tweet via Twitter ", loc);
	     		  TweetER ter = TweetER.getInstance(m);
	     		  t = ter.post(t);
	    	     		 
	     		 addMessage(t.getUserAccount().toString());
	     		}	     	
	     	    	
	    }
	   */
	    
	   
	   
		
	
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
		 * @return the nombreDirectorio
		 */
		public String getNombreDirectorio() {
			return nombreDirectorio;
		}
		/**
		 * @param nombreDirectorio the nombreDirectorio to set
		 */
		public void setNombreDirectorio(String nombreDirectorio) {
			this.nombreDirectorio = nombreDirectorio;
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
		

		

		
	 
	   
}
