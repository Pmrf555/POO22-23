package Model;

public abstract class Malas extends Artigos{
    private int dimensao;
    private String material;
    private int ano;

    /*
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Malas malas = (Malas) o;
        return dimensao == malas.getDimensao() && ano == malas.getAno() && material.equals(malas.getMaterial());
    }*/


    public Malas(int numeroUtilizadores, Double estado, String descricao, String marca
            , Double precoBase, Double correcaoPreco, int dimensao, String material, int ano) {
        super(numeroUtilizadores, estado, descricao, marca, precoBase, correcaoPreco);
        this.dimensao = dimensao;
        this.material = material;
        this.ano = ano;
    }

    public Malas() {
        super();
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
