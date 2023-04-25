package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

public interface IParser extends Serializable {

    public void lerFicheiro(IGestor ges) throws IOException, ParseException;

    public Encomendas lerEncomendas(IGestor ges,BufferedReader fileArq) throws IOException, ParseException;

    public Transportadora lerTransportadoras(BufferedReader fileArq) throws IOException;

    public TShirt lerTShirt(BufferedReader fileArq) throws IOException;

    public MalasNormais lerMalaNormal(BufferedReader fileArq) throws IOException;

    public MalasPremium lerMalaPremium(BufferedReader fileArq) throws IOException;

    public Sapatilhas lerSapatilhas(BufferedReader fileArq) throws IOException;

}