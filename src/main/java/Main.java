//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carName = "";
        int carSpeed = 0;
        Car car;
        Race race = new Race();


                for (int i = 1; i < 4; i++) {
                    System.out.println("Введите название автомобиля №" + i);
                    carName = scanner.next();
                    System.out.println("Введите скорость автомобиля №" + i);
                    while (true) {
                        carSpeed = scanner.nextInt();
                        if (carSpeed > 0 && carSpeed < 250) {
                            car = new Car(carName, carSpeed);
                            race.createCar(car);
                        break;
                        } else {
                            System.out.println("Неверная команда, попробуйте еще раз.");
                        }
                    }
                }
                race.setWinner();
                System.out.println("Самая быстрая машина: " + race.winner);
            }

        }
