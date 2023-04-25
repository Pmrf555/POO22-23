package Model;

import java.time.LocalDateTime;

public class SapatilhasNormais extends Sapatilhas{
    public SapatilhasNormais(Artigos artigos,Sapatilhas sapatilhas){
        super(artigos,sapatilhas);
    }

    public SapatilhasNormais(int numeroUtilizadores, Double estado, String descricao, String marca, Long codigoAlfa
            , Double precoBase, Double correcaoPreco, Double tamanho, Boolean atacadores, String cor
            , LocalDateTime dataLancamento, Double desconto) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, tamanho, atacadores, cor, dataLancamento, desconto);
    }

    public Double preco(){
        return getPrecoBase() + (getPrecoBase() / getNumeroUtilizadores() * getEstado()) * (getDesconto() / 100);
    }

    public void desconto(Double desconto){
        if(getNumeroUtilizadores() > 0 || getTamanho() > 45) setDesconto(desconto);
        else setDesconto(1.0);
    }
}
