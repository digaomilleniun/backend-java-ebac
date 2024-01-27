package br.com.rpires.lambdas.anonimas;

/**
 * @author Steve Vaz
 */
@FunctionalInterface
public interface MyEventConsumerReturn<T> {

    public T consumer(Object value);

}
