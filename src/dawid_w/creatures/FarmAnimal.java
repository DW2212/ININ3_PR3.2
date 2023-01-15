package dawid_w.creatures;

public class FarmAnimal extends Animal implements Edbile {

    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        System.out.println("Został zjedzony");
        this.alive = false;
    }
}
