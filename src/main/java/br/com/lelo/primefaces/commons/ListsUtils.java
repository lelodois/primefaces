package br.com.lelo.primefaces.commons;

import java.util.ArrayList;
import java.util.List;

public class ListsUtils<T> {

	public List<T> initializeSeNull(List<T> itens) {
	    if(itens == null){
            itens = new ArrayList<T>();
	    }
	    return itens;
	}

}
