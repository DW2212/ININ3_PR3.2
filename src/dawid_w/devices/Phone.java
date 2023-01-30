package dawid_w.devices;

import dawid_w.Saleable;
import dawid_w.creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Phone extends Device implements Saleable {
    private static final String DEFAULT_APP_SERVER_ADDRESS = "www.google.pl";
    private static final String DEFAULT_APP_PROTOCOL = "https";
    private static final Double DEFAULT_APP_VERSION = 1.0;
    private static final int DEFAULT_APP_PORT = 8089;
    public Double screenSize;
    public String os;
    public Set<Application> applications = new HashSet<>();
    private final Human owner;

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, Human owner) {


        super(producer, model, yearOfProduction);
        this.screenSize = screenSize;
        this.owner = owner;
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

    public void installAnApp(Application app) throws Exception {
        if (this.owner.cash < app.price) {
            throw new Exception("Za malo pieniedzy na zakup aplikacji");
        }
        this.applications.add(app);
        this.owner.cash -= app.price;
    }

    public boolean alreadyInstalled(Application app) {
        return this.applications.contains(app);
    }

    public boolean alreadyInstalled(String appName) {
        for (Application app : this.applications)
            if (app.name.equals(appName)) return true;
        return false;
    }

    public void getAllFreeApps() {
        System.out.println("Lista darmowych aplikacji:");
        for (Application app : this.applications)
            if (app.price == 0.0) System.out.println(app);
    }

    public Double getPriceOfAllApps() {
        Double valueOfApps = 0.0;
        for (Application app : this.applications) valueOfApps += app.price;
        return valueOfApps;
    }

    public void getAllAppsByName() {
        System.out.println("Lista aplikacji wg nazwy A-Z:");
        List<Application> applicationListByName = applications.stream().sorted(Comparator.comparing(Application::getName)).toList();
        for (Application app : applicationListByName) {
            System.out.println(app);
        }
    }

    public void getAllAppsByPriceLowToHigh() {
        System.out.println("Lista aplikacji wg ceny 0-9:");
        List<Application> applicationListByPrice = applications.stream().sorted(Comparator.comparing(Application::getPrice)).toList();
        for (Application app : applicationListByPrice) {
            System.out.println(app);
        }
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
