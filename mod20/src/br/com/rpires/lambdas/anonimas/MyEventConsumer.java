package br.com.rpires.lambdas.anonimas;

/**
 * @author Steve Vaz
 */
@FunctionalInterface
public interface MyEventConsumer {

    public void consumer(Object value);

    default void calcular() {

    }
}
