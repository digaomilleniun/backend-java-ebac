package br.com.rpires.builder;

/**
 * @author rodrigo.pires
 */
public abstract class BurgerBuilder {

    Burger burger = new Burger();

    abstract void buildBun();
    abstract void buildMeat();
    abstract void buildSalad();
    abstract void buildCheese();
    abstract void buildSauce();

    Burger build(){
        return burger;
    };

}
