package dawid_w.devices;

public class Diesel extends Car {
    public Diesel(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Tankuje");
        System.out.println("(paliwo leje sie)");
        System.out.println("Zatankowane");
    }
}
