package br.com.rpires.lambdas.anonimas;

/**
 * @author rodrigo.pires
 */
@FunctionalInterface
public interface MyEventConsumer {

    public void consumer(Object value);

    default void calcular() {

    }
}
