package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IGestor extends Serializable {
    public Utilizador vendedorQueMaisFaturouSempre();
    public double lucroVintage();
    public List<Utilizador> maioresVendedoresSistema(Date inicio,Date fim, int quantosNoTop);
    public List<Utilizador> maioresCompradoresSistema(Date inicio,Date fim, int quantosNoTop);
    public List<Encomendas> encomendasEmitidasPorVendedor(Integer codUtilizador);
    public Utilizador vendedorQueMaisFaturouEntreDatas(Date inicio, Date fim);
    public Map<Integer, Artigos> getArtigosMap();
    public Transportadora transportadoraComMaiorFaturacao();
    public Map<Integer, Utilizador> getUtilizadorMap();
    public Map<Integer, Encomendas> getEncomendasMap();
    public Map<String, Transportadora> getTransportadoraMap();
}
