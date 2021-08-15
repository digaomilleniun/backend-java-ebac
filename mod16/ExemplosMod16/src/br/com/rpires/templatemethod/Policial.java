package br.com.rpires.templatemethod;

/**
 * @author rodrigo.pires
 */
public class Policial extends Trabalhador {

    @Override
    protected void trabalhar() {
        System.out.println("Trabalhando como Policial");
    }

    @Override
    protected void levantar() {
        System.out.println("Levantando da cama as 08");
    }
}
