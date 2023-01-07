package devices;

public class Phone extends Device{
    public Double screenSize;
    public String os;

    public String toString() {
        return producer + " " + model + " " + screenSize + " " + os;
    }

    public Phone(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);

    }

    public void turnOn() {
        System.out.println("Turning on phone...1%...30%...80%...99%...Phone ready!");
    }

    public void mute() {
        System.out.println("Phone muted!");
    }

    public void installAnApp(String app) {
        System.out.println("App: " + app + ", succesfully installed!");
    }

}
