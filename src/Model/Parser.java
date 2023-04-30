package Model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parser implements IParser{

    public void guardaBin(String nomeFicheiro,IGestor gestor) throws FileNotFoundException, IOException {
        FileOutputStream bf = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(bf);
        oos.writeObject(gestor);
        oos.flush();
        oos.close();
    }

    public IGestor readBin(String nomeFich) throws IOException,ClassNotFoundException{
        FileInputStream bf = new FileInputStream(nomeFich);
        ObjectInputStream ois = new ObjectInputStream(bf);
        IGestor m = (IGestor) ois.readObject();
        ois.close();
        return m;
    }

    private String nomeFicheiro;
                    //  LEITURA DO FICHEIRO PARA OS MAPAS \\
    public Parser(){
        this.nomeFicheiro = "ficheiroLeitura";
    }
    public void lerFicheiro(IGestor ges) throws IOException, ParseException {
        int estado = 0; // 0 se estiver a ler malasNormais,1 malasPremium,2 sapatilhasNormais,3 sapatilhasPremium,4 t-Shirts, 5 utilizadores, 6 encomendas e 7 trasportadoras
        int aux = 0;
        FileReader arq = new FileReader(nomeFicheiro);
        BufferedReader fileArq = new BufferedReader(arq);
        String linha;
        linha = fileArq.readLine();

        while (linha != null) {
            switch (linha) {
                case "Mala Normal":
                    MalasNormais malasNormais = lerMalaNormal(fileArq);
                    ges.getArtigosMap().put(malasNormais.getCodigoAlfa(), malasNormais);
                    break;
                case "Mala Premium":
                    MalasPremium malasPremium = lerMalaPremium(fileArq);
                    ges.getArtigosMap().put(malasPremium.getCodigoAlfa(), malasPremium);
                    break;
                case "Sapatilha Normal":
                    Sapatilhas sapatilhasNormais = lerSapatilhas(fileArq);
                    ges.getArtigosMap().put(sapatilhasNormais.getCodigoAlfa(), sapatilhasNormais);
                    break;
                case "Sapatilha Premium":
                    Sapatilhas sapatilhasPremium = lerSapatilhas(fileArq);
                    ges.getArtigosMap().put(sapatilhasPremium.getCodigoAlfa(), sapatilhasPremium);
                    break;
                case "T-Shirt":
                    TShirt tShirt = lerTShirt(fileArq);
                    ges.getArtigosMap().put(tShirt.getCodigoAlfa(), tShirt);
                    break;
                case "Utilizador":
                    Utilizador utilizador = lerUtilizador(ges,fileArq);
                    ges.getUtilizadorMap().put(utilizador.getCodigo(), utilizador);
                    break;
                case "Encomendas":
                    Encomendas encomendas = lerEncomendas(ges,fileArq);
                    ges.getEncomendasMap().put(Encomendas.getNumeroEnc(),encomendas);
                    break;
                case "Transportadoras":
                    Transportadora transportadora = lerTransportadoras(fileArq);
                    ges.getTransportadoraMap().put(transportadora.getNome(),transportadora);
                    break;
                default:
                    break;
            }
            linha = fileArq.readLine();
        }

        arq.close();
    }

    public Utilizador lerUtilizador(IGestor ges,BufferedReader fileArq) throws IOException, ParseException {
        int codigo = Integer.parseInt(fileArq.readLine());
        String email = fileArq.readLine();
        String nome = fileArq.readLine();
        String morada = fileArq.readLine();
        long nif = Long.parseLong(fileArq.readLine());

        ArrayList<Artigos> aux1 = new ArrayList<>();
        Map<Date,List<Artigos>> aux2 = new HashMap<>();
        Map<Date,List<Artigos>> aux3 = new HashMap<>();

        int numeroArtigosParaVenda = Integer.parseInt(fileArq.readLine());
        for(int i = 0;i<numeroArtigosParaVenda;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            aux1.add(ges.getArtigosMap().get(codAlfanumerico));
        }

        int numeroArtigosVendidos = Integer.parseInt(fileArq.readLine());
        for(int i = 0;i<numeroArtigosVendidos;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(fileArq.readLine());
            if(aux2.containsKey(data)){
                aux2.get(data).add(ges.getArtigosMap().get(codAlfanumerico));
            }
            else{
                List<Artigos> aux = new ArrayList<Artigos>();
                aux.add(ges.getArtigosMap().get(codAlfanumerico));
                aux2.put(data,aux);
            }
        }

        int numeroArtigosComprados = Integer.parseInt(fileArq.readLine());
        for(int i = 0;i<numeroArtigosComprados;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(fileArq.readLine());
            if(aux3.containsKey(data)){
                aux3.get(data).add(ges.getArtigosMap().get(codAlfanumerico));
            }
            else{
                List<Artigos> aux = new ArrayList<Artigos>();
                aux.add(ges.getArtigosMap().get(codAlfanumerico));
                aux3.put(data,aux);
            }
        }
        return new Utilizador(email,nome,morada,nif,aux1,aux2,aux3);
    }


    public Encomendas lerEncomendas(IGestor ges,BufferedReader fileArq) throws IOException, ParseException {
        int numeroArtigos = Integer.parseInt(fileArq.readLine());
        ArrayList<Artigos> aux = new ArrayList<>();
        for(int i = 0;i<numeroArtigos;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            aux.add(ges.getArtigosMap().get(codAlfanumerico));
        }
        String dimensaoEmbalagem = fileArq.readLine();
        Double custoExpedicao = Double.parseDouble(fileArq.readLine());
        String estado = fileArq.readLine();
        Date dataCriacao = new SimpleDateFormat("dd/MM/yyyy").parse(fileArq.readLine());
        Date prazoLimite = new SimpleDateFormat("dd/MM/yyyy").parse(fileArq.readLine());
        return new Encomendas(aux,dimensaoEmbalagem,custoExpedicao,estado,dataCriacao,prazoLimite);
    }

    public Transportadora lerTransportadoras(BufferedReader fileArq) throws IOException {
        String nome = fileArq.readLine();
        Double margemLucro = Double.parseDouble(fileArq.readLine());
        return new Transportadora(nome,margemLucro);
    }

    public TShirt lerTShirt(BufferedReader fileArq) throws IOException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        String tamanho = fileArq.readLine();
        String padrao = fileArq.readLine();
        return new TShirt(numeroUtilizadores,estado,descricao,marca,precobase,correcaoPreco,tamanho,padrao);
    }

    public MalasNormais lerMalaNormal(BufferedReader fileArq) throws IOException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        int dimensao = Integer.parseInt(fileArq.readLine());
        String material = fileArq.readLine();
        int ano = Integer.parseInt(fileArq.readLine());
        return new MalasNormais(numeroUtilizadores,estado,descricao,marca,precobase,correcaoPreco,dimensao,material,ano);
    }

    public MalasPremium lerMalaPremium(BufferedReader fileArq) throws IOException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        int dimensao = Integer.parseInt(fileArq.readLine());
        String material = fileArq.readLine();
        int ano = Integer.parseInt(fileArq.readLine());
        Double valorizacao = Double.parseDouble(fileArq.readLine());
        return new MalasPremium(numeroUtilizadores,estado,descricao,marca,precobase,correcaoPreco,dimensao,material,ano,valorizacao);
    }

    public Sapatilhas lerSapatilhas(BufferedReader fileArq) throws IOException, ParseException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        Double tamanho = Double.parseDouble(fileArq.readLine());
        Boolean atacadore = Boolean.parseBoolean(fileArq.readLine());
        String cor = fileArq.readLine();
        Date dataLancamento = new SimpleDateFormat("dd/MM/yyyy").parse(fileArq.readLine());
        return new SapatilhasNormais(numeroUtilizadores,estado,descricao,marca,precobase,correcaoPreco,tamanho,atacadore,cor,dataLancamento);
    }

}
