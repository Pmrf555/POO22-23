package Model;

import java.time.LocalDateTime;

public class SapatilhasNormais extends Sapatilhas{
    public SapatilhasNormais(Artigos artigos,Sapatilhas sapatilhas){
        super(artigos,sapatilhas);
    }

    public SapatilhasNormais(int numeroUtilizadores, Double estado, String descricao, String marca, Long codigoAlfa
            , Double precoBase, Double correcaoPreco, Double tamanho, Boolean atacadores, String cor
            , LocalDateTime dataLancamento) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, tamanho, atacadores, cor, dataLancamento);
    }
    public SapatilhasNormais(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, Double tamanho, Boolean atacadores, String cor
            , LocalDateTime dataLancamento) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, tamanho, atacadores, cor, dataLancamento);
    }
    public Double preco(){
        return getPrecoBase() + (getPrecoBase() / getNumeroUtilizadores() * getEstado()) * (getCorrecaoPreco() / 100);
    }

    public void desconto(Double desconto){
        if(getNumeroUtilizadores() > 0 || getTamanho() > 45) setCorrecaoPreco(desconto);
        else setCorrecaoPreco(1.0);
    }
    public String toString(){
        return "Número Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nTamanho: "
                +getTamanho()+ "\nAtacadores: " +getAtacadores()+"\nCor: "+getCor();
    }
}
