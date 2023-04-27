package View;

import Controller.IInput;

public class View implements IView{

    public View() { }

    public void mostrarMenuPrincipal(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        menu.adicionaOpcao("Adicionar Artigo \uD83D\uDCE5");
        menu.adicionaOpcao("Adicionar Transportadora \uD83D\uDE9B");
        menu.adicionaOpcao("Adicionar Encomenda \uD83D\uDCE6");
        menu.adicionaOpcao("Adicionar Utilizador \uD83D\uDC64");
        menu.adicionaOpcao("Ver Artigo \uD83D\uDCE5");
        menu.adicionaOpcao("Ver Transportadora \uD83D\uDE9B");
        menu.adicionaOpcao("Ver Encomenda \uD83D\uDCE6");
        menu.adicionaOpcao("Ver Utilizador \uD83D\uDC64");
        menu.adicionaOpcao("Sair ❌");
        menu.show(true);
    }

    public void mostraMenuArtigos(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        menu.adicionaOpcao("Adicionar Sapatilha Normal \uD83D\uDC5F");
        menu.adicionaOpcao("Adicionar Sapatilha Premium \uD83D\uDC5E");
        menu.adicionaOpcao("Adicionar Mala Normal \uD83D\uDC5B");
        menu.adicionaOpcao("Adicionar Mala Premium \uD83D\uDC5C");
        menu.adicionaOpcao("Adicionar T-Shirt \uD83D\uDC55");
        menu.adicionaOpcao("Voltar");
        menu.adicionaOpcao("Sair ❌");
        menu.show(true);
    }

    public void mostraMensagem(String msg){
        System.out.println(msg);
    }

    public void pressEnterToContinue(IInput input){
        System.out.println(" --- press enter ---");
        input.InputString();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
