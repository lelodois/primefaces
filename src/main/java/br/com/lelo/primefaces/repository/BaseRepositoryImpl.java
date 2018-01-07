package br.com.lelo.primefaces.repository;

import java.io.Serializable;

import com.google.common.collect.HashBasedTable;

import br.com.lelo.primefaces.model.Model;

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
