package br.cesjf.lppo;

public class Equipamento {
    private Long id;
    private String serie;
    private String local;
    private String descricao;
    private Integer estado;

    public Equipamento() {
    }

    public Long getId() {
        return id;
    }  

    void setId(long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    public String stringEstado () {
        switch (estado) {
            case 0:
                return "Novo";
            case 1:
                return "Em uso";
            case 2:
                return "Danificado";
            case 3:
                return "Perdido";
            default: return "";
        }
    }
}
