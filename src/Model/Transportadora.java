package Model;

import java.util.Objects;

public class Transportadora {
    private String nome;
    private Double precoBasePequena;
    private Double precoBaseMedia;
    private Double precoBaseGrande;
    private Double imposto;
    private Boolean premium;

    public Transportadora(String nome, Double precoBasePequena, Double precoBaseMedia,
                          Double precoBaseGrande, Double imposto, Boolean premium){
        this.nome = nome;
        this.precoBasePequena = precoBasePequena;
        this.precoBaseMedia = precoBaseMedia;
        this.precoBaseGrande = precoBaseGrande;
        this.imposto = imposto;
        this.premium = premium;
    }

    public Transportadora (Transportadora t){
        this.nome = t.getNome();
        this.precoBasePequena = t.getPrecoBasePequena();
        this.precoBaseMedia = t.getPrecoBaseMedia();
        this.precoBaseGrande = t.getPrecoBaseGrande();
        this.imposto = t.getImposto();
        this.premium = t.getPremium();
    }

    public Double calculaValorTransporte(Encomendas enc){
        Double preco = 0.00;
        if (enc.getDimensaoEmbalagem().equals("pequena")){
            preco = precoBasePequena * (1+this.imposto);
        }
        if (enc.getDimensaoEmbalagem().equals("media")){
            preco = precoBaseMedia * (1+this.imposto);
        }
        if (enc.getDimensaoEmbalagem().equals("grande")){
            preco = precoBaseGrande * (1+this.imposto);
        }
        return preco;
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

    public Boolean getPremium() {
        return premium;
    }
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

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
                && Objects.equals(imposto, other.imposto)
                && Objects.equals(premium, other.premium);
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }
}
