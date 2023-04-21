package Model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Gestor {
    private Map<Long,Artigos> artigosMap; //key->codigo alfanumerico
    private Map<String ,Transportadora> transportadoraMap; // key-> nome
    private Map<Integer,Utilizador> utilizadorMap; //key->codigo
    private Map<Integer,Encomendas> encomendasMap; //key->numero de encomenda (variável de classe que incrementa sempre que se cria uma encomenda
    private Date dataAtual;

    public Gestor() {
        this.artigosMap = new HashMap<>();
        this.transportadoraMap = new HashMap<>();
        this.utilizadorMap = new HashMap<>();
        this.encomendasMap = new HashMap<>();
        this.dataAtual = new Date();
    }

    public Map<Long, Artigos> getArtigosMap() {
        return artigosMap;
    }

    public void setArtigosMap(Map<Long, Artigos> artigosMap) {
        this.artigosMap = artigosMap;
    }

    public Map<String, Transportadora> getTransportadoraMap() {
        return transportadoraMap;
    }

    public void setTransportadoraMap(Map<String, Transportadora> transportadoraMap) {
        this.transportadoraMap = transportadoraMap;
    }

    public Map<Integer, Utilizador> getUtilizadorMap() {
        return utilizadorMap;
    }

    public void setUtilizadorMap(Map<Integer, Utilizador> utilizadorMap) {
        this.utilizadorMap = utilizadorMap;
    }

    public Map<Integer, Encomendas> getEncomendasMap() {
        return encomendasMap;
    }

    public void setEncomendasMap(Map<Integer, Encomendas> encomendasMap) {
        this.encomendasMap = encomendasMap;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }
    // Criar Utilizadores, Artigos, Transportadoras, Encomendas \\

}



