package Model;

import java.io.Serializable;

public abstract class Transportadora implements Serializable {
    private static Double imposto;
    private static Double precoBasePequena;
    private static Double precoBaseMedia;
    private static Double precoBaseGrande;
    private String nome;
    private Double margemLucro;

    public Transportadora() {
    }



    public Transportadora(String nome, Double margemLucro){
        this.nome = nome;
        this.margemLucro = margemLucro;
    }

    public Transportadora (Transportadora t){
        this.nome = t.getNome();
        this.margemLucro = t.getMargemLucro();
    }
    // Funcção que cria a fórmula de cálculo do preço de expedição
    public abstract Double precoExpedicao(Encomendas encomendas);

    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Double getImposto() {
        return imposto;
    }

    public static void setImposto(Double imposto) {
        Transportadora.imposto = imposto;
    }

    public static Double getPrecoBasePequena() {
        return precoBasePequena;
    }

    public static void setPrecoBasePequena(Double precoBasePequena) {
        Transportadora.precoBasePequena = precoBasePequena;
    }

    public static Double getPrecoBaseMedia() {
        return precoBaseMedia;
    }

    public static void setPrecoBaseMedia(Double precoBaseMedia) {
        Transportadora.precoBaseMedia = precoBaseMedia;
    }

    public static Double getPrecoBaseGrande() {
        return precoBaseGrande;
    }

    public static void setPrecoBaseGrande(Double precoBaseGrande) {
        Transportadora.precoBaseGrande = precoBaseGrande;
    }

    public Double getMargemLucro(){
        return margemLucro;
    }
    public void setMargemLucro(Double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Transportadora)) {
            return false;
        }
        Transportadora other = (Transportadora) obj;
        return other.getNome().equals(nome)
                && other.getMargemLucro() == margemLucro;
    }
}