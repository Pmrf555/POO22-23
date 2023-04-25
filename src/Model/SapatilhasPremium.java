package Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SapatilhasPremium extends Sapatilhas{ //nunca tem desconto mas aumenta o preço consoante os anos que ele tem

    public SapatilhasPremium(int numeroUtilizadores, Double estado, String descricao, String marca, Long codigoAlfa, Double precoBase, Double correcaoPreco, Double tamanho, Boolean atacadores, String cor, LocalDateTime dataLancamento) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, tamanho, atacadores, cor, dataLancamento);
    }

    public SapatilhasPremium(Artigos artigos, Sapatilhas sapatilhas){
        super(artigos,sapatilhas);
    }

    public Double preco(){
        return super.getPrecoBase() + (10 * LocalDateTime.now().until(super.getDataLancamento(), ChronoUnit.YEARS)); // o 10 foi inventado não sei se é preciso um número especifico
    }
}
