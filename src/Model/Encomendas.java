package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Encomendas{
    private static int numeroEnc;
    private ArrayList<Artigos> artigos;
    private String dimensaoEmbalagem;
    private double precoFinal;
    private double taxaSatisfacaoServicoNovo;
    private double taxaSatisfacaoServicoUsado;
    private double custosExpedicao;
    private String estado;
    private Date dataCriacao;
    private Date prazoLimite;

    public static int getNumeroEnc() {
        return numeroEnc;
    }

    public static void setNumeroEnc(int numeroEnc) {
        Encomendas.numeroEnc = numeroEnc;
    }

    public Encomendas(ArrayList<Artigos> artigos, String dimensaoEmbalagem, double precoFinal, double taxaSatisfacaoServicoNovo
            , double taxaSatisfacaoServicoUsado, double custosExpedicao, String estado, Date dataCriacao, Date prazoLimite) {
        this.artigos = artigos;
        this.dimensaoEmbalagem = dimensaoEmbalagem;
        this.precoFinal = precoFinal;
        this.taxaSatisfacaoServicoNovo = taxaSatisfacaoServicoNovo;
        this.taxaSatisfacaoServicoUsado = taxaSatisfacaoServicoUsado;
        this.custosExpedicao = custosExpedicao;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
        this.prazoLimite = prazoLimite;
    }

    // Construtor da classe Encomenda
    public Encomendas(String dimensaoEmbalagem, double taxaSatisfacaoServicoNovo, double taxaSatisfacaoServicoUsado, double custosExpedicao) {
        this.artigos = new ArrayList<>();
        this.dimensaoEmbalagem = dimensaoEmbalagem;
        this.precoFinal = 0;
        this.taxaSatisfacaoServicoNovo = taxaSatisfacaoServicoNovo;
        this.taxaSatisfacaoServicoUsado = taxaSatisfacaoServicoUsado;
        this.custosExpedicao = custosExpedicao;
        this.estado = "pendente";
        this.dataCriacao = new Date();
        this.prazoLimite = new Date(dataCriacao.getTime() + (1000 * 60 * 60 * 24 * 7)); // prazo de uma semana
        Encomendas.numeroEnc = getNumeroEnc();
        Encomendas.setNumeroEnc(getNumeroEnc()+1);
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
            if (artigo.getNumeroUtilizadores() == 0) { // ser 0 significa q o estado do artigo é novo ? penso que é necessario redefinir a varaivel estado na classe "artigos"
                precoFinal += taxaSatisfacaoServicoNovo;
            } else {
                precoFinal += taxaSatisfacaoServicoUsado;
            }
        }
        precoFinal += custosExpedicao;
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
    public ArrayList<Artigos> getArtigos() {
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

    public double getTaxaSatisfacaoServicoNovo() {
        return taxaSatisfacaoServicoNovo;
    }

    public void setTaxaSatisfacaoServicoNovo(double taxaSatisfacaoServicoNovo) {
        this.taxaSatisfacaoServicoNovo = taxaSatisfacaoServicoNovo;
        calcularPrecoFinal();
    }

    public double getTaxaSatisfacaoServicoUsado() {
        return taxaSatisfacaoServicoUsado;
    }

    public void setTaxaSatisfacaoServicoUsado(double taxaSatisfacaoServicoUsado) {
        this.taxaSatisfacaoServicoUsado = taxaSatisfacaoServicoUsado;
        calcularPrecoFinal();
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
        return "Encomendas{" +
                "artigos=" + artigos +
                ", dimensaoEmbalagem='" + dimensaoEmbalagem + '\'' +
                ", precoFinal=" + precoFinal +
                ", taxaSatisfacaoServicoNovo=" + taxaSatisfacaoServicoNovo +
                ", taxaSatisfacaoServicoUsado=" + taxaSatisfacaoServicoUsado +
                ", custosExpedicao=" + custosExpedicao +
                ", estado='" + estado + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", prazoLimite=" + prazoLimite +
                '}';
    }

}

