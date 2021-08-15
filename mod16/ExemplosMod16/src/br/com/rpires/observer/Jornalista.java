package br.com.rpires.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rodrigo.pires
 */
public class Jornalista implements Subject {

    public List<Observer> observers = new ArrayList<>();

    private String titulo;


    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAll(String titulo) {
        this.titulo = titulo;
        for (Observer ob : this.observers) {
            ob.update(this);
        }
    }

    @Override
    public String toString() {
        return "Jornalista{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
