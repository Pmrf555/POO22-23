package View;

import java.util.Scanner;

public class faseCriacao {
    public void criaObjetos(){
        System.out.println("Insira a operação que pretende de seguida:\n");
        System.out.println("1- Inserir Utilizador.");
        System.out.println("2- Inserir Artigo.");
        System.out.println("3- Inserir Transportadora.");
        System.out.println("4- Inserir Dados através de ficheiro.");
        System.out.println("5- Seguir para o programa.");
    }

    public void inserirFicheiro() {
        System.out.println("Insira o caminho para o ficheiro a ler:\n");
    }

    public String getOpcao(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
