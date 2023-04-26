package Model;

import java.time.LocalDateTime;

public class MalasNormais extends Malas{

    public MalasNormais(int numeroUtilizadores, Double estado, String descricao, String marca
            , Long codigoAlfa, Double precoBase, Double correcaoPreco, int dimensao, String material, int ano) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, dimensao, material, ano);
    }

    public MalasNormais(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, int dimensao, String material, int ano) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, dimensao, material, ano);
    }

    public MalasNormais() {
        super();
    }

    public Double preco(){
        return getPrecoBase() - (4 * LocalDateTime.now().getYear()-getAno()); //o valor decresce 4 euros por ano, o enunciado não diz nada de jeito aqui

    }

    public String toString(){
        return "Número Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nDimensão: "
                +getDimensao()+ "\nMaterial: " +getMaterial()+"\nAno: "+getAno();
    }
}
