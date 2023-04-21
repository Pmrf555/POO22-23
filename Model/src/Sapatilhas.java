import java.time.LocalDateTime;

public abstract class Sapatilhas extends Artigos{
    private Double tamanho;
    private Boolean atacadores; // atacadores ou atilhos
    private String cor;
    private LocalDateTime dataLancamento;

    public Sapatilhas(int numeroUtilizadores, Double estado, String descricao, String marca
            , int codigoAlfa, Double precoBase, Double correcaoPreco, Double tamanho
            , Boolean atacadores, String cor, LocalDateTime dataLancamento, Double desconto) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco,desconto);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataLancamento = dataLancamento;
    }

    public Sapatilhas(Artigos art, Double tamanho, Boolean atacadores, String cor, LocalDateTime dataLancamento) {
        super(art);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataLancamento = dataLancamento;
    }

    public Sapatilhas(Artigos artigos,Sapatilhas sapatilhas){
        super(artigos);
        this.tamanho = sapatilhas.getTamanho();
        this.atacadores = sapatilhas.getAtacadores();
        this.cor = sapatilhas.getCor();
        this.dataLancamento = sapatilhas.getDataLancamento();
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public Boolean getAtacadores() {
        return atacadores;
    }

    public void setAtacadores(Boolean atacadores) {
        this.atacadores = atacadores;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


    public boolean equals(Object o){
        if (this == o) return true;

        if((o == null) || this.getClass() != o.getClass()) return false;

        Sapatilhas art = (Sapatilhas) o;
        return (this.atacadores == art.getAtacadores()
                && this.tamanho == art.getTamanho() && this.cor == art.getCor()
                && this.dataLancamento == art.getDataLancamento());
    }

}
