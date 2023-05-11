package View;

import Controller.IInput;

public class View implements IView{

    public View() { }

    public void mostrarMenuSimulacao(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        menu.adicionaOpcao("Qual o vendedor que mais faturou desde sempre: \uD83D\uDCB0");
        menu.adicionaOpcao("Qual o vendedor que mais faturou num período de tempo: \uD83D\uDCB0 ⏳");
        menu.adicionaOpcao("Qual o transportador com maior volume de faturação: \uD83D\uDCB0 \uD83D\uDE9A");
        menu.adicionaOpcao("Listar encomendas emitidas por vendedor: \uD83D\uDCDC");
        menu.adicionaOpcao("Ordenar os maiores vendedores do programa num determinado tempo: \uD83D\uDCB1 ⏳");
        menu.adicionaOpcao("Ordenar os maiores compradores do programa num determinado tempo: \uD83D\uDCB2 ⏳");
        menu.adicionaOpcao("Quanto dinheiro ganhou a Vintage no seu funcionamento \uD83D\uDCB8");
        menu.adicionaOpcao("Sair da simulação ❌");
        menu.show(true);
    }
    public void mostraMenuPrincipalAdmin(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        menu.adicionaOpcao("Adicionar Transportadora \uD83D\uDE9A");
        menu.adicionaOpcao("Ver Artigos \uD83D\uDCE4");
        menu.adicionaOpcao("Ver Transportadoras \uD83D\uDE9B");
        menu.adicionaOpcao("Ver Encomendas \uD83D\uDCE6");
        menu.adicionaOpcao("Ver Utilizadores \uD83D\uDC65");
        menu.adicionaOpcao("Ver Estatísticas \uD83D\uDCCA");
        menu.adicionaOpcao("Avançar tempo ⏳");
        menu.adicionaOpcao("Guardar estado do programa em ficheiro \uD83D\uDCBE");
        menu.adicionaOpcao("Obter estado do programa por ficheiro \uD83D\uDCBD");
        menu.adicionaOpcao("Voltar ←");
        menu.adicionaOpcao("Sair ❌");
        menu.show(true);
    }

    public void mostraMenuPrincipalUser(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        menu.adicionaOpcao("Adicionar Artigo \uD83D\uDCE5");
        menu.adicionaOpcao("Adicionar Encomenda \uD83D\uDCE6");
        menu.adicionaOpcao("Ver Artigos \uD83D\uDCE4");
        menu.adicionaOpcao("Ver Transportadoras \uD83D\uDE9B");
        menu.adicionaOpcao("Ver Encomendas \uD83D\uDCE6");
        menu.adicionaOpcao("Ver Utilizadores \uD83D\uDC64");
        menu.adicionaOpcao("Ver Estatísticas \uD83D\uDCCA");
        menu.adicionaOpcao("Guardar estado do programa em ficheiro \uD83D\uDCBE");
        menu.adicionaOpcao("Obter estado do programa por ficheiro \uD83D\uDCBD");
        menu.adicionaOpcao("Voltar ←");
        menu.adicionaOpcao("Sair ❌");
        menu.adicionaOpcao("Avançar Tempo ⏳");
        menu.show(true);
    }
    public void mostrarMenuUser(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        menu.adicionaOpcao("Entrar na conta \uD83D\uDD10");
        menu.adicionaOpcao("Criar conta \uD83D\uDD0F");
        menu.adicionaOpcao("Sair ❌");
        menu.show(true);
    }

    public void mostrarMenuPrincipal(){
        clearScreen();
        Menu menu = new Menu();
        menu.setTitulo("marketplace Vintage \uD83C\uDFEA");
        menu.adicionaOpcao("Entrar como Utilizador \uD83D\uDC65");
        menu.adicionaOpcao("Entrar como administrador \uD83D\uDC64");
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
        menu.adicionaOpcao("Voltar ←");
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

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
