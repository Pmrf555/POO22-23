package Model;

import java.io.Serializable;

public abstract class Artigos implements Serializable {
    private static Integer codAlfaClasse;
    private int numeroUtilizadores; //se for 0 é novo, se for maior é usado
    private Double estado; // de 0 a 1 em que 0 é gasta e 1 é como saiu de fábrica
    private String descricao;
    private String marca;
    private Integer codigoAlfa;
    private Double precoBase;
    private Double correcaoPreco;
    private String nomeTransportadora; // ""

    public Artigos(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco) {
        this.numeroUtilizadores = numeroUtilizadores;
        this.estado = estado;
        this.descricao = descricao;
        this.marca = marca;
        this.codigoAlfa = Artigos.getCodAlfaClasse();
        Artigos.setCodAlfaClasse(Artigos.getCodAlfaClasse()+1);
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
        this.nomeTransportadora = "";
    }

    public Artigos() {}

    public abstract  Double preco();

    public static Integer getCodAlfaClasse() {
        return codAlfaClasse;
    }

    public static void setCodAlfaClasse(Integer codAlfaClasse) {
        Artigos.codAlfaClasse = codAlfaClasse;
    }

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public Artigos(Artigos art){
        this.numeroUtilizadores = art.getNumeroUtilizadores();
        this.estado = art.getEstado();
        this.descricao = art.getDescricao();
        this.marca = art.getMarca();
        this.codigoAlfa = art.getCodigoAlfa();
        this.precoBase = art.getPrecoBase();
        this.correcaoPreco = art.getCorrecaoPreco();
        this.nomeTransportadora = art.getNomeTransportadora();
    }

    public int getNumeroUtilizadores() {
        return numeroUtilizadores;
    }

    public void setNumeroUtilizadores(int numeroUtilizadores) {
        this.numeroUtilizadores = numeroUtilizadores;
    }

    public Double getEstado() {
        return estado;
    }

    public void setEstado(Double estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCodigoAlfa() {
        return codigoAlfa;
    }

    public void setCodigoAlfa(Integer codigoAlfa) {
        this.codigoAlfa = codigoAlfa;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public Double getCorrecaoPreco() {
        return correcaoPreco;
    }

    public void setCorrecaoPreco(Double correcaoPreco) {
        this.correcaoPreco = correcaoPreco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Artigos artigos = (Artigos) o;
        return codigoAlfa == artigos.getCodigoAlfa();
    }



    public Artigos clone(){
        return new Artigos(this) {
            @Override
            public Double preco() {
                return null;
            }
        };
    }
}
