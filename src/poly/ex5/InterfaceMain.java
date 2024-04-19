package poly.ex5;

import poly.ex1.Animal;

public class InterfaceMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundAniaml(dog);
        soundAniaml(cat);
        soundAniaml(caw);
    }

    private static void soundAniaml(InterfaceAnimal animal) {
        System.out.println("소리");
        animal.sound();
        System.out.println("종료");
    }
}
