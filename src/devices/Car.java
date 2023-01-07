package devices;

public class Car extends Device{

    public Double millage;
    public Double value;
    public String color;



    public Car(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
        this.millage = millage;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("\nAktualny przebieg to: " + this.millage);
    }

    public String toString() {
        return producer + " " + model + " " + yearOfProduction + " " + millage + " " + value + " " + color;
    }

    @Override
    public void turnOn() {
        System.out.println("przekrecam klucz");
        System.out.println("odpala");
    }
}
