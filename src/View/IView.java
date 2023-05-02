package View;

import Controller.IInput;

public interface IView {
    public void mostrarMenuSimulacao();

    public void mostrarMenuUser();
    public void mostraMenuPrincipalUser();
    public void mostraMenuPrincipalAdmin();
    void mostrarMenuPrincipal();
    public void mostraMenuArtigos();
    public void pressEnterToContinue(IInput input);
    public void mostraMensagem(String msg);
    public void clearScreen();
}
