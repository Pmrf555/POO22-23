package Controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Model.*;
import View.*;

public class Controller {

    public static void run() throws ParseException, IOException, ClassNotFoundException {
        IView view = new View();
        IInput input = new Input();
        IGestor gestor = new Gestor();
        IParser p = new Parser();
/*
        try {
            p.lerFicheiro(gestor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/
        while (true) {
            view.mostrarMenuPrincipal();
            int escolha = input.InputInteger();
            switch (escolha) {
                case 1:
                    adicionaArtigo(view,input,gestor);
                    break;
                case 2:
                    adicionaTransportadora(view,input,gestor);
                    break;
                case 3:
                    adicionaEncomenda(view,input,gestor);
                    break;
                case 4:
                    adicionaUtilizador(view,input,gestor);
                    break;
                case 5:
                    showArtigos(view,input,gestor);
                    view.pressEnterToContinue(input);
                    break;
                case 6:
                    showTransportadora(view,input,gestor);
                    view.pressEnterToContinue(input);
                    break;
                case 7:
                    showEncomenda(view,input,gestor);
                    view.pressEnterToContinue(input);
                    break;
                case 8:
                    showUtilizador(view,input,gestor);
                    view.pressEnterToContinue(input);
                    break;
                case 9://simulação
                    iniciaSimulacao(view,input,gestor);
                    break;
                case 10:
                    view.mostraMensagem("Insira o nome do ficheiro: ");
                    String filePath2 = input.InputString();
                    p.guardaBin(filePath2, gestor);
                    view.mostraMensagem("Guardado em " + filePath2);
                    view.pressEnterToContinue(input);
                    break;
                case 11:
                    view.mostraMensagem("Insira o nome do ficheiro: ");
                    String filePath = input.InputString();
                    gestor = p.readBin(filePath);
                    view.mostraMensagem(
                            "Lidos " + gestor.getArtigosMap().values().size() + " artigos de [" + filePath + "]");
                    view.mostraMensagem(
                            "Lidos " + gestor.getUtilizadorMap().values().size() + " utilizadores de [" + filePath + "]");
                    view.mostraMensagem(
                            "Lidos " + gestor.getEncomendasMap().values().size() + " encomendas de [" + filePath + "]");
                    view.mostraMensagem(
                            "Lidos " + gestor.getTransportadoraMap().values().size() + " transportadoras de [" + filePath + "]");
                    view.pressEnterToContinue(input);
                    break;
                case 12:
                    input.closeScanner();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }



    public static void showArtigos(IView view,IInput input,IGestor gestor){
        for(Artigos artigos : gestor.getArtigosMap().values()){
            view.mostraMensagem(artigos.getClass().toString());
            view.mostraMensagem(artigos.toString());
        }
    }

    public static void showEncomenda(IView view,IInput input,IGestor gestor){
        for(Encomendas artigos : gestor.getEncomendasMap().values()){
            view.mostraMensagem("Encomenda:");
            view.mostraMensagem(artigos.toString());
        }
    }

    public static void showTransportadora(IView view,IInput input,IGestor gestor){
        for(Transportadora artigos : gestor.getTransportadoraMap().values()){
            view.mostraMensagem("Transportadora:");
            view.mostraMensagem(artigos.toString());
        }
    }

    public static void showUtilizador(IView view,IInput input,IGestor gestor){
        for(Utilizador artigos : gestor.getUtilizadorMap().values()){
            view.mostraMensagem("Utilizador:");
            view.mostraMensagem(artigos.toString());
        }
    }

    private static void iniciaSimulacao(IView view, IInput input, IGestor gestor) throws ParseException {
        view.mostrarMenuSimulacao();
        int escolha = input.InputInteger();
        switch (escolha){
            case 1:
                Utilizador aux = gestor.vendedorQueMaisFaturouSempre();
                view.mostraMensagem(aux.toString());
                view.pressEnterToContinue(input);
                iniciaSimulacao(view,input,gestor);
                break;
            case 2:
                vendedorQueMaisFaturouEntreDatas(view,input,gestor);
                view.pressEnterToContinue(input);
                iniciaSimulacao(view,input,gestor);
                break;
            case 3:
                Transportadora transportadora = gestor.transportadoraComMaiorFaturacao();
                view.mostraMensagem(transportadora.toString());
                view.pressEnterToContinue(input);
                iniciaSimulacao(view,input,gestor);
                break;
            case 4:
                encomendasEmitidasPorVendedor(view,input,gestor);
                view.pressEnterToContinue(input);
                iniciaSimulacao(view,input,gestor);
                break;
            case 5:
                maioresVendedoresPorData(view,input,gestor);
                view.pressEnterToContinue(input);
                iniciaSimulacao(view,input,gestor);
                break;
            case 6:
                maioresCompradoresPorData(view,input,gestor);
                view.pressEnterToContinue(input);
                iniciaSimulacao(view,input,gestor);
                break;
            case 7:
                Double lucroVintage = gestor.lucroVintage();
                view.mostraMensagem(lucroVintage.toString());
                view.pressEnterToContinue(input);
                iniciaSimulacao(view,input,gestor);
                break;

            case 8:
                return;
            default:
                view.mostraMensagem("Erro na escolha do artigo");
                view.pressEnterToContinue(input);
                break;
        }
    }

    private static void maioresVendedoresPorData(IView view, IInput input, IGestor gestor) throws ParseException {
        view.mostraMensagem("Insira a data de inicio:");
        Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
        view.mostraMensagem("Insira a data de fim:");
        Date data2 = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
        view.mostraMensagem("Insira a quantidade de utilizadores que quer no top:");
        Integer topX = input.InputInteger();
        List<Utilizador> aux = gestor.maioresVendedoresSistema(data1,data2,topX);

        try{
            for(Utilizador utilizador:aux){
                view.mostraMensagem(utilizador.toString());
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    private static void maioresCompradoresPorData(IView view, IInput input, IGestor gestor) throws ParseException {
        view.mostraMensagem("Insira a data de inicio:");
        Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
        view.mostraMensagem("Insira a data de fim:");
        Date data2 = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
        view.mostraMensagem("Insira a quantidade de utilizadores que quer no top:");
        Integer topX = input.InputInteger();
        List<Utilizador> aux = gestor.maioresCompradoresSistema(data1,data2,topX);
        try{
            for(Utilizador utilizador:aux){
                view.mostraMensagem(utilizador.toString());
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
    private static void encomendasEmitidasPorVendedor(IView view, IInput input, IGestor gestor) {
        view.mostraMensagem("Introduza o código do utilizador:");
        Integer codAlfa = input.InputInteger();
        List<Encomendas> aux = gestor.encomendasEmitidasPorVendedor(codAlfa);
        for(Encomendas encomendas:aux){
            view.mostraMensagem("Encomendas");
            view.mostraMensagem(encomendas.toString());
        }
    }

    private static void vendedorQueMaisFaturouEntreDatas(IView view, IInput input, IGestor gestor) throws ParseException {
        view.mostraMensagem("Insira a data de inicio:");
        Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
        view.mostraMensagem("Insira a data de fim:");
        Date data2 = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
        Utilizador aux = gestor.vendedorQueMaisFaturouEntreDatas(data1,data2);
        view.mostraMensagem(aux.toString());
    }

    public static void adicionaArtigo(IView view,IInput input,IGestor gestor) throws ParseException, NullPointerException {
        view.mostraMenuArtigos();
        int escolha = input.InputInteger();
        switch (escolha){
            case 1:
                adicionarSapatilhaNormal(view,input,gestor);
                break;
            case 2:
                adicionarSapatilhaPremium(view,input,gestor);
                break;
            case 3:
                adicionaMalaNormal(view,input,gestor);
                break;
            case 4:
                adicionaMalaPremium(view,input,gestor);
                break;
            case 5:
                adicionaTShirt(view,input,gestor);
                break;
            case 6:
                return;
            default:
                //view.mostraMensagem("Erro na escolha do artigo");
                //IView.pressEnterToContinue(input);
                input.closeScanner();
                System.exit(0);
                break;
        }
    }

    public static void adicionarSapatilhaNormal(IView view,IInput input,IGestor gestor) throws ParseException,NullPointerException {
        view.mostraMensagem("Insira o número de utilizadores:(inteiro)");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:(Double de 0 a 1 em que 0 é gasta e 1 é nova)");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:(String)");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:(String)");
        String marca = input.InputString();
        view.mostraMensagem("Insira preço base:(Double)");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço:(Double é um desconto)");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:(Double)");
        Double dimensao = input.InputDouble();
        view.mostraMensagem("0- Não tem atacadores:\n1- Tem atacadores");
        Boolean atacadores;
        if(input.InputInteger() == 0){
            atacadores = false;
        }else {
            atacadores = true;
        }
        view.mostraMensagem("Insira a cor:(String)");
        String cor = input.InputString();
        view.mostraMensagem("Insira a data de lançamento(formato dd/MM/yyy)");
        String data = input.InputString();

        Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);

        SapatilhasNormais aux = new SapatilhasNormais(numeroUtilizadores,estado,descricao,marca,precoBase,correcaoPreco
                ,dimensao,atacadores,cor,data1);
        gestor.getArtigosMap().put(aux.getCodigoAlfa(), aux);
    }

    public static void adicionarSapatilhaPremium(IView view,IInput input,IGestor gestor) throws ParseException {
        view.mostraMensagem("Insira o número de utilizadores:(inteiro)");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:(Double de 0 a 1 em que 0 é gasta e 1 é nova)");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:(String)");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:(String)");
        String marca = input.InputString();
        view.mostraMensagem("Insira preço base:(Double)");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço:(Double é um desconto)");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:(Double)");
        Double dimensao = input.InputDouble();
        view.mostraMensagem("0- Não tem atacadores:\n1- Tem atacadores");
        Boolean atacadores;
        if(input.InputInteger() == 0){
            atacadores = false;
        }else {
            atacadores = true;
        }
        view.mostraMensagem("Insira a cor:(String)");
        String cor = input.InputString();
        view.mostraMensagem("Insira a data de lançamento(formato dd/MM/yyy)");
        String data = input.InputString();

        Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);

        SapatilhasPremium aux = new SapatilhasPremium(numeroUtilizadores,estado,descricao,marca,precoBase,correcaoPreco
                ,dimensao,atacadores,cor,data1);
        gestor.getArtigosMap().put(aux.getCodigoAlfa(),aux);
    }
    // numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, desconto, dimensao, material, ano
    public static void adicionaMalaNormal(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:(inteiro)");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:(Double de 0 a 1 em que 0 é gasta e 1 é nova)");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:(String)");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:(String)");
        String marca = input.InputString();
        view.mostraMensagem("Insira preço base:(Double)");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço:(Double é um desconto)");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:(Inteiro)");
        Integer dimensao = input.InputInteger();
        view.mostraMensagem("Insira o tipo de material:(String)");
        String material = input.InputString();
        view.mostraMensagem("Insira o ano:(Inteiro)");
        Integer ano = input.InputInteger();
        MalasNormais aux = new MalasNormais(numeroUtilizadores,estado,descricao,marca,precoBase,correcaoPreco,dimensao,material,ano);
        gestor.getArtigosMap().put(aux.getCodigoAlfa(),aux);
    }

    public static void adicionaMalaPremium(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:(inteiro)");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:(Double de 0 a 1 em que 0 é gasta e 1 é nova)");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:(String)");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:(String)");
        String marca = input.InputString();
        view.mostraMensagem("Insira preço base:(Double)");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço:(Double é um desconto)");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:(Inteiro)");
        Integer dimensao = input.InputInteger();
        view.mostraMensagem("Insira o tipo de material:(String)");
        String material = input.InputString();
        view.mostraMensagem("Insira o ano:(Inteiro)");
        Integer ano = input.InputInteger();
        view.mostraMensagem("Insira a valorização:(Double)");
        Double valorizacao = input.InputDouble();
        MalasPremium aux = new MalasPremium(numeroUtilizadores,estado,descricao,marca,precoBase,correcaoPreco,dimensao
                ,material,ano,valorizacao);
        gestor.getArtigosMap().put(aux.getCodigoAlfa(),aux);
    }

    public static void adicionaTShirt(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:(inteiro)");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:(Double de 0 a 1 em que 0 é gasta e 1 é nova)");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:(String)");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:(String)");
        String marca = input.InputString();
        view.mostraMensagem("Insira preço base:(Double)");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço:(Double é um desconto)");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:(String)");
        String tamanho = input.InputString();
        view.mostraMensagem("Insira o padrão:(String)");
        String padrao = input.InputString();
        TShirt aux = new TShirt(numeroUtilizadores,estado,descricao,marca,precoBase,correcaoPreco,tamanho,padrao);
        gestor.getArtigosMap().put(aux.getCodigoAlfa(),aux);
    }

    public static void adicionaTransportadora(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o nome:");
        String nome = input.InputString();
        view.mostraMensagem("Insira a margem de lucro:");
        Double margemLucro = input.InputDouble();
        gestor.getTransportadoraMap().put(nome,new Transportadora(nome,margemLucro));
    }

    public static void adicionaEncomenda(IView view,IInput input,IGestor gestor) throws ParseException,NullPointerException {
        view.mostraMensagem("Quantos artigos vai ter a encomenda?");
        Integer numeroArtigos = input.InputInteger();
        view.mostraMensagem("Agora insira os códigos alfanuméricos dos " +numeroArtigos+ " artigos:");
        List<Artigos> artigos = new ArrayList<Artigos>();
        for (int i = 0; i<numeroArtigos;i++){
            Long aux = (long) input.InputInteger();
            try {
                artigos.add(gestor.getArtigosMap().get(aux));

            }catch (NullPointerException e){System.out.println("Não adicionei artigos :(");}
            }
        view.mostraMensagem("Insira a dimensão da embalagem:(String)");
        String dimensaoEmbalagem = input.InputString();
        view.mostraMensagem("Insira o estado:");
        String estado = input.InputString();
        view.mostraMensagem("Insira a data de criação:");
        String dataCriacao = input.InputString();
        view.mostraMensagem("Insira o prazo limite:");
        String prazoLimite = input.InputString();

        Date dataCriacao1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataCriacao);
        Date prazoLimite1 = new SimpleDateFormat("dd/MM/yyyy").parse(prazoLimite);

        Encomendas aux = new Encomendas(artigos,dimensaoEmbalagem,0.0,estado,dataCriacao1,prazoLimite1);
        try {
            Double custoExpedicao = gestor.getTransportadoraMap().get(artigos.get(0).getNomeTransportadora()).precoExpedicao(aux);
            aux.setCustosExpedicao(custoExpedicao);
        }catch (NullPointerException e){
            System.out.println("Custo de Expedição fica a 0");
        }

        gestor.getEncomendasMap().put(aux.getNumeroEncomenda(),aux);
    }

    public static void adicionaUtilizador(IView view,IInput input,IGestor gestor) throws ParseException {
        view.mostraMensagem("Insira o email:");
        String email = input.InputString();
        view.mostraMensagem("Insira o nome:");
        String nome = input.InputString();
        view.mostraMensagem("Insira Morada:");
        String morada = input.InputString();
        view.mostraMensagem("Insira o NIF:");
        int nif = input.InputInteger();

        view.mostraMensagem("Quantos artigos para venda vai ter o utilizador?");
        Integer numeroArtigosparaVenda = input.InputInteger();
        List<Artigos> artigosVenda = new ArrayList<Artigos>();
        for (int i = 0; i<numeroArtigosparaVenda;i++){
            view.mostraMensagem("Insira o código alfanumérico do artigo:");
            Long aux = input.InputLong();
            artigosVenda.add(gestor.getArtigosMap().get(aux));
        }

        Map<Date,List<Artigos>> aux2 = new HashMap<>();
        view.mostraMensagem("Quantos artigos vendidos vai ter o utilizador?");
        Integer numeroArtigosVendidos = input.InputInteger();
        for(int i = 0;i<numeroArtigosVendidos;i++){
            view.mostraMensagem("Insira o código alfanumérico do artigo:");
            Long codAlfanumerico = input.InputLong();
            view.mostraMensagem("Insira a data de venda do produto (formato dd/MM/yyyy):");
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
            if(aux2.containsKey(data)){
                aux2.get(data).add(gestor.getArtigosMap().get(codAlfanumerico));
            }
            else{
                List<Artigos> aux = new ArrayList<Artigos>();
                aux.add(gestor.getArtigosMap().get(codAlfanumerico));
                aux2.put(data,aux);
            }
        }

        Map<Date,List<Artigos>> aux3 = new HashMap<>();
        view.mostraMensagem("Quantos artigos comprados vai ter o utilizador?");
        Integer numeroArtigosComprados = input.InputInteger();
        for(int i = 0;i<numeroArtigosVendidos;i++){
            view.mostraMensagem("Insira o código alfanumérico do artigo:");
            Long codAlfanumerico = input.InputLong();
            view.mostraMensagem("Insira a data de compra do produto (formato dd/MM/yyyy):");
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
            if(aux2.containsKey(data)){
                aux2.get(data).add(gestor.getArtigosMap().get(codAlfanumerico));
            }
            else{
                List<Artigos> aux = new ArrayList<Artigos>();
                aux.add(gestor.getArtigosMap().get(codAlfanumerico));
                aux3.put(data,aux);
            }
        }
        Utilizador utilizador = new Utilizador(email,nome,morada,nif,artigosVenda,aux2,aux3);
        gestor.getUtilizadorMap().put(utilizador.getCodigoUser(),utilizador);
    }

}

