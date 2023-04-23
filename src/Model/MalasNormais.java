package Model;

import java.time.LocalDateTime;

public class MalasNormais extends Malas{

    public MalasNormais(int numeroUtilizadores, Double estado, String descricao, String marca
            , Long codigoAlfa, Double precoBase, Double correcaoPreco, Double desconto, int dimensao, String material, int ano) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, desconto, dimensao, material, ano);
    }

    public MalasNormais(Artigos art, int dimensao, String material, int ano) {
        super(art, dimensao, material, ano);
    }

    public MalasNormais() {
        super();
    }

    public Double preco(){
        return getPrecoBase() - (4 * LocalDateTime.now().getYear()-getAno()); //o valor decresce 4 euros por ano, o enunciado não diz nada de jeito aqui

    }
}
