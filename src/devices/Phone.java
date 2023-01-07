package devices;

public class Phone extends Device{
    Double screenSize;
    public String os;

    public String toString() {
        return producer + " " + model + " " + screenSize + " " + os;
    }

    public Phone(String producer, String model, Double screenSize, String os) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.os = os;
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
