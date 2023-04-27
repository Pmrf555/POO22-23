package Controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Model.*;
import View.*;

public class Controller {

    public static void run() throws ClassNotFoundException, IOException, ParseException {
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
                case 9:
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
        System.out.println("Data:"+numeroUtilizadores);
        System.out.println("Data:"+estado);
        System.out.println("Data:"+descricao);
        System.out.println("Data:"+marca);
        System.out.println("Data:"+precoBase);
        System.out.println("Data:"+correcaoPreco);
        System.out.println("Data:"+dimensao);
        System.out.println("Data:"+atacadores);
        System.out.println("Data:"+cor);
        System.out.println("Data:"+data1);
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

    public static void adicionaEncomenda(IView view,IInput input,IGestor gestor) throws ParseException {
        view.mostraMensagem("Quantos artigos vai ter a encomenda?");
        Integer numeroArtigos = input.InputInteger();
        view.mostraMensagem("Agora insira os códigos alfanuméricos dos" +numeroArtigos+ " artigos:");
        List<Artigos> artigos = new ArrayList<Artigos>();
        for (int i = 0; i<numeroArtigos;i++){
            Long aux = input.InputLong();
            artigos.add(gestor.getArtigosMap().get(aux));
        }
        view.mostraMensagem("Insira a dimensão da embalagem:(String)");
        String dimensaoEmbalagem = input.InputString();
        view.mostraMensagem("Insira a taxa de satisfação de serviço novo:");
        Double satisfacaoServicoNovo = input.InputDouble();
        view.mostraMensagem("Insira a taxa de satisfação de serviço usado:");
        Double satisfacaoServicoUsado = input.InputDouble();
        view.mostraMensagem("Insira o estado:");
        String estado = input.InputString();
        view.mostraMensagem("Insira a data de criação:");
        String dataCriacao = input.InputString();
        view.mostraMensagem("Insira o prazo limite:");
        String prazoLimite = input.InputString();

        Date dataCriacao1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataCriacao);
        Date prazoLimite1 = new SimpleDateFormat("dd/MM/yyyy").parse(prazoLimite);

        Encomendas aux = new Encomendas(artigos,dimensaoEmbalagem,satisfacaoServicoNovo
                ,satisfacaoServicoUsado,0.0,estado,dataCriacao1,prazoLimite1);
        Double custoExpedicao = gestor.getTransportadoraMap().get(artigos.get(0).getNomeTransportadora()).precoExpedicao(aux);
        aux.setCustosExpedicao(custoExpedicao);

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

