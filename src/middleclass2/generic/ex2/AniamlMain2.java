package middleclass2.generic.ex2;

import middleclass2.generic.animal.Animal;
import middleclass2.generic.animal.Cat;
import middleclass2.generic.animal.Dog;

public class AniamlMain2 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        animalBox.set(dog);
        animalBox.set(cat);

        Animal findAniaml = animalBox.get();
        System.out.println("findAniaml = " + findAniaml);
    }
}
