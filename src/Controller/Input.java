package Controller;

import java.util.Scanner;

public class Input implements IInput{
    private Scanner scanner;

    /**
     * Construtor de input
     */
    public Input(){
        this.scanner = new Scanner(System.in);
    }

    /**
     * Função que permite fechar o scanner aberto 
     */
    public void closeScanner(){
        this.scanner.close();
    }

    /**
     * Função que pede ao utilizador que introduza um inteiro, pedindo repetidamente até o utilizador introduzir um input válido
     * @return O inteiro lido
     */
    public int InputInteger(){
        int input = 0;
        while(true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e) {
                continue;
            }
        }
        return input;
    }

    public double InputDouble(){
        double input = 0;
        while(true) {
            try {
                input = Double.parseDouble(scanner.nextLine());
                break;
            }catch (NumberFormatException e) {
                continue;
            }
        }
        return input;
    }

    public long InputLong(){
        long input = 0;
        while(true) {
            try {
                input = Long.parseLong(scanner.nextLine());
                break;
            }catch (NumberFormatException e) {
                continue;
            }
        }
        return input;
    }
    /**
     * Função que pede ao utilizador que introduza uma String
     * @return A string lida 
     */
    public String InputString(){
        String str = scanner.nextLine();
        return str;
    }

}