package View;

import Controller.IInput;

public interface IView {

    void mostrarMenuPrincipal();
    public void mostraMenuArtigos();
    public static void pressEnterToContinue(IInput input){
        System.out.println(" --- press enter ---");
        input.InputString();
    }
    public void mostraMensagem(String msg);
    public static void clearScreen() {}
}
