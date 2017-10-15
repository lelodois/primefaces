package br.com.lelo.precojsf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import br.com.lelo.precojsf.repository.BaseRepository;

public class Model implements Serializable {

    private static final long serialVersionUID = -7956147632698856467L;

    private String nome;
    private Long codigo;
    private Date dataCadastro = new Date();
    private String id;

    public Model() {
        this.codigo = (long) Math.abs(Math.abs((1000) + new Random().nextInt(1000)));
    }

    public Model save() {
        Model byCodigo = this.getByCodigo();
        if (byCodigo != null) {
            byCodigo.remove();
        }
        BaseRepository.getInstance().add(this);
        return this;
    }

    public void update() {
        BaseRepository.getInstance().update(this);
    }

    public void remove() {
        BaseRepository.getInstance().remove(this);
    }

    public Model get(String id) {
        if (id != null) {
            this.id = id;
        }
        return BaseRepository.getInstance().getById(this.getType(), this.getId());
    }

    public Model getByCodigo() {
        return BaseRepository.getInstance().getByCodigo(this.getType(), this.getCodigo());
    }

    public Model getByCodigo(Long codigo) {
        this.codigo = codigo;
        return getByCodigo();
    }


    public Model get() {
        return get(null);
    }

    public List<Model> listAll() {
        return BaseRepository.getInstance().listAll(getType());
    }

    public boolean isNotBlank() {
        return StringUtils.isNotBlank(this.nome) && codigo != null;
    }

    public boolean isNew() {
        return id == null;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = null;
        if (nome != null) {
            this.nome = nome.toUpperCase().trim();
        }
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
