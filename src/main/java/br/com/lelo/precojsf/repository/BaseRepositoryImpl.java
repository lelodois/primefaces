package br.com.lelo.precojsf.repository;

import java.io.Serializable;

import br.com.lelo.precojsf.model.Model;

import com.google.common.collect.HashBasedTable;

public class BaseRepositoryImpl implements Serializable {

	private static final long serialVersionUID = -6940597985852239562L;
	private static HashBasedTable<String, String, Model> table = null;

	public HashBasedTable<String, String, Model> load() {
		table = HashBasedTable.create();
		return table;
	}

	public void flush(HashBasedTable<String, String, Model> table) {
		BaseRepositoryImpl.table = table;
	}

}
