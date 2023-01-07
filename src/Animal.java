public class Animal {
    String species;
    String name;
    private Double weight;
    Boolean alive;

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

    public String toString() {
        return species + " " + name + " " + weight + " " + alive;
    }
}
