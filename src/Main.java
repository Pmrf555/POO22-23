import Controller.Controller;
import Model.Gestor;
import Model.Parser;

public class Main {
    /**
     * Método para correr as funcionalidades do Projeto.
     *
     * @param args Argumentos da main.
     * @throws Exception Lançar exceções caso seja necessário.
     */
    public static void main(String[] args) throws Exception {
        Gestor ges = new Gestor();
        Parser parse = new Parser();

        parse.lerFicheiro(ges,"ficheiroLeitura");
        System.out.println(ges.getArtigosMap().size() + " " +ges.getTransportadoraMap().size()+" "+ges.getUtilizadorMap().size()+" "+ges.getEncomendasMap().size());
        //Controller.run();
    }

}
