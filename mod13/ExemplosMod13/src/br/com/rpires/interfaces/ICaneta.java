package br.com.rpires.interfaces;

/**
 * @author rodrigo.pires
 */
public interface ICaneta {

    public void escrever(String texto);

    public String getCor();

    default void escreverComumATodas() {
        System.out.println("Escrita igual a todas");
    }
}
