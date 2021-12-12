package homework_17;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "Я кошка меня зовут -  " + super.getName() + ".";
    }
}
