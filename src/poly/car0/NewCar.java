package poly.car0;

public class NewCar implements Car {
    @Override
    public void startEngine() {
        System.out.println("NewCar.startEngine");
    }

    @Override
    public void pressAccelerator() {
        System.out.println("NewCar.pressAccelerator");
    }

    @Override
    public void offEngine() {
        System.out.println("NewCar.offEngine");
    }
}
