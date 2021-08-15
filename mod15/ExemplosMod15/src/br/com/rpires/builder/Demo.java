package br.com.rpires.builder;

/**
 * @author rodrigo.pires
 */
public class Demo {

    public static void main(String[] args) {
        //Gerente gerente = new Gerente(new CheeseBurgerBuilder());
        Gerente gerente = new Gerente();
        gerente.setBuilder(new CheeseBurgerBuilder());
        Burger buger = gerente.buildBurger();
        buger.print();

        //Gerente gerente1 = new Gerente(new VeganBurgerBuidler());
        gerente.setBuilder(new VeganBurgerBuidler());
        Burger buger1 = gerente.buildBurger();
        buger1.print();
    }
}
