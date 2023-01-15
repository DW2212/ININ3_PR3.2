package dawid_w.creatures;

import dawid_w.creatures.Animal;
import dawid_w.devices.Car;
import dawid_w.devices.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Human extends Animal {
    public String firstName;
    public String lastName;
    public Car car;
    Phone phone;
    public Animal pet;
    private Double salary;
    private Car auto;
    public Double cash;

    public Human(String firstName) {
        super("homo sapiens");
        this.weight = 70.0;
        this.salary = 0.0;
        this.firstName = firstName;
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

    public String toString() {
        return pet + " " + salary + " " + auto;
    }
}
