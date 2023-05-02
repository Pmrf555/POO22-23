package Model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public abstract class Sapatilhas extends Artigos{
    private Double tamanho;
    private Boolean atacadores; // atacadores ou atilhos
    private String cor;
    private Date dataLancamento;

    public Sapatilhas(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, Double tamanho
            , Boolean atacadores, String cor, Date dataLancamento) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataLancamento = dataLancamento;
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

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

/*
    public boolean equals(Object o){
        if (this == o) return true;

        if((o == null) || this.getClass() != o.getClass()) return false;

        Sapatilhas art = (Sapatilhas) o;
        return (this.atacadores == art.getAtacadores()
                && this.tamanho == art.getTamanho() && this.cor == art.getCor()
                && this.dataLancamento == art.getDataLancamento());
    }
*/
}
