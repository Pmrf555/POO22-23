package View;

public class View implements IView{

    public View(){
    }

    public void mostrarMenuPrincipal(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        // menu.adicionaOpcao("Consultar equipas 👥");
        menu.adicionaOpcao("Sair ❌");
        menu.show(true);
    }


    /**
     * Limpar o ecrã
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
