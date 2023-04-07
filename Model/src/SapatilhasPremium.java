import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SapatilhasPremium extends Sapatilhas{ //nunca tem desconto mas aumenta o preço consoante os anos que ele tem

    public SapatilhasPremium(Artigos artigos,Sapatilhas sapatilhas){
        super(artigos,sapatilhas);
    }

    public double preco(){
        return super.getPrecoBase() + (10 * LocalDateTime.now().until(super.getDataLancamento(), ChronoUnit.YEARS)); // o 10 foi inventado não sei se é preciso um número especifico
    }
}
