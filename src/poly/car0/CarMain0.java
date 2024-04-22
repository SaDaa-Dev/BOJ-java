package poly.car0;

public class CarMain0 {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Car car = new Model3Car();

        driver.setCar(car);
        driver.drive();
    }
}
