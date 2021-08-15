package br.com.rpires.templatemethod;

/**
 * @author rodrigo.pires
 */
public class Advogado extends Trabalhador{

    @Override
    public void executar() {
        System.out.println("Estou de férias");
    }

    @Override
    protected void trabalhar() {

    }

    @Override
    protected void voltarParaCasa() {
        System.out.println("Voltar para casa de carro");
    }

    @Override
    protected void irAoTrabalho() {
        super.irAoTrabalho();
    }

    @Override
    protected void iniciarRotina() {
        super.iniciarRotina();
    }

    @Override
    protected void levantar() {
        super.levantar();
    }
}
