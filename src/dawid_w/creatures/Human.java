package dawid_w.creatures;

import dawid_w.Saleable;
import dawid_w.devices.Car;
import dawid_w.devices.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Human extends Animal implements Saleable {
    private static final int DEFAULT_VEHICLE_NUMBER = 3;
    private static final Double DEFAULT_HUMAN_WEIGHT = 70.0;
    private static final Double DEFAULT_HUMAN_SALARY = 0.0;
    private static final String HUMAN_SPECIES = "homo sapiens";
    private static final Double DEFAULT_HUMAN_CASH = 0.0;
    public String firstName;
    public String lastName;
    public Car[] garage;
    public Phone phone;
    public Animal pet;
    public FarmAnimal farmPet;
    private Double salary;
    public Double cash;

    public Human(String firstName) {
        this(firstName, DEFAULT_VEHICLE_NUMBER);
    }

    public Human(String firstName, Integer vehicleNumber) {
        super(HUMAN_SPECIES);
        this.weight = DEFAULT_HUMAN_WEIGHT;
        this.salary = DEFAULT_HUMAN_SALARY;
        this.firstName = firstName;
        this.cash = DEFAULT_HUMAN_CASH;
        this.garage = new Car[vehicleNumber];
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

    public void setCar(Car newCar, Integer parkingLotNumber) {
        if (parkingLotNumber >= this.garage.length) {
            System.out.println("Niestety, nie mamy tyle miejsc parkingowych");
        } else if (parkingLotNumber < 0) {
            System.out.println("Nie ma takiego miejsca");
        } else if (this.garage[parkingLotNumber] != null) {
            System.out.println("To miejsce jest juz zajęte");
        } else {
            this.garage[parkingLotNumber] = newCar;
        }
    }

    public void getCar(Integer parkingLotNumber) {
        if (parkingLotNumber >= this.garage.length) {
            System.out.println("Niestety, nie mamy tyle miejsc parkingowych");
        } else if (parkingLotNumber < 0) {
            System.out.println("Nie ma takiego miejsca");
        } else if (this.garage[parkingLotNumber] == null) {
            System.out.println("To miejsce jest puste");
        } else {
            System.out.println("Zawartosc tego miejsca parkingowego - " + this.garage[parkingLotNumber]);
        }
    }

    public Double getValueOfAllCars() {
        Double valueOfCars = 0.0;
        for (Car car : this.garage) {
            if (car != null) {
                valueOfCars += car.value;
            }
        }
        return valueOfCars;
    }

    public void sortAllCarsInGarageByYear() {
        Arrays.sort(this.garage, (b, a) -> a.yearOfProduction.compareTo(b.yearOfProduction));
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
                ", garage=" + Arrays.toString(garage) +
                ", phone=" + phone +
                ", pet=" + pet +
                ", farmPet=" + farmPet +
                ", salary=" + salary +
                //", auto=" + auto +
                ", cash=" + cash +
                '}';
    }

    public boolean hasACar(Car car) {
        boolean hasCar = false;
        for (Car value : this.garage) {
            if (value == car) {
                hasCar = true;
                break;
            }
        }
        return hasCar;
    }

    public boolean canHaveMoreCars() {
        boolean hasEmptySpace = false;
        for (Car car : this.garage) {
            if (car == null) {
                hasEmptySpace = true;
                break;
            }
        }
        return hasEmptySpace;
    }

    public boolean hasLessCashThen(Double price) {
        return this.cash >= price;
    }

    public void addCar(Car car) {
        for (int i = 0; i < this.garage.length; i++) {
            if (this.garage[i] == null) {
                this.setCar(car, i);
                break;
            }
        }
    }

    public void removeCar(Car car) {
        for (int i = 0; i < this.garage.length; i++) {
            if (this.garage[i] == car) {
                this.garage[i] = null;
                break;
            }
        }
    }

    public void removeMoney(Double price) {
        this.cash -= price;
    }

    public void addMoney(Double price) {
        this.cash += price;
    }
}
