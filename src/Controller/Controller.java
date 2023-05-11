package Controller;

import Model.*;
import View.IView;
import View.View;
import jdk.jshell.execution.Util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller {

    public static void run() throws ParseException, IOException, ClassNotFoundException {
        IView view = new View();
        IInput input = new Input();
        IGestor gestor = new Gestor();
        IParser p = new Parser();

        try {
            p.lerFicheiro(gestor);
        } catch (ParseException e) {
            System.out.println("Erro ao ler ficheiro");
        }

        while (true) {
            view.mostrarMenuPrincipal();
            int escolha = input.InputInteger();
            switch (escolha) {
                case 1:
                    entrarUser(view,input,gestor);
                    break;
                case 2:
                    entrarAdmin(view,input,gestor);
                    break;
                case 3:
                    input.closeScanner();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void entrarAdmin(IView view, IInput input, IGestor gestor) throws ParseException, IOException, ClassNotFoundException {
        view.mostraMenuPrincipalAdmin();
        IParser p = new Parser();
        int escolha = input.InputInteger();
        switch (escolha){
            case 1:
                adicionaTransportadora(view,input,gestor);
                entrarAdmin(view,input,gestor);
                break;
            case 2:
                showArtigos(view,input,gestor);
                entrarAdmin(view,input,gestor);
                break;
            case 3:
                showTransportadora(view,input,gestor);
                entrarAdmin(view,input,gestor);
                break;
            case 4:
                showEncomenda(view,input,gestor);
                entrarAdmin(view,input,gestor);
                break;
            case 5:
                showUtilizador(view,input,gestor);
                entrarAdmin(view,input,gestor);
                break;
            case 6:
                iniciaSimulacao(view,input,gestor);
                entrarAdmin(view,input,gestor);
                break;
            case 7:
                avancarTempo(view,input,gestor);
                entrarAdmin(view,input,gestor);
                break;
            case 8:
                view.mostraMensagem("Insira o nome do ficheiro: ");
                String filePath2 = input.InputString();
                p.guardaBin(filePath2, gestor);
                view.mostraMensagem("Guardado em " + filePath2);
                view.pressEnterToContinue(input);
                entrarAdmin(view,input,gestor);
                break;
            case 9:
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
                entrarAdmin(view,input,gestor);
                break;
            case 10:
                return;
            case 11:
                input.closeScanner();
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private static void avancarTempo(IView view,IInput input,IGestor gestor) throws ParseException {
        view.mostraMensagem("Insira a data para qual pretende avançar:(formato dd/MM/yyyy)");
        Date data2 = new SimpleDateFormat("dd/MM/yyyy").parse(input.InputString());
        gestor.setDataAtual(data2);
        for(Encomendas encomendas: gestor.getEncomendasMap().values()){
            List<Artigos> artigosEncomenda = encomendas.getArtigos();
            if(encomendas.getPrazoLimite().before(data2)){
                encomendas.setEstado("Entregue");
                Utilizador user = encomendas.getFezEncomenda();

                //adiciona aos artigos comprados do utilizador logado
                try {
                    if(user.getArtigosComprados().containsKey(data2)){
                        user.getArtigosComprados().get(data2).addAll(artigosEncomenda);
                    }else {
                        user.getArtigosComprados().put(data2,artigosEncomenda);
                    }
                }catch (Exception e){System.out.println("Erro ao adicionar artigos comprados no utilizador");}


                //alterar os utilizadores que estavam associados a estes artigos
                for (Artigos artigos1: artigosEncomenda){
                    Utilizador userAux = gestor.getUtilizadorMap().values().stream().filter(e->e.getArtigosParaVenda().contains(artigos1)).toList().get(0);

                    userAux.getArtigosParaVenda().remove(artigos1);
                    if(userAux.getArtigosVendidos().containsKey(data2)){
                        userAux.getArtigosVendidos().get(data2).add(artigos1);
                    }else {
                        List<Artigos> aux11 = new ArrayList<>();
                        aux11.add(artigos1);
                        userAux.getArtigosVendidos().put(data2,aux11);
                    }

                    userAux.setTotalVendido(userAux.calculaTotalVendido());
                }
            }
        }

    }

    private static void entrarUser(IView view, IInput input, IGestor gestor) throws ParseException, IOException, ClassNotFoundException {
        view.mostrarMenuUser();
        Utilizador user = new Utilizador();
        int escolha = input.InputInteger();
        switch (escolha){
            case 1:
                view.mostraMensagem("Introduza E-Mail");
                String email = input.InputString();
                try {
                    user = gestor.getUtilizadorMap().values().stream().filter(e->e.getEmail().equals(email)).toList().get(0);
                    mostraUser(user,view,input,gestor);
                } catch (IndexOutOfBoundsException e ){
                    System.out.println("Erro no email introduzido");
                }

                break;
            case 2:
                adicionaUtilizador(view,input,gestor);
                break;
            case 3:
                input.closeScanner();
                System.exit(0);
                break;
            default:
                break;
        }

    }

    private static void mostraUser(Utilizador user, IView view, IInput input, IGestor gestor) throws ParseException, IOException, ClassNotFoundException {
        view.mostraMenuPrincipalUser();
        IParser p = new Parser();
        int escolha = input.InputInteger();
        switch (escolha){
            case 1:
                adicionaArtigo(user,view,input,gestor);
                mostraUser(user,view,input,gestor);
                break;
            case 2:
                adicionaEncomenda(user,view,input,gestor);
                mostraUser(user,view,input,gestor);
                break;
            case 3:
                showArtigos(view,input,gestor);
                mostraUser(user,view,input,gestor);
                break;
            case 4:
                showTransportadora(view,input,gestor);
                mostraUser(user,view,input,gestor);
                break;
            case 5:
                showEncomenda(view,input,gestor);
                mostraUser(user,view,input,gestor);
                break;
            case 6:
                showUtilizador(view,input,gestor);
                mostraUser(user,view,input,gestor);
                break;
            case 7:
                iniciaSimulacao(view,input,gestor);
                mostraUser(user,view,input,gestor);
                break;

            case 8:
                view.mostraMensagem("Insira o nome do ficheiro: ");
                String filePath2 = input.InputString();
                p.guardaBin(filePath2, gestor);
                view.mostraMensagem("Guardado em " + filePath2);
                view.pressEnterToContinue(input);
                mostraUser(user,view,input,gestor);
                break;
            case 9:
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
                mostraUser(user,view,input,gestor);
                break;
            case 10:
                return;
            case 11:
                input.closeScanner();
                System.exit(0);
                break;
            case 12:
                avancarTempo(view,input,gestor);
                mostraUser(user,view,input,gestor);
            default:
                break;
        }
    }

    public static void showArtigos(IView view,IInput input,IGestor gestor){
        for(Artigos artigos : gestor.getArtigosMap().values()){
            view.mostraMensagem(artigos.toString());
        }
    }

    public static void showEncomenda(IView view,IInput input,IGestor gestor){
        for(Encomendas artigos : gestor.getEncomendasMap().values()){
            view.mostraMensagem(artigos.toString());
        }
    }

    public static void showTransportadora(IView view,IInput input,IGestor gestor){
        for(Transportadora artigos : gestor.getTransportadoraMap().values()){
            view.mostraMensagem(artigos.toString());
        }
    }

    public static void showUtilizador(IView view,IInput input,IGestor gestor){
        for(Utilizador artigos : gestor.getUtilizadorMap().values()){
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
            int i= 1;
            for(Utilizador utilizador:aux){
                view.mostraMensagem(i +"º lugar:");
                view.mostraMensagem("Código User "+utilizador.getCodigoUser()+"\n");
                view.mostraMensagem("Total Vendido  "+utilizador.calculaValorartigosVendidosEntreDatas(data1,data2)+"\n");
                i++;
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
            int i= 1;
            for(Utilizador utilizador:aux){
                view.mostraMensagem(i +"º lugar:");
                view.mostraMensagem("Código User "+utilizador.getCodigoUser()+"\n");
                view.mostraMensagem("Total Comprado  "+utilizador.calculaValorartigosCompradosEntreDatas(data1,data2)+"\n");
                i++;
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }
    private static void encomendasEmitidasPorVendedor(IView view, IInput input, IGestor gestor) {
        view.mostraMensagem("Introduza o código do utilizador:");
        Integer codAlfa = input.InputInteger();
        List<Encomendas> aux = gestor.encomendasEmitidasPorVendedor(codAlfa);
        view.mostraMensagem("Encomendas");
        for(Encomendas encomendas:aux){
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

    public static void adicionaArtigo(Utilizador user,IView view,IInput input,IGestor gestor) throws ParseException, NullPointerException {
        view.mostraMenuArtigos();
        int escolha = input.InputInteger();
        switch (escolha){
            case 1:
                adicionarSapatilhaNormal(user,view,input,gestor);
                break;
            case 2:
                adicionarSapatilhaPremium(user,view,input,gestor);
                break;
            case 3:
                adicionaMalaNormal(user,view,input,gestor);
                break;
            case 4:
                adicionaMalaPremium(user,view,input,gestor);
                break;
            case 5:
                adicionaTShirt(user,view,input,gestor);
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

    public static void adicionarSapatilhaNormal(Utilizador user,IView view,IInput input,IGestor gestor) throws ParseException,NullPointerException {
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
        user.getArtigosParaVenda().add(aux);
    }

    public static void adicionarSapatilhaPremium(Utilizador user,IView view,IInput input,IGestor gestor) throws ParseException {
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
        user.getArtigosParaVenda().add(aux);
    }
    // numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, desconto, dimensao, material, ano
    public static void adicionaMalaNormal(Utilizador user,IView view,IInput input,IGestor gestor){
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
        user.getArtigosParaVenda().add(aux);
    }

    public static void adicionaMalaPremium(Utilizador user,IView view,IInput input,IGestor gestor){
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
        user.getArtigosParaVenda().add(aux);
    }

    public static void adicionaTShirt(Utilizador user,IView view,IInput input,IGestor gestor){
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
        user.getArtigosParaVenda().add(aux);
    }

    public static void adicionaTransportadora(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("1-É Premium\n2-É normal");
        Integer i = input.InputInteger();
        view.mostraMensagem("Insira o nome:");
        String nome = input.InputString();
        view.mostraMensagem("Insira a margem de lucro:");
        Double margemLucro = input.InputDouble();
        if(i == 1){
            gestor.getTransportadoraMap().put(nome,new TransportadoraPremium(nome,margemLucro));
        }else {
            gestor.getTransportadoraMap().put(nome,new TransportadoraNormal(nome,margemLucro));
        }

    }

    public static void adicionaEncomenda(Utilizador user,IView view,IInput input,IGestor gestor) throws ParseException,NullPointerException {
        view.mostraMensagem("Quer usar uma transportadora Premium?(Só pode transportar produtos premium)");
        view.mostraMensagem("1-Sim");
        view.mostraMensagem("2-Não");
        Integer premium = input.InputInteger();
        view.mostraMensagem("Quantos artigos vai ter a encomenda?");
        Integer numeroArtigos = input.InputInteger();
        view.mostraMensagem("Agora insira os códigos alfanuméricos dos " +numeroArtigos+ " artigos:");
        List<Artigos> artigos = new ArrayList<Artigos>();
        if(premium == 1){
            for (int i = 0; i<numeroArtigos;i++){
                Integer aux = input.InputInteger();
                if(gestor.getArtigosMap().get(aux) instanceof ProdutosPremium){
                    artigos.add(gestor.getArtigosMap().get(aux));
                }else{
                    i--;
                    view.mostraMensagem("Este Artigos não é premium, introduza o código denovo.");
                }
            }
        }else {
            for (int i = 0; i<numeroArtigos;i++){
                Integer aux = input.InputInteger();
                artigos.add(gestor.getArtigosMap().get(aux));
            }
        }



        view.mostraMensagem("Insira o nome da transportadora:");
        String nomeTransportadora = input.InputString();
        if(premium == 1){
            while(!(gestor.getTransportadoraMap().get(nomeTransportadora) instanceof TransportadoraPremium)){
                view.mostraMensagem("Esta Transportadora não é premium, introduza uma premium.");
                nomeTransportadora = input.InputString();
            }
        }


        for (Artigos artigo : artigos) {
            artigo.setNomeTransportadora(nomeTransportadora);
        }

        view.mostraMensagem("Insira o prazo limite:");
        String prazoLimite = input.InputString();
        Date prazoLimite1 = new SimpleDateFormat("dd/MM/yyyy").parse(prazoLimite);

        String dimensaoEmbalagem = "";
        if(artigos.size()<3) {
            dimensaoEmbalagem = "pequena";
        } else if (artigos.size() <= 5) {
            dimensaoEmbalagem = "media";
        }else {
            dimensaoEmbalagem = "grande";
        }
        Date dataCriacao = new Date();
        String estado = "pendente";

        Encomendas aux = new Encomendas(artigos,dimensaoEmbalagem,0.0,estado,dataCriacao,prazoLimite1);
        aux.setFezEncomenda(user);

        try {
            Double custoExpedicao = gestor.getTransportadoraMap().get(nomeTransportadora).precoExpedicao(aux);
            aux.setCustosExpedicao(custoExpedicao);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        gestor.getEncomendasMap().put(aux.getNumeroEncomenda(),aux);

    }

    public static void adicionaUtilizador(IView view,IInput input,IGestor gestor) throws ParseException, IOException, ClassNotFoundException {
        view.mostraMensagem("Insira o email:");
        String email = input.InputString();
        view.mostraMensagem("Insira o nome:");
        String nome = input.InputString();
        view.mostraMensagem("Insira Morada:");
        String morada = input.InputString();
        view.mostraMensagem("Insira o NIF:");
        int nif = input.InputInteger();
/*
        view.mostraMensagem("Quantos artigos para venda vai ter o utilizador?");
        Integer numeroArtigosparaVenda = input.InputInteger();
        List<Artigos> artigosVenda = new ArrayList<Artigos>();
        for (int i = 0; i<numeroArtigosparaVenda;i++){
            view.mostraMensagem("Insira o código alfanumérico do artigo:");
            Integer aux = input.InputInteger();
            artigosVenda.add(gestor.getArtigosMap().get(aux));
        }

        Map<Date,List<Artigos>> aux2 = new HashMap<>();
        view.mostraMensagem("Quantos artigos vendidos vai ter o utilizador?");
        Integer numeroArtigosVendidos = input.InputInteger();
        for(int i = 0;i<numeroArtigosVendidos;i++){
            view.mostraMensagem("Insira o código alfanumérico do artigo:");
            Integer codAlfanumerico = input.InputInteger();
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
        for(int i = 0;i<numeroArtigosComprados;i++){
            view.mostraMensagem("Insira o código alfanumérico do artigo:");
            Integer codAlfanumerico = input.InputInteger();
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
        }*/
        Utilizador utilizador = new Utilizador(email,nome,morada,nif);
        gestor.getUtilizadorMap().put(utilizador.getCodigoUser(),utilizador);
        mostraUser(utilizador,view,input,gestor);
    }

}

