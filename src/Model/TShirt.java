package Model;

import java.util.Objects;

public class TShirt extends Artigos{
    private String tamanho;
    private String padrao; // se padrão for diferente de liso tem 50% desconto
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return tamanho == tShirt.getTamanho() && padrao ==tShirt.getPadrao();
    }
*/
    public TShirt(int numeroUtilizadores, Double estado, String descricao
            , String marca, Double precoBase, Double correcaoPreco, String tamanho, String padrao) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public void desconto(){
        if(!this.padrao.equals("liso")) setCorrecaoPreco(50.0);
        else setCorrecaoPreco(0.0);
    }

    public Double preco(){
        return getPrecoBase() * (getCorrecaoPreco() / 100);
    }

    public String toString(){
        return "Número Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nTamanho: "
                +getTamanho()+ "\nPadrão: " +getPadrao();
    }
}
