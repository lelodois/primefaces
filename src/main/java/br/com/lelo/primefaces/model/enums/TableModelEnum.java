package br.com.lelo.primefaces.model.enums;

import br.com.lelo.primefaces.model.Comprador;
import br.com.lelo.primefaces.model.Filial;
import br.com.lelo.primefaces.model.Fornecedor;
import br.com.lelo.primefaces.model.Model;

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
