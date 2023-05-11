package Model;

import java.time.LocalDateTime;

public class MalasNormais extends Malas  {

    public MalasNormais(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, int dimensao, String material, int ano) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco, dimensao, material, ano);
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }

    public MalasNormais() {
        super();
    }

    public Double preco(){
        Double preco = 0.0;
        Double dimensao = (double) getDimensao();
        setCorrecaoPreco(1.0 /dimensao);
        try {
            preco = (getPrecoBase() - ((LocalDateTime.now().getYear()-getAno()) * 0.1)) * (getCorrecaoPreco()/100);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return preco;
    }

    public String toString(){
        return "\nMalas Normais:\nNúmero Utilizadores: " + getNumeroUtilizadores() + "\nEstado: "
                +getEstado()+ "\nDescricao: " +getDescricao()+ "\nMarca: "+getMarca()+ "\nCodigo Alfanumerico: "
                +getCodigoAlfa()+"\nPreço Base: "+getPrecoBase()+"\nCorreção Preço: "+getCorrecaoPreco()+"\nDimensão: "
                +getDimensao()+ "\nMaterial: " +getMaterial()+"\nAno: "+getAno();
    }
}
