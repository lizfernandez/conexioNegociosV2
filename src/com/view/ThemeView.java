package com.view;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.UploadedFile;

import com.entities.vo.SeccionplantillaVo;
import com.entities.vo.TiposeccionVo;
import com.service.ThemeService;
import com.util.FaceContext;

@ManagedBean(name="themeView")
@ViewScoped
public class ThemeView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{themeService}")
	private ThemeService service;
	private List<SeccionplantillaVo> listaSeccionPlantilla;
	
	private SeccionplantillaVo seccionPlantillaVo= new SeccionplantillaVo();
	private List<SeccionplantillaVo> seccionPlantillaActivo;
	private UploadedFile file;
	private CroppedImage croppedImage;    
    private String nuevaCroppedImage;
    private String nuevaImagen;
    private String parametro;
    private String mode;
    private TiposeccionVo tipoSeccion= new TiposeccionVo();
    private String nombreDirectorio;
   
	@PostConstruct
    public void listaThemeActivo(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		nombreDirectorio = params.get("conexioNegocios");
		if(nombreDirectorio==null){
			nombreDirectorio="conexioNegocios";
		}
    	seccionPlantillaActivo = service.listaSeccionPlantillaActiva(nombreDirectorio);
    }
	public void listaLogos(){
		/***
		 * tipoSeccion: Logo, id=1;
		 */
		 listaSeccionPlantilla = service.listaSeccionPlantilla("1");
		 for(SeccionplantillaVo vo:seccionPlantillaActivo){
			 if(vo.getTipoSeccion().getiTipoSeccionId()==1){
				 tipoSeccion=vo.getTipoSeccion();
			 }
		 }
		
		
	}
	public void fileUploadListener(FileUploadEvent e) throws IOException{
        // Get uploaded file from the FileUploadEvent
        this.file= e.getFile();
        // Print out the information of the file
        System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
        FaceContext.copyFile(e.getFile(),null, FaceContext.getUrlDirectorioInterno(nombreDirectorio)+ getFile().getFileName());
        FaceContext.copyFile(e.getFile(),null, FaceContext.getUrlDirectorioExterno(nombreDirectorio)+ getFile().getFileName());
        nuevaImagen= getFile().getFileName();
        mode="I";
       
		
	}
	
	public void crop() {
        if(croppedImage == null) {
            return;
        }
         
        
        try {
        	setNuevaCroppedImage(getRandomImageName()+".jpg");
        	FaceContext.copyFile(null, croppedImage, FaceContext.getUrlDirectorioInterno(nombreDirectorio)+getNuevaCroppedImage());
        	FaceContext.copyFile(null, croppedImage, FaceContext.getUrlDirectorioExterno(nombreDirectorio)+getNuevaCroppedImage());
        } catch (Exception e) {
            FaceContext.addMessageError("messages","Cropping failed.");
        }
         
        FaceContext.addMessageInfo("messages","Success, Cropping finished.");
    }
	public void iduTheme(){
		System.out.println("idutheme");
		if(croppedImage == null) {
            return;
        }
         
        
        try {
        	seccionPlantillaVo.setvFoto(getRandomImageName()+"_logo.jpg");
        	
        	
        	FaceContext.copyFile(null, croppedImage, FaceContext.getUrlDirectorioInterno(nombreDirectorio)+seccionPlantillaVo.getvFoto());
        	FaceContext.copyFile(null, croppedImage, FaceContext.getUrlDirectorioExterno(nombreDirectorio)+seccionPlantillaVo.getvFoto());
            
        	service.iduTheme(seccionPlantillaVo,tipoSeccion,seccionPlantillaActivo, mode);
        	File fileInterno = new File(FaceContext.getUrlDirectorioInterno(nombreDirectorio)+nuevaImagen);
        	File fileExterno = new File(FaceContext.getUrlDirectorioExterno(nombreDirectorio)+nuevaImagen);
        	fileInterno.delete();
        	fileExterno.delete();
        	
        	
        } catch (Exception e) {
            FaceContext.addMessageError("messages",FaceContext.getMessageResource("msnError", "", "literales"));
        }
         
        FaceContext.addMessageInfo("messages",FaceContext.getMessageResource("msnExito", "", "literales"));
	}
	/**
	 * @return the service
	 */
	public ThemeService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(ThemeService service) {
		this.service = service;
	}

	/**
	 * @return the listaSeccionPlantilla
	 */
	public List<SeccionplantillaVo> getListaSeccionPlantilla() {
		/*System.out.println(" recarga "+listaSeccionPlantilla.size());
	    HttpSession session = FaceContext.getSession();
		listaSeccionPlantilla=(List<SeccionplantillaVo>) session.getAttribute("listaSeccionPlantilla");
	    */    
		return listaSeccionPlantilla;
	}

	/**
	 * @param listaSeccionPlantilla the listaSeccionPlantilla to set
	 */
	public void setListaSeccionPlantilla(
			List<SeccionplantillaVo> listaSeccionPlantilla) {
		this.listaSeccionPlantilla = listaSeccionPlantilla;
	}
	/**
	 * @return the seccionPlantillaVo
	 */
	public SeccionplantillaVo getSeccionPlantillaVo() {
		return seccionPlantillaVo;
	}
	/**
	 * @param seccionPlantillaVo the seccionPlantillaVo to set
	 */
	public void setSeccionPlantillaVo(SeccionplantillaVo seccionPlantillaVo) {
		this.seccionPlantillaVo = seccionPlantillaVo;
	}
	
	public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public CroppedImage getCroppedImage() {
        return croppedImage;
    }
 
    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    } 
    private String getRandomImageName() {
        int i = (int) (Math.random() * 100000);
         
        return String.valueOf(i);
    }
	/**
	 * @return the nuevaImagen
	 */
	public String getNuevaImagen() {
		return nuevaImagen;
	}
	/**
	 * @param nuevaImagen the nuevaImagen to set
	 */
	public void setNuevaImagen(String nuevaImagen) {
		this.nuevaImagen = nuevaImagen;
	}
	/**
	 * @return the nuevaCroppedImage
	 */
	public String getNuevaCroppedImage() {
		return nuevaCroppedImage;
	}
	/**
	 * @param nuevaCroppedImage the nuevaCroppedImage to set
	 */
	public void setNuevaCroppedImage(String nuevaCroppedImage) {
		this.nuevaCroppedImage = nuevaCroppedImage;
	}
	/**
	 * @return the parametro
	 */
	public String getParametro() {
		return parametro;
	}
	/**
	 * @param parametro the parametro to set
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
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
	 * @return the seccionPlantillaActivo
	 */
	public List<SeccionplantillaVo> getSeccionPlantillaActivo() {
		return seccionPlantillaActivo;
	}
	/**
	 * @param seccionPlantillaActivo the seccionPlantillaActivo to set
	 */
	public void setSeccionPlantillaActivo(
			List<SeccionplantillaVo> seccionPlantillaActivo) {
		this.seccionPlantillaActivo = seccionPlantillaActivo;
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
	 * @return the tipoSeccion
	 */
	public TiposeccionVo getTipoSeccion() {
		return tipoSeccion;
	}
	/**
	 * @param tipoSeccion the tipoSeccion to set
	 */
	public void setTipoSeccion(TiposeccionVo tipoSeccion) {
		this.tipoSeccion = tipoSeccion;
	}
	
   
	
	
}
