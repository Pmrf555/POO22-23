package Model;

import java.time.LocalDateTime;

public class MalasPremium extends Malas implements ProdutosPremium {
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
        Double dimensao = (double) getDimensao();
        setCorrecaoPreco(1.0 /dimensao);
        return (getPrecoBase() + (this.valorizacao * LocalDateTime.now().getYear()-getAno())) * (getCorrecaoPreco()/100);
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MalasPremium that = (MalasPremium) o;
        return valorizacao == that.getValorizacao();
    }
*/

    public MalasPremium(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, int dimensao, String material, int ano, double valorizacao) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, dimensao, material, ano);
        this.valorizacao = valorizacao;
    }
    public String toString(){
        return "\nMalas Premium:\nNúmero Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nDimensão: "
                +getDimensao()+ "\nMaterial: " +getMaterial()+"\nAno: "+getAno()+"\nValorização: "+getValorizacao();
    }
}
