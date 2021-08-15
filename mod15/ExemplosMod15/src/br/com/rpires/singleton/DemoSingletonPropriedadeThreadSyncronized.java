package br.com.rpires.singleton;

/**
 * @author rodrigo.pires
 */
public class DemoSingletonPropriedadeThreadSyncronized {

    public static void main(String args[]) {
        Thread t1 = new Thread(new ThreadFoo());
        Thread t2 = new Thread(new ThreadBar());
        t1.start();
        t2.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonPropriedadeSyncronized singleton = SingletonPropriedadeSyncronized.getInstance("Teste");
            System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonPropriedadeSyncronized singleton = SingletonPropriedadeSyncronized.getInstance("Teste1");
            System.out.println(singleton.getValue());
        }
    }
}
