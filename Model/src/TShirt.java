public class TShirt extends Artigos{
    private String tamanho;
    private String padrao; // se padrão for diferente de liso tem 50% desconto

    public TShirt(int numeroUtilizadores, Double estado, String descricao
            , String marca, int codigoAlfa, Double precoBase, Double correcaoPreco, String tamanho, String padrao,Double desconto) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco,desconto);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(Artigos art, String tamanho, String padrao) {
        super(art);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public void desconto(){
        if(!this.padrao.equals("liso")) setDesconto(50.0);
        else setDesconto(0.0);
    }

    public Double preco(){
        return getPrecoBase() * (getDesconto() / 100);
    }
}
