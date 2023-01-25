package dawid_w.devices;

import dawid_w.Saleable;
import dawid_w.creatures.Human;

public abstract class Car extends Device implements Saleable {

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
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if (!seller.hasACar(this)) {
            throw new Exception("Sprzedawca nie ma tego auta");
        }
        if (!buyer.canHaveMoreCars()) {
            throw new Exception("Kupujacy nie moze miec wiecej aut");
        }
        if (buyer.hasLessCashThen(price)) {
            throw new Exception("Kupujacy nie ma dosc pieniedzy");
        }
        buyer.addCar(this);
        seller.removeCar(this);
        buyer.removeMoney(price);
        seller.addMoney(price);
        System.out.println("Transakcja zakonczona pomyslnie");
    }

    public abstract void refuel();

    @Override
    public String toString() {
        return "Car{" +
                "millage=" + millage +
                ", value=" + value +
                ", color='" + color + '\'' +
                '}';
    }
}
