package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public interface IGestor extends Serializable {
    public Utilizador vendedorQueMaisFaturouSempre();
    public Utilizador vendedorQueMaisFaturouEntreDatas(Date inicio, Date fim);
    public Map<Long, Artigos> getArtigosMap();
    public Transportadora transportadoraComMaiorFaturacao();
    public Map<Integer, Utilizador> getUtilizadorMap();
    public Map<Integer, Encomendas> getEncomendasMap();
    public Map<String, Transportadora> getTransportadoraMap();
}
