package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface IParser extends Serializable {

    public void lerFicheiro(Gestor ges,String nomeFicheiro) throws IOException;

    public Encomendas lerEncomendas(Gestor ges,BufferedReader fileArq) throws IOException;

    public Transportadora lerTransportadoras(BufferedReader fileArq) throws IOException;

    public TShirt lerTShirt(BufferedReader fileArq) throws IOException;

    public MalasNormais lerMalaNormal(BufferedReader fileArq) throws IOException;

    public MalasPremium lerMalaPremium(BufferedReader fileArq) throws IOException;

    public Sapatilhas lerSapatilhas(BufferedReader fileArq) throws IOException;

}