import java.util.ArrayList;

public class Race {
    String winner = "";
    int distance;

    ArrayList<Car> carArrayList = new ArrayList();

    public void createCar(Car car) {
        carArrayList.add(car);
    }

    public void setWinner() {
        for (Car cars : carArrayList) {
            int newDistance = cars.carSpeed * 24;
            if (newDistance > distance) {
                distance = newDistance;
                winner = cars.carName;
            }
        }
    }

}