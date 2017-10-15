package br.com.lelo.precojsf.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanComparator;

import br.com.lelo.precojsf.model.Model;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;

public class BaseRepository implements Serializable {

    private static final long serialVersionUID = 7892038867255673426L;
    private static BaseRepository instance;
    private HashBasedTable<String, String, Model> table;
    private BaseRepositoryImpl baseRepositoryImpl;

    public static BaseRepository getInstance() {
        if (instance == null) {
            instance = new BaseRepository();
            instance.baseRepositoryImpl = new BaseRepositoryImpl();
            instance.table = instance.baseRepositoryImpl.load();
        }
        return instance;
    }

    public BaseRepository add(Model model) {
        model.setId(UUID.randomUUID().toString());
        table.put(model.getType(), model.getId(), model);
        flush();
        return this;
    }

    public BaseRepository update(Model model) {
        table.put(model.getType(), model.getId(), model);
        this.flush();
        return this;
    }

    public List<Model> listAll(String type) {
        List<Model> list = new ArrayList<Model>();
        if (table.containsRow(type)) {
            list = Lists.newArrayList(table.rowMap().get(type).values());
            removeInvalidItens(list);
            Collections.sort(list, new BeanComparator<Model>("nome"));
        }
        return list;
    }

    private void removeInvalidItens(List<Model> list) {
        for (Iterator<Model> iterator = list.iterator(); iterator.hasNext();) {
            Model model = iterator.next();
            if (model.isNotBlank() == false) {
                System.out.println(model + ":  removido por informações vazias");
                remove(model);
                iterator.remove();
            }
        }
    }

    public Model getById(String type, String id) {
        return table.get(type, id);
    }

    public Model getByCodigo(String type, Long codigo) {
        Map<String, Model> values = table.rowMap().get(type);
        if (values != null) {
            for (String id : values.keySet()) {
                if (values.get(id).getCodigo().equals(codigo)) {
                    return values.get(id);
                }
            }
        }
        return null;
    }

    private void flush() {
        baseRepositoryImpl.flush(table);
    }

    public void remove(Model model) {
        table.remove(model.getType(), model.getId());
    }

}
