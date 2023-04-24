package Model;

import java.util.Objects;
public class TransportadoraNormal extends Transportadora{
    public TransportadoraNormal(Transportadora transportadora) {super (transportadora);}

    public TransportadoraNormal(String nome, Double precoBasePequena, Double precoBaseMedia,
                                Double precoBaseGrande, Double imposto, Double formula){
        super(nome, precoBasePequena, precoBaseMedia, precoBaseGrande, imposto, formula);
    }




}
