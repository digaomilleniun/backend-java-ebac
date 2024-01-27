package br.com.rpires.lambdas.anonimas;

/**
 * @author Steve Vaz
 */
public class QuandoUtilizarParenteses {

    public static void main(String[] args) {
        MyEventConsumer myEvent = (Object s) -> {
            System.out.println(s);
        };
        
        System.out.println(myEvent);
        
        MyEventConsumer myEvent1 = (s) -> {
            System.out.println(s);
        };

        System.out.println(myEvent1);
        
        MyEventConsumer myEvent2 = s -> System.out.println(s);

        MyEventConsumer myEvent3 = s -> {
            System.out.println(s);
            System.out.println(s);
        };
        
        System.out.println(myEvent3);
        myEvent2.consumer("as");

        MyEventConsumerReturn<Integer> ret = s -> {
            System.out.println(s);
            System.out.println(s);
            return 1;
        };
        ret.consumer(1);

        MyEventConsumerReturn<String> retS = s -> {
            System.out.println(s);
            System.out.println(s);
            return "Ola";
        };
        
        System.out.println(retS);
        ret.consumer(1);

        MyEventConsumer myEvent4 = s -> imprimir(s);
        myEvent4.consumer(1);
    }

    private static <T> T imprimir(T value) {
        System.out.println(value);
        return value;
    }
}
