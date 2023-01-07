package devices;

public class Device {
    public String producer;
    public String model;
    public Integer yearOfProduction;
    public String toString() {
        return producer + " " + model + " " + yearOfProduction;
    }
}
