package View;

import Controller.IInput;

public interface IView {

    void mostrarMenuPrincipal();
    public void mostraMenuArtigos();
    public void pressEnterToContinue(IInput input);
    public void mostraMensagem(String msg);
    public static void clearScreen() {}
}
