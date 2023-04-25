package Model;

import java.util.Objects;

public class Transportadora {
    private String nome;
    private Double precoBasePequena;
    private Double precoBaseMedia;
    private Double precoBaseGrande;
    private Double imposto;
    private Double formula;


    public Transportadora(String nome, Double precoBasePequena, Double precoBaseMedia,
                          Double precoBaseGrande, Double imposto, Double formula){
        this.nome = nome;
        this.precoBasePequena = precoBasePequena;
        this.precoBaseMedia = precoBaseMedia;
        this.precoBaseGrande = precoBaseGrande;
        this.imposto = imposto;
        this.formula = formula;
    }

    public Transportadora (Transportadora t){
        this.nome = t.getNome();
        this.precoBasePequena = t.getPrecoBasePequena();
        this.precoBaseMedia = t.getPrecoBaseMedia();
        this.precoBaseGrande = t.getPrecoBaseGrande();
        this.imposto = t.getImposto();
        this.formula = t.getFormula();
    }


    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPrecoBasePequena() {
        return precoBasePequena;
    }
    public void setPrecoBasePequena(Double precoBasePequena) {
        this.precoBasePequena = precoBasePequena;
    }
    public Double getPrecoBaseMedia() {
        return precoBaseMedia;
    }
    public void setPrecoBaseMedia(Double precoBaseMedia) {
        this.precoBaseMedia = precoBaseMedia;
    }
    public Double getPrecoBaseGrande() {
        return precoBaseGrande;
    }
    public void setPrecoBaseGrande(Double precoBaseGrande) {
        this.precoBaseGrande = precoBaseGrande;
    }
    public Double getImposto() {
        return imposto;
    }
    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }
    public Double getFormula() { return formula;}
    public void setFormula(Double formula) {this.formula  = formula;}

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Transportadora)) {
            return false;
        }
        Transportadora other = (Transportadora) obj;
        return Objects.equals(nome, other.nome)
                && Objects.equals(precoBasePequena, other.precoBasePequena)
                && Objects.equals(precoBaseMedia, other.precoBaseMedia)
                && Objects.equals(precoBaseGrande, other.precoBaseGrande)
                && Objects.equals(imposto, other.imposto);
    }
}
