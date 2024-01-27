package br.com.rpires.interfaces;

/**
 * @author Steve.Vaz
 */
public class ClasseTeste {

    public static void main(String args[]) {
        ICaneta caneta = new CanetaEsferografica();
        caneta.escrever("Olá Rodrigo");
        caneta.escreverComumATodas();
        System.out.println(caneta.getCor());

        ICaneta giz = new Giz();
        giz.escrever("Olá Steve");
        giz.escreverComumATodas();
        System.out.println(giz.getCor());

        Lapis lapis = new Lapis();
        lapis.escrever("Olá Steve");
        lapis.escreverComumATodas();
        System.out.println(lapis.getCor());

        ICarro carro = new CarroPasseio();
        carro.andar();
        carro.parar();

        ICarro caminhao = new Caminhao();
        caminhao.andar();
        caminhao.parar();
    }
}
