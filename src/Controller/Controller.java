package Controller;
import java.io.IOException;
import java.text.ParseException;

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
                adicionaSapatilhaNormal(view,input,gestor);
                break;
            case 2:
                adicionaSapatilhaPremium(view,input,gestor);
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
                view.mostraMensagem("Erro na escolha do artigo");
                IView.pressEnterToContinue(input);
                break;
        }
    }

    public static void adicionaSapatilhaNormal(IView view,IInput input,IGestor gestor){

    }

    public static void adicionaSapatilhaPremium(IView view,IInput input,IGestor gestor){

    }

    public static void adicionaMalaNormal(IView view,IInput input,IGestor gestor){

    }

    public static void adicionaMalaPremium(IView view,IInput input,IGestor gestor){

    }

    public static void adicionaTShirt(IView view,IInput input,IGestor gestor){

    }

    public static void adicionaTransportadora(IView view,IInput input,IGestor gestor){

    }

    public static void adicionaEncomenda(IView view,IInput input,IGestor gestor){

    }

    public static void adicionaUtilizador(IView view,IInput input,IGestor gestor){

    }

}

