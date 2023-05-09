package Model;

public class TransportadoraPremium extends Transportadora{
    public TransportadoraPremium(String nome, Double margemLucro) {
        super(nome, margemLucro);
    }

    @Override
    public Double precoExpedicao(Encomendas encomendas) {
        if (encomendas.getDimensaoEmbalagem().equals("pequena")) {
            return (getPrecoBasePequena() * getMargemLucro() * (1 + getImposto())) * 1.5;
        } else if(encomendas.getDimensaoEmbalagem().equals("media")){
            return (getPrecoBaseMedia() * getMargemLucro() * (1 + getImposto())) * 1.5;
        }else {
            return (getPrecoBaseGrande() * getMargemLucro() * (1 + getImposto())) * 1.5;
        }
    }

    public String toString(){
        return "\nTransportadora Premium \nImposto: " + getImposto() + "\nPreço Base Pequena: "
                +getPrecoBasePequena()+ "\nPreço Base Média: " +getPrecoBaseMedia()+ "\nPreço Base Grande: "+getPrecoBaseGrande()
                + "\nNome: "+getNome()+"\nMargem Lucro: "+getMargemLucro();
    }
}
