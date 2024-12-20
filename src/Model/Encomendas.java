package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Encomendas implements Serializable {
    private static int numeroEnc;
    private int numeroEncomenda;
    private List<Artigos> artigos;
    private String dimensaoEmbalagem;
    private double precoFinal;
    private static double taxaSatisfacaoServicoNovo;
    private static double taxaSatisfacaoServicoUsado;
    private double custosExpedicao;

    private String estado;
    private Date dataCriacao;
    private Date prazoLimite;
    private Utilizador fezEncomenda;

    private Double calculaPrecoFinal(List<Artigos> artigos,Double custosExpedicao) throws NullPointerException{
        try {
            return artigos.stream().mapToDouble(Artigos::preco).sum() + custosExpedicao;
        }catch (NullPointerException e){
            System.out.println("Não existem artigos :)");
        }
        return 0.0;
    }

    public static int getNumeroEnc() {
        return numeroEnc;
    }

    public static void setNumeroEnc(int numeroEnc) {
        Encomendas.numeroEnc = numeroEnc;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Encomendas(List<Artigos> artigos, String dimensaoEmbalagem, double custosExpedicao, String estado, Date dataCriacao, Date prazoLimite) {
        this.numeroEncomenda = Encomendas.getNumeroEnc();
        Encomendas.setNumeroEnc(Encomendas.getNumeroEnc()+1);
        this.artigos = artigos;
        this.dimensaoEmbalagem = dimensaoEmbalagem;
        this.custosExpedicao = custosExpedicao;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
        this.prazoLimite = prazoLimite;
        this.precoFinal = calculaPrecoFinal(artigos,custosExpedicao);
        this.fezEncomenda = new Utilizador();
    }

    public Encomendas(int numeroEnc, List<Artigos> artigos, String dimensaoEmbalagem, double custosExpedicao, String estado, Date dataCriacao, Date prazoLimite) {
        this.numeroEncomenda = numeroEnc;
        this.artigos = artigos;
        this.dimensaoEmbalagem = dimensaoEmbalagem;
        this.custosExpedicao = custosExpedicao;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
        this.prazoLimite = prazoLimite;
        this.precoFinal = calculaPrecoFinal(artigos,custosExpedicao);
        this.fezEncomenda = new Utilizador();
    }
    // Construtor da classe Encomenda
    public Encomendas(String dimensaoEmbalagem, double custosExpedicao) {
        this.artigos = new ArrayList<>();
        this.dimensaoEmbalagem = dimensaoEmbalagem;
        this.precoFinal = 0;
        this.custosExpedicao = custosExpedicao;
        this.estado = "pendente";
        this.dataCriacao = new Date();
        this.prazoLimite = new Date(dataCriacao.getTime() + (1000 * 60 * 60 * 24 * 2)); // prazo de 48 horas
        Encomendas.numeroEnc = getNumeroEnc();
        Encomendas.setNumeroEnc(getNumeroEnc()+1);
        this.fezEncomenda = new Utilizador();
    }
    public Utilizador getFezEncomenda() {
        return fezEncomenda;
    }

    public void setFezEncomenda(Utilizador fezEncomenda) {
        this.fezEncomenda = fezEncomenda;
    }
    // Adiciona um artigo à encomenda
    public void adicionarArtigo(Artigos artigo) {
        artigos.add(artigo);
        calcularPrecoFinal();
    }

    // Remove um artigo da encomenda
    public void removerArtigo(Artigos artigo) {
        artigos.remove(artigo);
        calcularPrecoFinal();
    }

    // Calcula o preço final da encomenda
    private void calcularPrecoFinal() {
        precoFinal = 0;
        for (Artigos artigo : artigos) {
            if (artigo.getEstado() == 1) {
                precoFinal += artigo.preco() + taxaSatisfacaoServicoNovo;

            } else {
                precoFinal += artigo.preco() + taxaSatisfacaoServicoUsado;
            }
        }
        precoFinal += custosExpedicao;
    }

    // Calcula a taxa de comissão que a ‘Vintage’ recebe
    public double calcularTaxaVintage() {

        double taxaVintage = 0;

        for (Artigos artigo : artigos) {
            if (artigo.getEstado() == 1) {
                taxaVintage += taxaSatisfacaoServicoNovo;
            } else {
                taxaVintage += taxaSatisfacaoServicoUsado;
            }
        }
        return taxaVintage;
    }

    // Devolve a encomenda, caso ainda esteja dentro do prazo limite
    public void devolverEncomenda() {
        Date dataAtual = new Date();
        if (dataAtual.before(prazoLimite)) {
            estado = "devolvida";
        } else {
            System.out.println("Não é possível devolver a encomenda, prazo limite excedido.");
        }
    }

    // Getters e Setters
    public int getNumeroEncomenda() {
        return numeroEncomenda;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }
    public List<Artigos> getArtigos() {
        return artigos;
    }

    public String getDimensaoEmbalagem() {
        return dimensaoEmbalagem;
    }

    public void setDimensaoEmbalagem(String dimensaoEmbalagem) {
        this.dimensaoEmbalagem = dimensaoEmbalagem;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public static double getTaxaSatisfacaoServicoNovo() {
        return taxaSatisfacaoServicoNovo;
    }

    public static void setTaxaSatisfacaoServicoNovo(double taxaSatisfacaoServicoNovo) {
        Encomendas.taxaSatisfacaoServicoNovo = taxaSatisfacaoServicoNovo;
    }

    public static double getTaxaSatisfacaoServicoUsado() {
        return taxaSatisfacaoServicoUsado;
    }

    public static void setTaxaSatisfacaoServicoUsado(double taxaSatisfacaoServicoUsado) {
        Encomendas.taxaSatisfacaoServicoUsado = taxaSatisfacaoServicoUsado;
    }

    public double getCustosExpedicao() {
        return custosExpedicao;
    }

    public void setCustosExpedicao(double custosExpedicao) {
        this.custosExpedicao = custosExpedicao;
        calcularPrecoFinal();
    }

    public String getEstado() {
        return estado;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getPrazoLimite() {
        return prazoLimite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomendas that = (Encomendas) o;
        return Double.compare(that.precoFinal, precoFinal) == 0 && Double.compare(that.taxaSatisfacaoServicoNovo, taxaSatisfacaoServicoNovo) == 0 && Double.compare(that.taxaSatisfacaoServicoUsado, taxaSatisfacaoServicoUsado) == 0 && Double.compare(that.custosExpedicao, custosExpedicao) == 0 && Objects.equals(artigos, that.artigos) && Objects.equals(dimensaoEmbalagem, that.dimensaoEmbalagem) && Objects.equals(estado, that.estado) && Objects.equals(dataCriacao, that.dataCriacao) && Objects.equals(prazoLimite, that.prazoLimite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artigos, dimensaoEmbalagem, precoFinal, taxaSatisfacaoServicoNovo, taxaSatisfacaoServicoUsado, custosExpedicao, estado, dataCriacao, prazoLimite);
    }

    @Override
    public String toString() {
        String aux="";
        try {
            for(Artigos artigos : this.artigos){
                aux += "Código: "+ artigos.getCodigoAlfa().toString() + "\n";
            }
        }catch (NullPointerException e){
            System.out.println("Não tem artigos ;(");
        }

        return "\nEncomenda:\nArtigos:\n" +
                aux+
                "Número encomenda = " + numeroEncomenda +
                "\n dimensaoEmbalagem=" + dimensaoEmbalagem  +
                "\n precoFinal=" + precoFinal +
                "\n taxaSatisfacaoServicoNovo=" + taxaSatisfacaoServicoNovo +
                "\n taxaSatisfacaoServicoUsado=" + taxaSatisfacaoServicoUsado +
                "\n custosExpedicao=" + custosExpedicao +
                "\n estado=" + estado +
                "\n dataCriacao=" + dataCriacao +
                "\n prazoLimite=" + prazoLimite;
    }

}

