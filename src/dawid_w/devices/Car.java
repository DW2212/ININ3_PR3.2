package dawid_w.devices;

import dawid_w.Saleable;
import dawid_w.creatures.Human;

public class Car extends Device implements Saleable {

    public Double millage;
    public Double value;
    public String color;

    public Car(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
        this.millage = 0.0;
    }

    public void drive() {
        this.millage += 10.0;
        System.out.println("\nAktualny przebieg to: " + this.millage);
    }

    @Override
    public void turnOn() {
        System.out.println("przekrecam klucz");
        System.out.println("odpala");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            System.out.println("Masz za mało pieniędzy.");
        } else if (seller.car != this) {
            System.out.println("Sprzedający nie ma auta na sprzedaż");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            buyer.car = seller.car;
            seller.car = null;
            System.out.println("Transakcja udana");
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "millage=" + millage +
                ", value=" + value +
                ", color='" + color + '\'' +
                '}';
    }
}
