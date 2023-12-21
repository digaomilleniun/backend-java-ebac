package br.com.rpires;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author Steve Vaz
 */
public class CriandoStreams {

    public static void main(String[] args) {
        List.of("Rodrigo", "Pires", "Teste").stream();

        Set.of("Rodrigo", "Pires", "Teste").stream();

        Map<String, String> map = Map.of("Rodrigo", "Pires");
        map.keySet().stream();
        map.values().stream();

        Stream.of("String", "asds");
    }
}
