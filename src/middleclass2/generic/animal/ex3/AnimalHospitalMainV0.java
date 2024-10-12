package middleclass2.generic.animal.ex3;

import middleclass2.generic.animal.Animal;
import middleclass2.generic.animal.Cat;
import middleclass2.generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        dogHospital.set(dog);
        dogHospital.checkUp();

        catHospital.set(cat);
        catHospital.checkUp();

        // 개 병원에 고양이 전달
//        dogHospital.set(parsedCat);

    }
}
