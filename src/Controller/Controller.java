package Controller;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;

import Model.*;
import View.*;

public class Controller {

    public static void run() throws ClassNotFoundException, IOException {
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
                adicionaSapatilha(view,input,gestor);
                break;
            case 2:
                adicionaSapatilha(view,input,gestor);
                break;
            case 3:
                adicionaMala(view,input,gestor);
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
                view.mostraMensagem("Erro na escolha do artigo");
                IView.pressEnterToContinue(input);
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

    public static void adicionaSapatilha(IView view,IInput input,IGestor gestor){

    }
    // numeroUtilizadores, estado, descricao, marca, codigoAlfa, precoBase, correcaoPreco, desconto, dimensao, material, ano
    public static void adicionaMala(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira a dimensão do produto:");
        Integer dimensao = input.InputInteger();
        view.mostraMensagem("Insira o tipo de material:");
        String material = input.InputString();
        view.mostraMensagem("Insira o ano:");
        Integer ano = input.InputInteger();
    }

    public static void adicionaMalaPremium(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira a valorização da mala:");
        Double valorizacao = input.InputDouble();
    }

    public static void adicionaTShirt(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o tamanho:");
        String tamanho = input.InputString();
        view.mostraMensagem("Insira o padrão:");
        String padrao = input.InputString();
    }

    public static void adicionaTransportadora(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira o nome:");
        String nome = input.InputString();
        view.mostraMensagem("Insira a margem de lucro:");
        Double padrao = input.InputDouble();
    }

    public static void adicionaEncomenda(IView view,IInput input,IGestor gestor){
        view.mostraMensagem("Insira a dimensão da embalagem:");
        String dimensaoEmbalagem = input.InputString();
        view.mostraMensagem("Insira ");
    }

    public static void adicionaUtilizador(IView view,IInput input,IGestor gestor){

    }

}

