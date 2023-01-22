package dawid_w.devices;

import dawid_w.Saleable;
import dawid_w.creatures.Human;

import java.util.List;

public class Phone extends Device implements Saleable {
    public final static String DEFAULT_SERVER_ADDRESS="www.google.pl";
    public final static String DEFAULT_PROTOCOLE="http://";
    public final static Double DEFAULT_APP_VERSION=1.0;
    public Double screenSize;
    public String os;

    public Phone(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on phone...1%...30%...80%...99%...Phone ready!");
    }

    public void mute() {
        System.out.println("Phone muted!");
    }

    public void installAnApp(String app) {
/*
        System.out.println("App: " + app + ", succesfully installed!");
*/
        this.installAnApp(app,DEFAULT_APP_VERSION,DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String app, Double version) {
        /*System.out.println("App: " + app + ", version: " + version + ", succesfully installed!");*/
        this.installAnApp(app,version,DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String app, Double version, String url) {
        System.out.println("Sprawdzam");
        System.out.println("Pobieram");
        System.out.println("Instaluje");
        System.out.println("App: " + app + ", version: " + version + ", URL: " + url + ", succesfully installed!");
    }

    public void installAnApp(List<String> apps) {
        //System.out.println(apps);
        /*System.out.println("App list: ");
        for (String app : applist)
            System.out.print(app + ", ");*/
        for(String app:apps){
            this.installAnApp(app);
        }
    }
/*    public void installAnApp(URL app(app,version,url)) {
        System.out.println(app);
    }*/

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (buyer.cash < price) {
            System.out.println("Masz za mało pieniędzy.");
        } else if (seller.phone != this) {
            System.out.println("Sprzedający nie ma telefonu na sprzedaż");
        } else {
            seller.cash += price;
            buyer.cash -= price;
            buyer.phone = seller.phone;
            seller.phone = null;
            System.out.println("Transakcja udana");
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screenSize=" + screenSize +
                ", os='" + os + '\'' +
                '}';
    }
}
