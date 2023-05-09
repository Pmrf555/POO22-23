package Model;

public class TransportadoraNormal extends Transportadora{
    public TransportadoraNormal(String nome, Double margemLucro) {
        super(nome, margemLucro);
    }

    public TransportadoraNormal() {
    }

    @Override
    public Double precoExpedicao(Encomendas encomendas){
        if (encomendas.getDimensaoEmbalagem().equals("pequena")) {
            return (getPrecoBasePequena() * getMargemLucro() * (1 + getImposto())) * 0.9;
        } else if(encomendas.getDimensaoEmbalagem().equals("media")){
            return (getPrecoBaseMedia() * getMargemLucro() * (1 + getImposto())) * 0.9;
        }else {
            return (getPrecoBaseGrande() * getMargemLucro() * (1 + getImposto())) * 0.9;
        }
    }

    public String toString(){
        return "\nTransportadora Normal \nImposto: " + getImposto() + "\nPreço Base Pequena: "
                +getPrecoBasePequena()+ "\nPreço Base Média: " +getPrecoBaseMedia()+ "\nPreço Base Grande: "+getPrecoBaseGrande()
                + "\nNome: "+getNome()+"\nMargem Lucro: "+getMargemLucro();
    }
}
