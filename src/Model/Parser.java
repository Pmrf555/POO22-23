package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Parser implements IParser{
                    //  LEITURA DO FICHEIRO PARA OS MAPAS \\

    public void lerFicheiro(Gestor ges,String nomeFicheiro) throws IOException {
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
                    System.out.println("Linha inválida");
                    break;
            }
            linha = fileArq.readLine();
        }

        arq.close();
    }

    public Utilizador lerUtilizador(Gestor ges,BufferedReader fileArq) throws IOException {
        int codigo = Integer.parseInt(fileArq.readLine());
        String email = fileArq.readLine();
        String nome = fileArq.readLine();
        String morada = fileArq.readLine();
        int nif = Integer.parseInt(fileArq.readLine());

        ArrayList<Artigos> aux1 = new ArrayList<>();
        ArrayList<Artigos> aux2 = new ArrayList<>();
        ArrayList<Artigos> aux3 = new ArrayList<>();

        int numeroArtigosParaVenda = Integer.parseInt(fileArq.readLine());
        for(int i = 0;i<numeroArtigosParaVenda;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            aux1.add(ges.getArtigosMap().get(codAlfanumerico));
        }

        int numeroArtigosVendidos = Integer.parseInt(fileArq.readLine());
        for(int i = 0;i<numeroArtigosVendidos;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            aux2.add(ges.getArtigosMap().get(codAlfanumerico));
        }

        int numeroArtigosComprados = Integer.parseInt(fileArq.readLine());
        for(int i = 0;i<numeroArtigosComprados;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            aux3.add(ges.getArtigosMap().get(codAlfanumerico));
        }

        Double totalVendido = Double.parseDouble(fileArq.readLine());
        return new Utilizador(codigo,email,nome,morada,nif,aux1,aux2,aux3,totalVendido);
    }


    public Encomendas lerEncomendas(Gestor ges,BufferedReader fileArq) throws IOException {
        int numeroArtigos = Integer.parseInt(fileArq.readLine());
        ArrayList<Artigos> aux = new ArrayList<>();
        for(int i = 0;i<numeroArtigos;i++){
            Long codAlfanumerico = Long.parseLong(fileArq.readLine());
            aux.add(ges.getArtigosMap().get(codAlfanumerico));
        }
        String dimensaoEmbalagem = fileArq.readLine();
        Double precoFinal = Double.parseDouble(fileArq.readLine());
        Double taxaSatisfacaoServicoNovo = Double.parseDouble(fileArq.readLine());
        Double taxaSatisfacaoServicoUsado = Double.parseDouble(fileArq.readLine());
        Double custoExpedicao = Double.parseDouble(fileArq.readLine());
        String estado = fileArq.readLine();
        Date dataCriacao = new Date(fileArq.readLine());
        Date prazoLimite = new Date(fileArq.readLine());
        return new Encomendas(aux,dimensaoEmbalagem,precoFinal,taxaSatisfacaoServicoNovo,taxaSatisfacaoServicoUsado,custoExpedicao,estado,dataCriacao,prazoLimite);
    }

    public Transportadora lerTransportadoras(BufferedReader fileArq) throws IOException {
        String nome = fileArq.readLine();
        Double precoBasePequena = Double.parseDouble(fileArq.readLine());
        Double precoBaseMedia = Double.parseDouble(fileArq.readLine());
        Double precoBaseGrande = Double.parseDouble(fileArq.readLine());
        Double imposto = Double.parseDouble(fileArq.readLine());
        Boolean premium = Boolean.parseBoolean(fileArq.readLine());
        return new Transportadora(nome,precoBasePequena,precoBaseMedia,precoBaseGrande,imposto,premium);
    }



    public TShirt lerTShirt(BufferedReader fileArq) throws IOException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Long codAlfa = Long.parseLong(fileArq.readLine());
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        String tamanho = fileArq.readLine();
        String padrao = fileArq.readLine();
        Double desconto = Double.parseDouble(fileArq.readLine());
        return new TShirt(numeroUtilizadores,estado,descricao,marca,codAlfa,precobase,correcaoPreco,tamanho,padrao,desconto);
    }

    public MalasNormais lerMalaNormal(BufferedReader fileArq) throws IOException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Long codAlfa = Long.parseLong(fileArq.readLine());
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        Double desconto = Double.parseDouble(fileArq.readLine());
        int dimensao = Integer.parseInt(fileArq.readLine());
        String material = fileArq.readLine();
        int ano = Integer.parseInt(fileArq.readLine());
        return new MalasNormais(numeroUtilizadores,estado,descricao,marca,codAlfa,precobase,correcaoPreco,desconto,dimensao,material,ano);
    }

    public MalasPremium lerMalaPremium(BufferedReader fileArq) throws IOException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Long codAlfa = Long.parseLong(fileArq.readLine());
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        Double desconto = Double.parseDouble(fileArq.readLine());
        int dimensao = Integer.parseInt(fileArq.readLine());
        String material = fileArq.readLine();
        int ano = Integer.parseInt(fileArq.readLine());
        Double valorizacao = Double.parseDouble(fileArq.readLine());
        return new MalasPremium(numeroUtilizadores,estado,descricao,marca,codAlfa,precobase,correcaoPreco,desconto,dimensao,material,ano,valorizacao);
    }

    public Sapatilhas lerSapatilhas(BufferedReader fileArq) throws IOException {
        int numeroUtilizadores = Integer.parseInt(fileArq.readLine());
        Double estado = Double.parseDouble(fileArq.readLine());
        String descricao = fileArq.readLine();
        String marca = fileArq.readLine();
        Long codAlfa = Long.parseLong(fileArq.readLine());
        Double precobase = Double.parseDouble(fileArq.readLine());
        Double correcaoPreco = Double.parseDouble(fileArq.readLine());
        Double tamanho = Double.parseDouble(fileArq.readLine());
        Boolean atacadore = Boolean.parseBoolean(fileArq.readLine());
        String cor = fileArq.readLine();
        LocalDateTime dataLancamento = LocalDateTime.parse(fileArq.readLine());
        Double desconto = Double.parseDouble(fileArq.readLine());
        return new SapatilhasNormais(numeroUtilizadores,estado,descricao,marca,codAlfa,precobase,correcaoPreco,tamanho,atacadore,cor,dataLancamento,desconto);
    }

}
