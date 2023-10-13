package Exercise_generics;

public class Generics_exercise_cars<T> {
    private T marca;
    private String modelo;

    public Generics_exercise_cars(T marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public T getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(T marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro [Marca=" + marca + ", Modelo=" + modelo + "]";
    }

    public static void main(String[] args) {
        Generics_exercise_cars<String> carro1 = new Generics_exercise_cars<>("Toyota", "Corolla");
        Generics_exercise_cars<String> carro2 = new Generics_exercise_cars<>("Honda", "Civic");
        Generics_exercise_cars<String> carro3 = new Generics_exercise_cars<>("Ford", "Mustang");

        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(carro3);
    }
}
