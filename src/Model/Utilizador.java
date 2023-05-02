package Model;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Utilizador implements Serializable {
    private static int codigo;
    private int codigoUser;
    private String email;
    private String nome;
    private String morada;
    private long nif;
    private List<Artigos> ArtigosParaVenda;
    private Map<Date, List<Artigos>> ArtigosVendidos;
    private Map<Date,List<Artigos>> ArtigosComprados;
    private Double totalVendido; //soma do valor dos itens vendidos

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

    public Utilizador(int codigo, String email, String nome, String morada, long nif, List<Artigos> artigosParaVenda
            , Map<Date,List<Artigos>> artigosVendidos, Map<Date,List<Artigos>> artigosComprados) {
        this.codigoUser = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        ArtigosParaVenda = artigosParaVenda;
        ArtigosVendidos = artigosVendidos;
        ArtigosComprados = artigosComprados;
        this.totalVendido = calculaTotalVendido();
    }

    public Utilizador(String email, String nome, String morada, long nif) {
        this.codigoUser = Utilizador.getCodigo();
        Utilizador.setCodigo(Utilizador.getCodigo() + 1);
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        ArtigosParaVenda = new ArrayList<>();
        ArtigosVendidos = new HashMap<>();
        ArtigosComprados = new HashMap<>();
        this.totalVendido = 0.0;
    }

    public Utilizador(String email, String nome, String morada, long nif, List<Artigos> artigosParaVenda
            , Map<Date,List<Artigos>> artigosVendidos, Map<Date,List<Artigos>> artigosComprados) {
        this.codigoUser = Utilizador.getCodigo();
        Utilizador.setCodigo(Utilizador.getCodigo() + 1);
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        ArtigosParaVenda = artigosParaVenda;
        ArtigosVendidos = artigosVendidos;
        ArtigosComprados = artigosComprados;
        this.totalVendido = calculaTotalVendido();
    }

    public Utilizador() {
    }

    public Double calculaTotalVendido(){
        Double total = 0.0;
        for(List<Artigos> artigos : this.ArtigosVendidos.values()){
            for (Artigos artigos1 : artigos){
                System.out.println("User: "+getCodigoUser());
                System.out.println(artigos1.toString());
                total += artigos1.preco();
                System.out.println("Preço: " + artigos1.preco());
            }
        }
        return total;
    }

    public boolean temArtigoAssociado(Artigos artigos){
        return this.ArtigosComprados.values().stream().anyMatch(e->e.contains(artigos)) || this.ArtigosVendidos.values().stream().anyMatch(e->e.contains(artigos));
    }

    public int getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(int codigoUser) {
        this.codigoUser = codigoUser;
    }

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


    private List<List<Artigos>> artigosCompradosEntreDatas(Date inicio, Date fim){
        return this.ArtigosComprados.entrySet().stream().filter(e->(e.getKey().after(inicio) && e.getKey().before(fim))).map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Double calculaValorartigosCompradosEntreDatas(Date inicio, Date fim){
        List<List<Artigos>> a = artigosCompradosEntreDatas(inicio,fim);

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
    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }
    public List<Artigos> getArtigosParaVenda() {
        return ArtigosParaVenda;
    }
    public void setArtigosParaVenda(ArrayList<Artigos> ArtigosParaVenda) {
        this.ArtigosParaVenda = ArtigosParaVenda;
    }
    public Map<Date,List<Artigos>> getArtigosVendidos() {
        /*return ArtigosVendidos.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().map(Artigos::clone).collect(Collectors.toList())));
    */
        return ArtigosVendidos;
    }
    public void setArtigosVendidos(Map<Date,List<Artigos>> ArtigosVendidos) {
        this.ArtigosVendidos = ArtigosVendidos;
    }
    public Map<Date,List<Artigos>> getArtigosComprados() {
        /*return ArtigosComprados.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().map(Artigos::clone).collect(Collectors.toList())));
    */
    return ArtigosComprados;
    }
    public void setArtigosComprados(Map<Date,List<Artigos>> ArtigosComprados) {
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
        return codigoUser == utilizador.codigoUser &&
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
        return new Utilizador(this);
    }

    @Override
    public String toString() {
        String aux1 = "\nArtigos Para Venda:\n";

        try{
        for(Artigos artigos : this.ArtigosParaVenda){

                aux1 += "Código: "+ artigos.getCodigoAlfa().toString()+"\n";
        }
        }catch (NullPointerException e){
            System.out.println("Não tem artigos para venda");
        }

        String aux2 = "Artigos Vendidos:\n";
        try{
        for(List<Artigos> artigos : this.ArtigosVendidos.values()){
            for (Artigos artigos1 : artigos){

                    aux2+="Código: "+artigos1.getCodigoAlfa().toString()+"\n";
            }
        }
        }catch (NullPointerException e){
            System.out.println("Não tem artigos vendidos");
        }

        String aux3 = "Artigos Comprados:\n";
        try{
        for(List<Artigos> artigos : this.ArtigosComprados.values()){
            for (Artigos artigos1 : artigos){

                    aux3+="Código: "+artigos1.getCodigoAlfa().toString()+"\n";
            }
        }
        }catch (NullPointerException e){
            System.out.println("Não tem artigos comprados");
        }
        return "Utilizador{\n" +
                "codigoUser=" + codigoUser +"\n"+
                "email='" + email +"\n"+
                "nome='" + nome +"\n"+
                "morada='" + morada  +"\n"+
                "nif=" + nif +"\n"+
                aux1 + aux2 + aux3+
                "totalVendido=" + totalVendido +"\n"+
                '}';
    }
}


