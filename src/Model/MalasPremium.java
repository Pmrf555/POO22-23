package Model;

import java.time.LocalDateTime;

public class MalasPremium extends Malas{
    private double valorizacao;

    public MalasPremium() {

    }

    public double getValorizacao() {
        return valorizacao;
    }

    public void setValorizacao(double valorizacao) {
        this.valorizacao = valorizacao;
    }

    public Double preco(){
        return getPrecoBase() + (this.valorizacao * LocalDateTime.now().getYear()-getAno());
    }

    public MalasPremium(int numeroUtilizadores, Double estado, String descricao, String marca, Long codigoAlfa
            , Double precoBase, Double correcaoPreco, int dimensao, String material, int ano, double valorizacao) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, dimensao, material, ano);
        this.valorizacao = valorizacao;
    }

    public MalasPremium(Artigos art, int dimensao, String material, int ano, double valorizacao) {
        super(art, dimensao, material, ano);
        this.valorizacao = valorizacao;
    }
}
