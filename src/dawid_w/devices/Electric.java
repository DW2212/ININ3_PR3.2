package dawid_w.devices;

public class Electric extends Car {
    public Electric(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Tankuje");
        System.out.println("(paliwo leje sie)");
        System.out.println("Zatankowane");
    }
}
