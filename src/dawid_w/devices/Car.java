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
    public String toString() {
        return producer + " " + model + " " + yearOfProduction + " " + millage + " " + value + " " + color;
    }

    @Override
    public void turnOn() {
        System.out.println("przekrecam klucz");
        System.out.println("odpala");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            //wywal blad
        } else if (seller.car != this) {
            //wywal blad
        } else {
            //przeprowadz transakcje
            seller.cash += price;
            buyer.cash -= price;
        }
        /*sprawdzenie, czy sprzedający rzeczywiście posiada zwierze, samochód lub telefon, który chciałby sprzedać
        sprawdzenie, czy kupujący ma dość gotówki
        ubytek pieniądza na koncie kupującego
        przybytek pieniądza na koncie sprzedającego
        zmianę właściciela sprzedawanego obiektu
        wypisanie na konsole informacji o przeprowadzonej transakcji*/
        //if(bu)
    }
}
