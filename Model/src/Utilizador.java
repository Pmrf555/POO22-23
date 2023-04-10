import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Utilizador {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private ArrayList<Artigos> ArtigosParaVenda;
    private ArrayList<Artigos> ArtigosVendidos;
    private ArrayList<Artigos> ArtigosComprados;
    private Double totalVendido; //soma do valor dos itens vendidos



    //getters and setters
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }
    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }
    public ArrayList<Artigos> getArtigosParaVenda() {
        return ArtigosParaVenda;
    }
    public void setArtigosParaVenda(ArrayList<Artigos> ArtigosParaVenda) {
        this.ArtigosParaVenda = ArtigosParaVenda;
    }
    public ArrayList<Artigos> getArtigosVendidos() {
        return ArtigosVendidos;
    }
    public void setArtigosVendidos(ArrayList<Artigos> ArtigosVendidos) {
        this.ArtigosVendidos = ArtigosVendidos;
    }
    public ArrayList<Artigos> getArtigosComprados() {
        return ArtigosComprados;
    }
    public void setArtigosComprados(ArrayList<Artigos> ArtigosComprados) {
        this.ArtigosComprados = ArtigosComprados;
    }
    public Double getTotalVendido() {
        return totalVendido;
    }
    public void setTotalVendido(Double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Utilizador utilizador = (Utilizador) obj;
        return codigo == utilizador.codigo &&
                nif == utilizador.nif &&
                Objects.equals(email, utilizador.email) &&
                Objects.equals(nome, utilizador.nome) &&
                Objects.equals(morada, utilizador.morada) &&
                Objects.equals(ArtigosParaVenda, utilizador.ArtigosParaVenda) &&
                Objects.equals(ArtigosVendidos, utilizador.ArtigosVendidos) &&
                Objects.equals(ArtigosComprados, utilizador.ArtigosComprados) &&
                Objects.equals(totalVendido, utilizador.totalVendido);
    }


    public Utilizador clone(){
        return new Utilizador(super.clone(),this);
    }

}


