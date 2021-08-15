package br.com.rpires.builder;

/**
 * @author rodrigo.pires
 */
public class VeganBurgerBuidler extends BurgerBuilder{

    @Override
    public void buildBun() {
        burger.setBun("Vegan White Bread");
    }
    @Override
    public void buildMeat() {
        burger.setMeat("Vegan Beef");
    }
    @Override
    public void buildSalad() {
        burger.setSalad("Vegan Iceberg");
    }
    @Override
    public void buildCheese() {
        burger.setCheese("Vegan American Cheese");
    }
    @Override
    public void buildSauce() {
        burger.setSauce("Vegan Secret Sauce");
    }
}
