package dawid_w.devices;

import dawid_w.Saleable;
import dawid_w.creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Phone extends Device implements Saleable {
    private static final String DEFAULT_APP_SERVER_ADDRESS = "www.google.pl";
    private static final String DEFAULT_APP_PROTOCOL = "https";
    private static final Double DEFAULT_APP_VERSION = 1.0;
    private static final int DEFAULT_APP_PORT = 8089;
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

    public void installAnApp(String app) throws MalformedURLException {
        this.installAnApp(app, DEFAULT_APP_VERSION);
    }

    public void installAnApp(String app, Double version) throws MalformedURLException {
        this.installAnApp(app, version, DEFAULT_APP_SERVER_ADDRESS);
    }

    public void installAnApp(String app, Double version, String server) throws MalformedURLException {
        System.out.println("Sprawdzam");
        System.out.println("Pobieram");
        System.out.println("Instaluje");
        URL url = new URL(DEFAULT_APP_PROTOCOL, server, DEFAULT_APP_PORT, app + "-" + version);
        this.installAnApp(url);
    }

    public void installAnApp(List<String> apps) throws MalformedURLException {
        for (String app : apps) {
            this.installAnApp(app);
        }
    }

    public void installAnApp(URL url) {
        System.out.println("instalowanie aplikacji z url");
        System.out.println("zainstalowano " + url.getFile() + " z " + url.getHost());
    }

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
