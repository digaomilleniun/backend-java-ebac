package br.com.rpires.lambdas;

/**
 * @author Steve Vaz
 */
public class TesteLambdasThreads {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Executanto comum");
            }
        };
        new Thread(r).start();

        Runnable rLambda = () -> System.out.println("Executanto rLambda");
        new Thread(rLambda).start();

        new Thread(() -> System.out.println("Executanto Lambda 1")).start();

    }
}
