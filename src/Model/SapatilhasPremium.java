package Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SapatilhasPremium extends Sapatilhas{ //nunca tem desconto mas aumenta o preço consoante os anos que ele tem

    public SapatilhasPremium(int numeroUtilizadores, Double estado, String descricao, String marca, Double precoBase
            , Double correcaoPreco, Double tamanho, Boolean atacadores, String cor, Date dataLancamento) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, tamanho, atacadores, cor, dataLancamento);
    }

    public Double preco(){
        Date now = new Date();
        return super.getPrecoBase() + (10 * (now.getYear() - super.getDataLancamento().getYear())); // o 10 foi inventado não sei se é preciso um número especifico
    }

    public String toString(){
        return "Número Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nTamanho: "
                +getTamanho()+ "\nAtacadores: " +getAtacadores()+"\nCor: "+getCor();
    }
}
