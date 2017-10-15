package br.com.lelo.precojsf.model.enums;

import br.com.lelo.precojsf.model.Comprador;
import br.com.lelo.precojsf.model.Filial;
import br.com.lelo.precojsf.model.Fornecedor;
import br.com.lelo.precojsf.model.Model;

public enum TableModelEnum {
    COMPRADOR(new Comprador()), FORNECEDOR(new Fornecedor()), FILIAL(new Filial());

    private Model model;

    private TableModelEnum(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

}
