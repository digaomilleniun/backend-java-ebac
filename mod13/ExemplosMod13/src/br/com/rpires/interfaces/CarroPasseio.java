package br.com.rpires.interfaces;

/**
 * @author rodrigo.pires
 */
public class CarroPasseio implements ICarro{

    @Override
    public void andar() {
        System.out.println("Carro está andando rápido");
    }
}
