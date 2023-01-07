import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Car passat = new Car("vw", "passat", 2001);
        passat.millage = 78000.0;
        passat.value = 12000.0;
        System.out.println(passat.producer);
        System.out.println(passat.model);
        System.out.println(passat.yearOfProduction);

        Human andrzej = new Human();
        andrzej.setSalary(2000.0);
        System.out.println(andrzej.getSalary());
        andrzej.setCar(passat);
        System.out.println("andrzej.getCar=" + andrzej.getCar());

        Car fiat = new Car("fiat", "bravo", 2010);
        fiat.millage = 312321.5;
        System.out.println("Model auta: " + fiat.model);
        System.out.println("Przebieg: " + fiat.millage);

        Animal kot = new Animal("kot");
        kot.name = "Filemon";
        kot.feed();
        kot.takeForAWalk();
        System.out.println("Czy zyje: " + kot.alive);
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.takeForAWalk();
        kot.feed();
        kot.takeForAWalk();


        System.out.println(passat.equals(fiat));
        Car ford = new Car("ford", "mondeo", 2015);
        Car ford2 = new Car("ford", "mondeo", 2015);
        System.out.println("Porównuje ford(ford,mondeo,2015) i ford2(ford,mondeo,2015): " + passat.equals(fiat));
        System.out.println(kot);
        System.out.println(ford);
        System.out.println(ford2);
        Phone xiaomi = new Phone("Xiaomi", "13 Pro", 6.0, "Android 12");
        andrzej.pet = kot;

        System.out.println();
        System.out.println(andrzej);
        System.out.println(passat);
        System.out.println(kot);
        System.out.println(xiaomi);
///
        //System.out.println("Wynik 65659 % 3 = " + 65659 % 3);
    }
}