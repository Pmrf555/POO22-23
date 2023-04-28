package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Gestor implements IGestor{
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
        Artigos.setCodAlfaClasse(1L);
        Encomendas.setNumeroEnc(0);
        Utilizador.setCodigo(1);
        Transportadora.setImposto(16.0);
        Transportadora.setPrecoBasePequena(10.0);
        Transportadora.setPrecoBaseMedia(13.5);
        Transportadora.setPrecoBaseGrande(15.0);
        Encomendas.setTaxaSatisfacaoServicoNovo(0.5);
        Encomendas.setTaxaSatisfacaoServicoUsado(0.25);
    }

    public Utilizador vendedorQueMaisFaturouSempre(){
        try {
            List<Utilizador> utilizadors = this.utilizadorMap.values().stream().sorted((p1, p2) -> (int) (p1.getTotalVendido() - p2.getTotalVendido())).toList();
            return utilizadors.get(0);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return new Utilizador();
    }

    // Função que determina qual é o vendedor que mais faturou num período ou desde sempre
    public Utilizador vendedorQueMaisFaturouEntreDatas(Date inicio,Date fim) {
        Utilizador aux = new Utilizador();
        Double valorMax = 0.0;
        try {
            for (Utilizador user: utilizadorMap.values()){
                if(user.calculaValorartigosVendidosEntreDatas(inicio,fim) > valorMax){
                    aux = user;
                    valorMax = user.calculaValorartigosVendidosEntreDatas(inicio,fim);
                }
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        return aux;
    }

    // Função que determina qual o transportador com maior volume de faturação
    public Transportadora transportadoraComMaiorFaturacao(){
        Transportadora maiorFatura = new Transportadora();
        Double faturacao = 0.0;
        Double max = 0.0;
        try {
            for(Transportadora trans : transportadoraMap.values()){
                for (Encomendas enc : encomendasMap.values()){
                    if(enc.getArtigos().get(0).getNomeTransportadora().equals(trans.getNome())){
                        faturacao += trans.precoExpedicao(enc);
                    }
                }
                if(faturacao > max){
                    max = faturacao;
                    maiorFatura = trans;
                }
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        return maiorFatura;
    }

    // Função para listar as encomendas emitidas por um vendedor
    public List<Encomendas> encomendasEmitidasPorVendedor(Integer codUtilizador) {
        Utilizador user = utilizadorMap.get(codUtilizador);
        List<Encomendas> aux = new ArrayList<Encomendas>();
        try{
            for (Encomendas enc : encomendasMap.values()) {
                Boolean flag = false;
                for (Artigos artigos : enc.getArtigos()) {
                    if (user.temArtigoAssociado(artigos)) {
                        flag = true;
                    }
                }
                if(flag){
                    aux.add(enc);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return aux;
    }

    // Função que irá fornecer uma ordenação dos maiores vendedores do sistema durante um período a determinar
    public List<Utilizador> maioresVendedoresSistema(Date inicio,Date fim, int quantosNoTop) {
        try{
            return this.utilizadorMap.values().stream()
                    .sorted(Comparator.comparingDouble(e -> e.calculaValorartigosVendidosEntreDatas(inicio, fim)))
                    .limit(quantosNoTop).collect(Collectors.toList());
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    return new ArrayList<>();
    }

    // Função que irá fornecer uma ordenação dos maiores compradores do sistema durante um período a determinar
    public List<Utilizador> maioresCompradoresSistema(Date inicio,Date fim, int quantosNoTop) {
        try {
            return this.utilizadorMap.values().stream()
                .sorted(Comparator.comparingDouble(e -> e.calculaValorartigosCompradosEntreDatas(inicio, fim)))
                .limit(quantosNoTop).collect(Collectors.toList());
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    // Função para determinar quanto dinheiro ganhou o ‘Vintage’ no seu funcionamento
    public double lucroVintage(){
        double lucro = 0.0;
        try {
            for(Encomendas encs : encomendasMap.values()){
                lucro += encs.calcularTaxaVintage();
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return lucro;
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



