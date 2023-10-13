class MarcaCarro {
    private String nome;
    private String sede;

    public MarcaCarro(String nome, String sede) {
        this.nome = nome;
        this.sede = sede;
    }

    public String getNome() {
        return nome;
    }

    public String getSede() {
        return sede;
    }
}

class Ford extends MarcaCarro {
    public Ford() {
        super("Ford", "Dearborn, Michigan, EUA");
    }
}

class Toyota extends MarcaCarro {
    public Toyota() {
        super("Toyota", "Toyota City, Japão");
    }
}

class Honda extends MarcaCarro {
    public Honda() {
        super("Honda", "Tóquio, Japão");
    }
}

class Carro<T extends MarcaCarro> {
    private T marca;

    public Carro(T marca) {
        this.marca = marca;
    }

    public T getMarca() {
        return marca;
    }
}

public class Generics_exercise_cars {
    public static void main(String[] args) {
        Carro<Ford> carroFord = new Carro<>(new Ford());
        Carro<Toyota> carroToyota = new Carro<>(new Toyota());
        Carro<Honda> carroHonda = new Carro<>(new Honda());

        System.out.println("Detalhes do Carro Ford:");
        System.out.println("Marca: " + carroFord.getMarca().getNome());
        System.out.println("Sede: " + carroFord.getMarca().getSede());

        System.out.println("\nDetalhes do Carro Toyota:");
        System.out.println("Marca: " + carroToyota.getMarca().getNome());
        System.out.println("Sede: " + carroToyota.getMarca().getSede());

        System.out.println("\nDetalhes do Carro Honda:");
        System.out.println("Marca: " + carroHonda.getMarca().getNome());
        System.out.println("Sede: " + carroHonda.getMarca().getSede());
    }
}
