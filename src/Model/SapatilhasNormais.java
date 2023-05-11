package Model;

import java.util.Date;

public class SapatilhasNormais extends Sapatilhas{

    public SapatilhasNormais(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, Double tamanho, Boolean atacadores, String cor
            , Date dataLancamento) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, tamanho, atacadores, cor, dataLancamento);
    }
    public Double preco(){
        if(getNumeroUtilizadores() == 0 || getTamanho() < 45) setCorrecaoPreco(1.0);
        return (getPrecoBase() + (getPrecoBase() / getNumeroUtilizadores() * getEstado())) * (getCorrecaoPreco()/100);
    }

    public String toString(){
        return "\nSapatilhas Normais:\nNúmero Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nTamanho: "
                +getTamanho()+ "\nAtacadores: " +getAtacadores()+"\nCor: "+getCor();
    }
}
