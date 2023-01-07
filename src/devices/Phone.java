package devices;

public class Phone {
    String producer;
    String model;
    Double screenSize;
    String androidiOS;

    public String toString() {
        return producer + " " + model + " " + screenSize + " " + androidiOS;
    }

    public Phone(String producer, String model, Double screenSize, String androidiOS) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
        this.androidiOS = androidiOS;
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
