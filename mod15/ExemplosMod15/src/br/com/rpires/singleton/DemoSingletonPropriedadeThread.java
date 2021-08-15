package br.com.rpires.singleton;

/**
 * @author rodrigo.pires
 */
public class DemoSingletonPropriedadeThread {

    public static void main(String args[]) {
        Thread t1 = new Thread(new ThreadFoo());
        Thread t2 = new Thread(new ThreadBar());
        t1.start();
        t2.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste");
            System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste1");
            System.out.println(singleton.getValue());
        }
    }
}
