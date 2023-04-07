public class Artigos {
    private int numeroUtilizadores; //se for 0 é novo, se for maior é usado
    private Double estado; // de 0 a 1 em que 0 é gasta e 1 é como saiu de fábrica
    private String descricao;
    private String marca;
    private int codigoAlfa;
    private Double precoBase;
    private Double correcaoPreco;
    private Double desconto;

    public Artigos(int numeroUtilizadores, Double estado, String descricao, String marca
            , int codigoAlfa, Double precoBase, Double correcaoPreco,Double desconto) {
        this.numeroUtilizadores = numeroUtilizadores;
        this.estado = estado;
        this.descricao = descricao;
        this.marca = marca;
        this.codigoAlfa = codigoAlfa;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
        this.desconto = desconto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Artigos(Artigos art){
        this.numeroUtilizadores = art.getNumeroUtilizadores();
        this.estado = art.getEstado();
        this.descricao = art.getDescricao();
        this.marca = art.getMarca();
        this.codigoAlfa = art.getCodigoAlfa();
        this.precoBase = art.getPrecoBase();
        this.correcaoPreco = art.getCorrecaoPreco();
        this.desconto = art.getDesconto();
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

    public int getCodigoAlfa() {
        return codigoAlfa;
    }

    public void setCodigoAlfa(int codigoAlfa) {
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

    public boolean equals(Object o){
        if (this == o) return true;

        if((o == null) || this.getClass() != o.getClass()) return false;

        Artigos art = (Artigos) o;
        return (this.numeroUtilizadores == art.getNumeroUtilizadores() && this.codigoAlfa == art.getCodigoAlfa()
                && this.correcaoPreco == art.getCorrecaoPreco() && this.precoBase == art.getPrecoBase()
                && this.estado == art.getEstado() && this.descricao.equals(art.getDescricao())
                && this.marca.equals(art.getMarca()));
    }

    public Artigos clone(){
        return new Artigos(this);
    }
}