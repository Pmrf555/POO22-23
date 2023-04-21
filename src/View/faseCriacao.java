package View;

import java.util.Scanner;

public class faseCriacao {
    public int criaObjetos(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira a operação que pretende de seguida:\n");
        System.out.println("1- Inserir Utilizador.");
        System.out.println("2- Inserir Artigo.");
        System.out.println("3- Inserir Transportadora.");
        System.out.println("4- Inserir Dados através de ficheiro.");
        System.out.println("5- Seguir para o programa.");
        return scan.nextInt();
    }

    public String inserirFicheiro(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o caminho para o ficheiro a ler:\n");
        return scan.nextLine();
    }

}
