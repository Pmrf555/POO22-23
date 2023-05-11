package Model;

import java.util.Date;

public class SapatilhasPremium extends Sapatilhas implements ProdutosPremium { //nunca tem desconto mas aumenta o preço consoante os anos que ele tem

    public SapatilhasPremium(int numeroUtilizadores, Double estado, String descricao, String marca, Double precoBase
            , Double correcaoPreco, Double tamanho, Boolean atacadores, String cor, Date dataLancamento) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, tamanho, atacadores, cor, dataLancamento);
    }

    public Double preco(){
        Date now = new Date();
        return super.getPrecoBase() + (0.5 * (now.getYear() - super.getDataLancamento().getYear()));
    }

    public String toString(){
        return "\nSapatilhas Premium:\nNúmero Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nTamanho: "
                +getTamanho()+ "\nAtacadores: " +getAtacadores()+"\nCor: "+getCor();
    }
}
