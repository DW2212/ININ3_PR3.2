package dawid_w.creatures;

import dawid_w.Saleable;

public abstract class Animal implements Saleable, Feedable {
    public final static Double DEFAULT_FOOD_WEIGHT = 0.5;
    private static final Double DEFAULT_ANIMAL_WEIGHT = 3.0;
    private static final Boolean DEFAULT_ANIMAL_ALIVE_STATUS = true;
    public String species;
    public String name;
    public Double weight;
    public Boolean alive;

    public Animal(String species) {
        this.species = species;
        this.weight = DEFAULT_ANIMAL_WEIGHT;
        this.alive = DEFAULT_ANIMAL_ALIVE_STATUS;
    }

    public void feed() {
        this.feed(DEFAULT_FOOD_WEIGHT);
    }

    public void feed(Double foodWeight) {
        if (!this.alive) System.out.println("\nOh, nooooo, its dead!");
        else {
            this.weight += foodWeight;
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
