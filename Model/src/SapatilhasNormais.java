import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SapatilhasNormais extends Sapatilhas{
    public SapatilhasNormais(Artigos artigos,Sapatilhas sapatilhas){
        super(artigos,sapatilhas);
    }

    public Double preco(){
        return getPrecoBase() + (getPrecoBase() / getNumeroUtilizadores() * getEstado()) * (getDesconto() / 100);
    }

    public void desconto(Double desconto){
        if(getDataLancamento().getYear() != LocalDateTime.now().getYear() || getTamanho() > 45) setDesconto(desconto);
        else setDesconto(1.0);
    }
}
