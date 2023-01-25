package dawid_w;

import dawid_w.creatures.FarmAnimal;
import dawid_w.creatures.Human;
import dawid_w.creatures.Pet;
import dawid_w.devices.Diesel;
import dawid_w.devices.Electric;
import dawid_w.devices.LPG;
import dawid_w.devices.Phone;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Diesel passat = new Diesel("vw", "passat", 2001);
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
        andrzej.setCar(passat, 0);
        System.out.println("andrzej.getCar=");
        andrzej.getCar(1);

        Diesel fiat = new Diesel("fiat", "bravo", 2010);
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
        Electric ford = new Electric("ford", "mondeo", 2015);
        LPG ford2 = new LPG("ford", "mondeo", 2015);
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
        me.setCar(passat, 0);
        brother.cash = 9999.0;
        try {
            passat.sell(me, brother, 3000.0);
            System.out.println("Transakcja sie udala");
        } catch (Exception e) {
            System.out.println("Sprzedaz sie nie powiodla");
        }

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

        xiaomi.installAnApp("Kalkulator");
        xiaomi.installAnApp("Kalkulator", 1.1);
        xiaomi.installAnApp("Kalkulator", 1.2, "wp.pl");

        ArrayList<String> apps = new ArrayList<>();
        apps.add("notatnik");
        apps.add("kamera");
        xiaomi.installAnApp(apps);

        int[] tab = new int[10];
        for (int i = 101; i < 111; i++) {
            tab[i - 101] = i;
            System.out.println("tab[" + (i - 101) + "]=" + tab[i - 101]);
        }

        int licznik = 0;
        for (int i = 10; i < 110; i = i + 10) {
            tab[licznik] = i;
            System.out.println("tab[" + (licznik) + "]=" + tab[licznik]);
            licznik++;
        }

        boolean[] tab2 = new boolean[20];
        for (int i = 0; i < tab2.length; i++) {
            tab2[i] = i % 2 == 0;
            System.out.println("tab2[" + (i) + "]=" + tab2[i]);
        }

        int[] tab3 = new int[100];
        licznik = 0;
        for (int i = 0; i < 100; i++) {
            tab3[i] = licznik++;
            if (licznik == 10) licznik = 0;
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("tab3[" + (i) + "]=" + tab3[i]);
        }

        Human one = new Human("John");
        Diesel cupra = new Diesel("seat", "cupra", 2020);
        cupra.value = 60000.0;
        Diesel mustang = new Diesel("ford", "mustang", 1986);
        mustang.value = 100000.0;
        mustang.refuel();
        one.setCar(cupra, 0);
        one.setCar(mustang, 2);

        System.out.println("Wartosc wszystkich aut wynosi:");
        System.out.println(one.getValueOfAllCars() + " zł");

        Human two = new Human("Tom");
        try {
            mustang.sell(one, two, 85000.0);
            System.out.println("Transakcja sie udala");
        } catch (Exception e) {
            System.out.println("Sprzedaz sie nie powiodla");
        }
        //System.out.println("Wynik 65659 % 3 = " + 65659 % 3);
    }
}