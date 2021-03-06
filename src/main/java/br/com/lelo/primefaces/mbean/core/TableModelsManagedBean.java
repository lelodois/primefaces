package br.com.lelo.primefaces.mbean.core;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.lelo.primefaces.commons.FacesContextUtil;
import br.com.lelo.primefaces.model.Model;
import br.com.lelo.primefaces.model.enums.TableModelEnum;

@ManagedBean(name = "beanTableModels")
public class TableModelsManagedBean {

    public List<Model> listAllModel() {
        TableModelEnum[] values = TableModelEnum.values();

        for (TableModelEnum modelEnum : values) {
            if(modelEnum.name().equalsIgnoreCase(getModelName())){
                return modelEnum.getModel().listAll();
            }
        }
        return null;
    }

    public void remove(Model model) {
        model.remove();
    }
    
    private String getModelName() {
        return FacesContextUtil.getBeanByViewId();
    }
}
