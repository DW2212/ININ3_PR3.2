package dawid_w;

import dawid_w.creatures.FarmAnimal;
import dawid_w.creatures.Human;
import dawid_w.creatures.Pet;
import dawid_w.devices.Car;
import dawid_w.devices.Phone;

public class Main {
    public static void main(String[] args) {
        Car passat = new Car("vw", "passat", 2001);
        passat.millage = 78000.0;
        passat.value = 12000.0;
        System.out.println(passat.producer);
        System.out.println(passat.model);
        System.out.println(passat.yearOfProduction);
        passat.drive();

        Human andrzej = new Human("Andrzej");
        andrzej.feed();
        System.out.println(andrzej.weight);
        System.out.println(andrzej.species);
        andrzej.setSalary(2000.0);
        System.out.println(andrzej.getSalary());
        andrzej.setCar(passat);
        System.out.println("andrzej.getCar=" + andrzej.getCar());

        Car fiat = new Car("fiat", "bravo", 2010);
        fiat.millage = 312321.5;
        System.out.println("Model auta: " + fiat.model);
        System.out.println("Przebieg: " + fiat.millage);

        Pet kot = new Pet("kot");
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
        Phone xiaomi = new Phone("Xiaomi", "13 Pro", 2018);
        xiaomi.mute();
        xiaomi.installAnApp("TrashXXL");
        andrzej.pet = kot;

        System.out.println();
        System.out.println(andrzej);
        System.out.println(passat);
        System.out.println(kot);
        System.out.println(xiaomi);

        Human kacper = new Human("Kacper");
        kacper.feed();
        System.out.println(kacper.weight);
        System.out.println(kacper.species);

        ford2.color = "czarny";
        System.out.println("Kolor ford2=" + ford2.color);

        ford.turnOn();
        xiaomi.turnOn();
        System.out.println();

        Human me = new Human("Kacper");
        Human brother = new Human("Piotr");
        me.car = passat;
        brother.cash = 9999.0;
        passat.sell(me, brother, 3000.0);

        me.phone = xiaomi;
        xiaomi.sell(me, brother, 200.0);
        kacper.sell(me, brother, 3.50);

        System.out.println();
        FarmAnimal kurczak = new FarmAnimal("ptak");
        me.farmPet = kurczak;
        kurczak.beEaten();

        System.out.println();
        Pet pies = new Pet("ssak");
        pies.feed();
        pies.feed(5.0);
        System.out.println(pies);
        //System.out.println("Wynik 65659 % 3 = " + 65659 % 3);
    }
}