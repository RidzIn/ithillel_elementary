package homework_18;

public abstract class Dog {
    protected String name;

    public Dog(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String speak(){
        return "Woof";
    }

    public abstract int avgBreedWeight();

    /*
    Добавил абскратный метод avgBreedWeight().
    Сделал класс Dog так же абстрактным.
     */
}
