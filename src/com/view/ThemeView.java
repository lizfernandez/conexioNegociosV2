package com.view;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.UploadedFile;

import com.entities.vo.PermisoVo;
import com.entities.vo.PlantillausuarioVo;
import com.entities.vo.TiposeccionVo;
import com.service.ThemeService;
import com.util.Constantes;
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
	private List<PlantillausuarioVo> listaSeccionPlantilla = new ArrayList<PlantillausuarioVo>();
	
	private PlantillausuarioVo plantillausuarioVo= new PlantillausuarioVo();
	private List<PlantillausuarioVo> plantillausuarioActivo;
	private UploadedFile file;
	private CroppedImage croppedImage;    
    private String nuevaCroppedImage;
    private String nuevaImagen;
    private String parametro;
    private String mode;
    private TiposeccionVo tipoSeccion= new TiposeccionVo();
    private String nombreDirectorio;
    private String vPermisoTheme;
    HttpSession session = FaceContext.getSession();
    
	@PostConstruct
    public void listaThemeActivo(){
		Map<String,String> params =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		nombreDirectorio = params.get("nombreDirectorio");
		if(nombreDirectorio==null){
			nombreDirectorio="conexioNegocios";
			
		}
		/****
		 * buscamos y listamos las secciones activas de las plantillas con el nombre del directorio del usuario.
		 */
		plantillausuarioActivo = service.listaSeccionPlantillaActiva(nombreDirectorio);
	    ArrayList<PermisoVo> misPermisos=(ArrayList<PermisoVo>) session.getAttribute("MisPermisos");
	    /**
	     * verificamos los permisos que tiene el usuario sobre la pagina.
	     */
		if(misPermisos!=null){
		    for(PermisoVo vo:misPermisos){
				if(vo.getvDescripcion().equals(Constantes.permisoTheme)){
					if(vo.getvCodigoPermiso().equals(String.valueOf(plantillausuarioActivo.get(0).getEmpresa().getiEmpresaId()))){
						vPermisoTheme="SI";
						break;
					}
					else{
						vPermisoTheme="NO";
					}
				}
			}
		}
		session.setAttribute("Empresa", plantillausuarioActivo.get(0).getEmpresa());
    }
    
	public void listaLogos(){
		/***
		 * listamos los logos cuyo
		 * tipoSeccion: Logo, id=1;
		 */
		 listaSeccionPlantilla = service.listaSeccionPlantilla("1", nombreDirectorio);
		 for(PlantillausuarioVo vo:listaSeccionPlantilla){
			 if(vo.getTipoSeccion().getiTipoSeccionId()==1){
				 tipoSeccion=vo.getTipoSeccion();
			 }
		 }
		
		
	}
	public void listaMenu(){
		/***
		 * listamos los menus cuyo
		 * tipoSeccion: Menu, id=2;
		 */
		 listaSeccionPlantilla = service.listaSeccionPlantilla("2",nombreDirectorio);
		 for(PlantillausuarioVo vo:plantillausuarioActivo){
			 if(vo.getTipoSeccion().getiTipoSeccionId()==2){
				 tipoSeccion=vo.getTipoSeccion();
			 }
		 }
		
		
	}
	public void fileUploadListener(FileUploadEvent e) throws IOException{
       /***
        * cargamos la imagen y la almacenamos el el directorio interno y extermo del proyecto.
        */
        this.file= e.getFile();      
      //  System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
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
        	e.printStackTrace();
            FaceContext.addMessageError("messages",FaceContext.getMessageResource("msnError", "", "literales"));
        }
         
        FaceContext.addMessageInfo("messages",FaceContext.getMessageResource("msnExito", "", "literales"));
    }
	public void iduTheme(){
		System.out.println("idutheme");
		if(croppedImage == null) {
            return;
        }
         
        
        try {
        	plantillausuarioVo.setvFoto(getRandomImageName()+"_logo.jpg");
        	
        	
        	FaceContext.copyFile(null, croppedImage, FaceContext.getUrlDirectorioInterno(nombreDirectorio)+plantillausuarioVo.getvFoto());
        	FaceContext.copyFile(null, croppedImage, FaceContext.getUrlDirectorioExterno(nombreDirectorio)+plantillausuarioVo.getvFoto());
            
        	service.iduTheme(plantillausuarioVo,tipoSeccion,plantillausuarioActivo, mode);
        	File fileInterno = new File(FaceContext.getUrlDirectorioInterno(nombreDirectorio)+nuevaImagen);
        	File fileExterno = new File(FaceContext.getUrlDirectorioExterno(nombreDirectorio)+nuevaImagen);
        	fileInterno.delete();
        	fileExterno.delete();
        	
        	
        } catch (Exception e) {
        	e.printStackTrace();
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
	public List<PlantillausuarioVo> getListaSeccionPlantilla() {
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
			List<PlantillausuarioVo> listaSeccionPlantilla) {
		this.listaSeccionPlantilla = listaSeccionPlantilla;
	}
	/**
	 * @return the seccionPlantillaVo
	 */
	public PlantillausuarioVo getSeccionPlantillaVo() {
		return plantillausuarioVo;
	}
	/**
	 * @param seccionPlantillaVo the seccionPlantillaVo to set
	 */
	public void setSeccionPlantillaVo(PlantillausuarioVo seccionPlantillaVo) {
		this.plantillausuarioVo = seccionPlantillaVo;
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
	 * @return the plantillausuarioActivo
	 */
	public List<PlantillausuarioVo> getPlantillausuarioActivo() {
		return plantillausuarioActivo;
	}
	/**
	 * @param plantillausuarioActivo the plantillausuarioActivo to set
	 */
	public void setPlantillausuarioActivo(List<PlantillausuarioVo> plantillausuarioActivo) {
		this.plantillausuarioActivo = plantillausuarioActivo;
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
	/**
	 * @return the vPermisoTheme
	 */
	public String getvPermisoTheme() {
		return vPermisoTheme;
	}
	/**
	 * @param vPermisoTheme the vPermisoTheme to set
	 */
	public void setvPermisoTheme(String vPermisoTheme) {
		this.vPermisoTheme = vPermisoTheme;
	}
	
   
	
	
}
