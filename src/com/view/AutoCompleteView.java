package com.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.entities.vo.EmpresaVo;
import com.service.ThemeService;
@ManagedBean(name="autoCompleteView")
@ViewScoped
public class AutoCompleteView  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2819867995547558473L;
	
	@ManagedProperty("#{themeService}")
    private ThemeService service;
	private List<EmpresaVo> selectedEmpresa;
	
	public List<EmpresaVo> completeEmpresas(String query) {
        List<EmpresaVo> allThemes = service.listaEmpresa();
        List<EmpresaVo> filteredThemes = new ArrayList<EmpresaVo>();
         
        for (int i = 0; i < allThemes.size(); i++) {
        	EmpresaVo vo = allThemes.get(i);
            if(vo.getvRazonSocial().toLowerCase().startsWith(query)) {
                filteredThemes.add(vo);
            }
        }
         
        return filteredThemes;
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
	 * @return the selectedEmpresa
	 */
	public List<EmpresaVo> getSelectedEmpresa() {
		return selectedEmpresa;
	}


	/**
	 * @param selectedEmpresa the selectedEmpresa to set
	 */
	public void setSelectedEmpresa(List<EmpresaVo> selectedEmpresa) {
		this.selectedEmpresa = selectedEmpresa;
	}
	
}
