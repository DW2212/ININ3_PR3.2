package dawid_w.devices;

import dawid_w.Saleable;
import dawid_w.creatures.Human;

import java.util.ArrayList;

public abstract class Car extends Device implements Saleable {

    public Double millage;
    public String color;
    public ArrayList<Human> carOwners = new ArrayList<>();

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
        if (!seller.isLastCarOwner(this, seller)) {
            throw new Exception("Sprzedawca nie jest ostatnim wlasicielem pojazdu");
        }
        if (!buyer.canHaveMoreCars()) {
            throw new Exception("Kupujacy nie moze miec wiecej aut");
        }
        if (!buyer.hasLessCashThen(price)) {
            throw new Exception("Kupujacy nie ma dosc pieniedzy");
        }
        buyer.addCar(this);
        seller.removeCar(this);
        buyer.removeMoney(price);
        seller.addMoney(price);
        System.out.println("Transakcja zakonczona pomyslnie");
    }

    public boolean wasOwner(Human person) {
        return carOwners.contains(person);
    }

    public boolean hasSellCarTo(Human A, Human B) {
        boolean aHaveNow = false;
        boolean bHaveNow = false;
        if (carOwners.contains(A) && carOwners.contains(B)) {
            for (int i = 0; i < A.garage.length; i++) {
                if (A.garage[i] == this) {
                    aHaveNow = true;
                    break;
                }
            }
            for (int i = 0; i < B.garage.length; i++) {
                if (B.garage[i] == this) {
                    bHaveNow = true;
                    break;
                }
            }
        }
        return !aHaveNow && bHaveNow;
    }

    public int numberOfCarTransaction() {
        if (this.carOwners.size() > 0) return carOwners.size() - 1;
        else return 0;
    }

    public abstract void refuel();

    @Override
    public String toString() {
        return "Car{" +
                "millage=" + millage +
                ", value=" + value +
                ", color='" + color +
                ", yearOfProduction=" + yearOfProduction +
                '\'' + '}';
    }
}
