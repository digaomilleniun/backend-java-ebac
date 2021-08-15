package br.com.rpires.observer;

/**
 * @author rodrigo.pires
 */
public interface Subject {

    public void add(Observer observer);

    public void remove(Observer observer);

    public void notifyAll(String titulo);
}
