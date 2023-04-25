package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Utilizador<ArtigosVendidos> {
    private static int codigo;
    private int codigoUser;

    public int getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(int codigoUser) {
        this.codigoUser = codigoUser;
    }

    private String email;
    private String nome;
    private String morada;
    private int nif;
    private ArrayList<Artigos> ArtigosParaVenda;
    private Map<Date, List<Artigos>> ArtigosVendidos;
    private ArrayList<Artigos> ArtigosComprados;
    private Double totalVendido; //soma do valor dos itens vendidos


    private List<List<Artigos>> artigosVendidosEntreDatas(Date inicio, Date fim){
        return this.ArtigosVendidos.entrySet().stream().filter(e->(e.getKey().after(inicio) && e.getKey().before(fim))).map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Double calculaValorartigosVendidosEntreDatas(Date inicio, Date fim){
        List<List<Artigos>> a = artigosVendidosEntreDatas(inicio,fim);

        Double total = 0.0;

        for (List<Artigos> b : a){
            for (Artigos c : b){
                total += c.preco();
            }
        }
        return total;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        Utilizador.codigo = codigo;
    }

    //getters and setters
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
        return (ArrayList<Artigos>) ArtigosParaVenda.stream().map(Artigos::clone).collect(Collectors.toList());
    }
    public void setArtigosParaVenda(ArrayList<Artigos> ArtigosParaVenda) {
        this.ArtigosParaVenda = ArtigosParaVenda;
    }
    public Map<Date,List<Artigos>> getArtigosVendidos() {
        return ArtigosVendidos.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().map(Artigos::clone).collect(Collectors.toList())));
    }
    public void setArtigosVendidos(Map<Date,List<Artigos>> ArtigosVendidos) {
        this.ArtigosVendidos = ArtigosVendidos;
    }
    public ArrayList<Artigos> getArtigosComprados() {
        return (ArrayList<Artigos>) ArtigosComprados.stream().map(Artigos::clone).collect(Collectors.toList());
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

    public Utilizador(Utilizador aux){
        this.codigoUser = Utilizador.getCodigo();
        Utilizador.setCodigo(Utilizador.getCodigo() + 1);
        this.email = aux.getEmail();
        this.nome = aux.getNome();
        this.morada = aux.getMorada();
        this.nif = aux.getNif();
        ArtigosParaVenda = aux.getArtigosParaVenda();
        ArtigosVendidos = aux.getArtigosVendidos();
        ArtigosComprados = aux.getArtigosComprados();
        this.totalVendido = aux.getTotalVendido();
    }

    public Utilizador(int codigo, String email, String nome, String morada, int nif, ArrayList<Artigos> artigosParaVenda
            , Map<Date,List<Artigos>> artigosVendidos, ArrayList<Artigos> artigosComprados, Double totalVendido) {
        this.codigoUser = Utilizador.getCodigo();
        Utilizador.setCodigo(Utilizador.getCodigo() + 1);
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        ArtigosParaVenda = artigosParaVenda;
        ArtigosVendidos = artigosVendidos;
        ArtigosComprados = artigosComprados;
        this.totalVendido = totalVendido;
    }

    public Utilizador clone(){
        return new Utilizador(this);
    }

}


