// Interface abstrata para a fábrica de carros
package Exercise_mod15;

interface CarFactory {
    Car createCar();
}

// Interface abstrata para os carros
interface Car {
    void assemble();
}

// Classes concretas para diferentes tipos de carros
class SportsCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Montando um carro esportivo.");
    }
}

class CompactCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Montando um carro compacto.");
    }
}

// Fábrica concreta para carros esportivos
class SportsCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SportsCar();
    }
}

// Fábrica concreta para carros compactos
class CompactCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new CompactCar();
    }
}

public class Exercise_Abstract_Factory_Cars {
    public static void main(String[] args) {
        // Crie uma fábrica de carros esportivos
        CarFactory sportsCarFactory = new SportsCarFactory();
        
        // Use a fábrica para criar um carro esportivo
        Car sportsCar = sportsCarFactory.createCar();
        sportsCar.assemble();
        
        // Crie uma fábrica de carros compactos
        CarFactory compactCarFactory = new CompactCarFactory();
        
        // Use a fábrica para criar um carro compacto
        Car compactCar = compactCarFactory.createCar();
        compactCar.assemble();
    }
}