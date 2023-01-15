package dawid_w.creatures;

import dawid_w.Saleable;

public class Animal implements Saleable {
    public String species;
    public String name;
    public Double weight;
    public Boolean alive;

    public Animal(String species) {
        this.species = species;
        this.weight = 3.0;
        this.alive = true;
    }

    public void feed() {
        if (!this.alive) System.out.println("\nOh, nooooo, its dead!");
        else {
            this.weight += 0.5;
            System.out.println("\npodziekowal za jedzenie");
        }
    }

    public void takeForAWalk() {
        if (!this.alive) System.out.println("\nOh, nooooo, its dead!");
        else {
            this.weight -= 0.5;
            if (this.weight <= 0) this.alive = false;
        }
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            System.out.println("Masz za mało pieniędzy.");
        } else if (seller.pet != this) {
            System.out.println("Sprzedający nie żadnego zwierzęcia na sprzedaż");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            buyer.pet = seller.pet;
            seller.pet = null;
            System.out.println("Transakcja udana");
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", alive=" + alive +
                '}';
    }
}
