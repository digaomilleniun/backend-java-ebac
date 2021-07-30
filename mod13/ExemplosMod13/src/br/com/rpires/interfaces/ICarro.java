package br.com.rpires.interfaces;

/**
 * @author rodrigo.pires
 */
public interface ICarro {

    public default void parar() {
        System.out.println("Carro está em parando");
    }

    public void andar();
}
