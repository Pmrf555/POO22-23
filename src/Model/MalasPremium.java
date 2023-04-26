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

    public MalasPremium(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, int dimensao, String material, int ano, double valorizacao) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, dimensao, material, ano);
        this.valorizacao = valorizacao;
    }
    public String toString(){
        return "Número Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nDimensão: "
                +getDimensao()+ "\nMaterial: " +getMaterial()+"\nAno: "+getAno()+"\nValorização: "+getValorizacao();
    }
}
