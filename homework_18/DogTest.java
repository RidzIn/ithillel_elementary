package homework_18;

public class DogTest {
    public static void main(String[] args) {
      //  Dog dog = new Dog("Spike");
      //  System.out.println(dog.getName() + " says " + dog.speak());

        Dog dog2 = new Labrador("Bob", "RED");
        System.out.println(dog2.getName() + " says " + dog2.speak());
        System.out.println(dog2.avgBreedWeight());

        Dog dog3 = new Yorkshire("Mike");
        System.out.println(dog3.getName() + " says " + dog3.speak());
        System.out.println(dog3.avgBreedWeight());

        /*
        Объект класса Dog создавать нельзя, так как он является абстрактным.
         */
    }
}
