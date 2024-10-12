package middleclass2.generic.test.ex5;

import middleclass2.generic.animal.Animal;
import middleclass2.generic.animal.Cat;
import middleclass2.generic.animal.Dog;

public class WildcardMain1 {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));
        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);

        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);

        catBox.set(new Cat("냐옹이", 100));
        Cat cat = (Cat) WildcardEx.printAndReturnWildcard(catBox);
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);
    }
}
