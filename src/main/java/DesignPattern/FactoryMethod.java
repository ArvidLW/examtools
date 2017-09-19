package DesignPattern;

public class FactoryMethod {
}

interface Car{
    void start();
}
class CarA implements Car{
    CarA(){
        System.out.println("CarA");
    }
    @Override
    public void start() {}
}
class CarB implements Car{
    CarB(){
        System.out.println("CarB");
    }
    @Override
    public void start() {}
}
interface Bike{
    void start();
}
class BikeA implements Bike{
    @Override
    public void start() {}
}
class BikeB implements Bike{
    @Override
    public void start() {}
}
interface Factory{
    Car createCar();
    Bike createBike();
}
class FactoryCarA implements Factory{
    @Override
    public Car createCar() {
        return new CarA();
    }
    @Override
    public Bike createBike() {
        return new BikeA();
    }
}
class FactoryCarB implements Factory{
    @Override
    public Car createCar() {
        return new CarB();
    }
    @Override
    public Bike createBike() {
        return new BikeB();
    }
}
