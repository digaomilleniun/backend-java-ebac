package br.com.rpires.lambdas.anonimas;

/**
 * @author rodrigo.pires
 */
@FunctionalInterface
public interface MyEventConsumerReturn<T> {

    public T consumer(Object value);

}
