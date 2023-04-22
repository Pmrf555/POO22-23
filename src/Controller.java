import java.io.IOException;

public class Controller {

    public static void run() throws ClassNotFoundException, IOException {
        IView view = new View();
        IInput input = new Input();
        IModel model = new Model();
        IParser p = new Parser();
        p.parse(model);
        while (true) {
            view.mostrarMenuPrincipal();
            int escolha = input.InputInteger();
            switch (escolha) {
                case 1:
                    input.closeScanner();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

}
