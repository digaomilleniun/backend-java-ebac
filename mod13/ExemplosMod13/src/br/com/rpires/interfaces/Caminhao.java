package br.com.rpires.interfaces;

/**
 * @author rodrigo.pires
 */
public class Caminhao implements ICarro {
    @Override
    public void andar() {
        System.out.println("Carro está andando de vagar");
    }

    @Override
    public void parar() {
        System.out.println("Caminhão parando");
    }
}
