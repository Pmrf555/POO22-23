public class Malas extends Artigos{
    private int dimensao;
    private String material;
    private int ano;

    public Malas(int numeroUtilizadores, Double estado, String descricao, String marca
            , int codigoAlfa, Double precoBase, Double correcaoPreco, Double desconto, int dimensao, String material, int ano) {
        super(numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, desconto);
        this.dimensao = dimensao;
        this.material = material;
        this.ano = ano;
    }

    public Malas(Artigos art, int dimensao, String material, int ano) {
        super(art);
        this.dimensao = dimensao;
        this.material = material;
        this.ano = ano;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
