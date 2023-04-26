package Controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import Model.*;
import View.*;

public class Controller {

    public static void run() throws ClassNotFoundException, IOException, ParseException {
        IView view = new View();
        IInput input = new Input();
        IGestor gestor = new Gestor();
        IParser p = new Parser();

        try {
            p.lerFicheiro(gestor);
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
                    input.closeScanner();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void adicionaArtigo(IView view,IInput input,IGestor gestor){
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

    public static void adicionarSapatilhaNormal(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:");
        String marca = input.InputString();
        view.mostraMensagem("Insira código alfanumérico:");
        Long codAlfa = input.InputLong();
        view.mostraMensagem("Insira preço base:");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:");
        Double dimensao = input.InputDouble();
        view.mostraMensagem("0- Não tem atacadores:\n1-Tem atacadores");
        Boolean atacadores;
        if(input.InputInteger() == 0){
            atacadores = false;
        }else {
            atacadores = true;
        }
        view.mostraMensagem("Insira a cor:");
        String cor = input.InputString();
        view.mostraMensagem("Insira a data de lançamento(formato dd/MM/yyy)");
        String data = input.InputString();
        LocalDateTime data1 = LocalDateTime.parse(data);
        gestor.getArtigosMap().put(codAlfa,new SapatilhasNormais(numeroUtilizadores,estado,descricao,marca,codAlfa,precoBase,correcaoPreco,dimensao,atacadores,cor,data1));
    }

    public static void adicionarSapatilhaPremium(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:");
        String marca = input.InputString();
        view.mostraMensagem("Insira código alfanumérico:");
        Long codAlfa = input.InputLong();
        view.mostraMensagem("Insira preço base:");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:");
        Double dimensao = input.InputDouble();
        view.mostraMensagem("0- Não tem atacadores:\n1-Tem atacadores");
        Boolean atacadores;
        if(input.InputInteger() == 0){
            atacadores = false;
        }else {
            atacadores = true;
        }
        view.mostraMensagem("Insira a cor:");
        String cor = input.InputString();
        view.mostraMensagem("Insira a data de lançamento(formato dd/MM/yyy)");
        String data = input.InputString();
        LocalDateTime data1 = LocalDateTime.parse(data);
        gestor.getArtigosMap().put(codAlfa,new SapatilhasNormais(numeroUtilizadores,estado,descricao,marca,codAlfa,precoBase,correcaoPreco,dimensao,atacadores,cor,data1));
    }
    // numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, desconto, dimensao, material, ano
    public static void adicionaMalaNormal(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:");
        String marca = input.InputString();
        view.mostraMensagem("Insira código alfanumérico:");
        Long codAlfa = input.InputLong();
        view.mostraMensagem("Insira preço base:");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:");
        Integer dimensao = input.InputInteger();
        view.mostraMensagem("Insira o tipo de material:");
        String material = input.InputString();
        view.mostraMensagem("Insira o ano:");
        Integer ano = input.InputInteger();
        gestor.getArtigosMap().put(codAlfa,new MalasNormais(numeroUtilizadores,estado,descricao,marca,codAlfa,precoBase,correcaoPreco,dimensao,material,ano));
    }

    public static void adicionaMalaPremium(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:");
        String marca = input.InputString();
        view.mostraMensagem("Insira código alfanumérico:");
        Long codAlfa = input.InputLong();
        view.mostraMensagem("Insira preço base:");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:");
        Integer dimensao = input.InputInteger();
        view.mostraMensagem("Insira o tipo de material:");
        String material = input.InputString();
        view.mostraMensagem("Insira o ano:");
        Integer ano = input.InputInteger();
        view.mostraMensagem("Insira a valorização:");
        Double valorizacao = input.InputDouble();
        gestor.getArtigosMap().put(codAlfa,new MalasPremium(numeroUtilizadores,estado,descricao,marca,codAlfa,precoBase,correcaoPreco,dimensao,material,ano,valorizacao));
    }

    public static void adicionaTShirt(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o número de utilizadores:");
        Integer numeroUtilizadores = input.InputInteger();
        view.mostraMensagem("Insira estado:");
        Double estado = input.InputDouble();
        view.mostraMensagem("Insira uma descrição:");
        String descricao = input.InputString();
        view.mostraMensagem("Insira o nome da marca:");
        String marca = input.InputString();
        view.mostraMensagem("Insira código alfanumérico:");
        Long codAlfa = input.InputLong();
        view.mostraMensagem("Insira preço base:");
        Double precoBase = input.InputDouble();
        view.mostraMensagem("Insira correção do preço");
        Double correcaoPreco = input.InputDouble();
        view.mostraMensagem("Insira o tamanho:");
        String tamanho = input.InputString();
        view.mostraMensagem("Insira o padrão:");
        String padrao = input.InputString();
        gestor.getArtigosMap().put(codAlfa,new TShirt(numeroUtilizadores,estado,descricao,marca,codAlfa,precoBase,correcaoPreco,tamanho,padrao));
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
        List<Artigos> codAlfa = new ArrayList<Artigos>();
        for (int i = 0; i<numeroArtigos;i++){
            Long aux = input.InputLong();
            codAlfa.add(gestor.getArtigosMap().get(aux));
        }
        view.mostraMensagem("Insira a dimensão da embalagem:");
        String dimensaoEmbalagem = input.InputString();
        view.mostraMensagem("Insira o preco final:");
        Double precoFinal = input.InputDouble(); // preço final tem de ser calculado e não perguntado ao user
        view.mostraMensagem("Insira a taxa de satisfação de serviço novo:");
        Double satisfacaoServicoNovo = input.InputDouble();
        view.mostraMensagem("Insira a taxa de satisfação de serviço usado:");
        Double satisfacaoServicoUsado = input.InputDouble();
        view.mostraMensagem("Insirao custoExpedicao:"); // deve ser calculada por nós também
        Double custoExpedicao = input.InputDouble();
        view.mostraMensagem("Insira o estado:");
        String estado = input.InputString();
        view.mostraMensagem("Insira a data de criação:");
        String dataCriacao = input.InputString();
        view.mostraMensagem("Insira o prazo limite:");
        String prazoLimite = input.InputString();
        Date dataCriacao1,prazoLimite1;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dataCriacao1 = formatter.parse(dataCriacao);
        prazoLimite1 = formatter.parse(prazoLimite);
    }

    public static void adicionaUtilizador(IView view,IInput input,IGestor gestor){

    }

}

