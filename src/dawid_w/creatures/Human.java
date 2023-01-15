package dawid_w.creatures;

import dawid_w.Saleable;
import dawid_w.devices.Car;
import dawid_w.devices.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Human extends Animal implements Saleable {
    public String firstName;
    public String lastName;
    public Car car;
    public Phone phone;
    public Animal pet;
    public FarmAnimal farmPet;
    private Double salary;
    private Car auto;
    public Double cash;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 0.0;
        this.firstName = firstName;
        this.cash = 0.0;
    }

    public Double getSalary() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("\nData/godz pobrania danych: " + dateTime.format(DateTimeFormatter.ofPattern("d.M.y HH:mm:ss")));
        System.out.print("Aktualna wartość wypłaty: ");
        return this.salary;
    }

    public void setSalary(Double salary) {
        if (salary >= 0) {
            System.out.println("\nNowe dane zostały wysłane do systemu księgowego.");
            System.out.println("Należy koniecznie odebrać aneks od umowy od pani Hani z kadr.");
            System.out.println("ZUS i US już wiedzą o zmianie wypłaty i nie ma sensu ukrywać dochodu.");
            this.salary = salary;
        } else System.out.println("\nWyplata nie może być ujemna!(Tak nigdy nic nie zarobisz...)");
    }

    public Car getCar() {
        return this.auto;
    }

    public void setCar(Car auto) {
        if (this.salary > auto.value) {
            System.out.println("\nUdało się kupić auto za gotówkę.");
            this.auto = auto;
        } else if (this.salary > (auto.value / 12.0)) {
            System.out.println("\nUdało się kupić auto na kredyt.");
            this.auto = auto;
        } else {
            System.out.println("\nZapisz się na studia i znajdź nową robotę albo idź po podwyżkę.");
        }
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        System.out.println("Handel ludźmi jest niemożliwy");
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", car=" + car +
                ", phone=" + phone +
                ", pet=" + pet +
                ", salary=" + salary +
                ", auto=" + auto +
                ", cash=" + cash +
                '}';
    }
}
