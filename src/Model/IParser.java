package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

public interface IParser extends Serializable {

    public void guardaBin(String nomeFicheiro,IGestor gestor) throws FileNotFoundException, IOException;

    public IGestor readBin(String nomeFich) throws IOException, ClassNotFoundException;

    public void lerFicheiro(IGestor ges) throws IOException, ParseException;

    public Encomendas lerEncomendas(IGestor ges,BufferedReader fileArq) throws IOException, ParseException;

    public Transportadora lerTransportadoras(BufferedReader fileArq) throws IOException;

    public Artigos lerTShirt(BufferedReader fileArq) throws IOException;

    public Artigos lerMalaNormal(BufferedReader fileArq) throws IOException;

    public Artigos lerMalaPremium(BufferedReader fileArq) throws IOException;

    public Artigos lerSapatilhasNormais(BufferedReader fileArq) throws IOException, ParseException;
    public Artigos lerSapatilhasPremium(BufferedReader fileArq) throws IOException, ParseException;

}