package Model;

import java.util.Date;
import java.util.Map;

public interface IGestor {
    public Utilizador vendedorQueMaisFaturouSempre();
    public Utilizador vendedorQueMaisFaturouEntreDatas(Date inicio, Date fim);
    public Map<Long, Artigos> getArtigosMap();
    public Transportadora transportadoraComMaiorFaturacao();
    public Map<Integer, Utilizador> getUtilizadorMap();
    public Map<Integer, Encomendas> getEncomendasMap();
    public Map<String, Transportadora> getTransportadoraMap();
}
