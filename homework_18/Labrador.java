package homework_18;

public class Labrador extends Dog{
    private String color;
    private static int breedWeight = 75;
    public Labrador(String name,String color) {
        super(name);
        this.color = color;
    }
    @Override
    public String speak(){
        return "WOOF";
    }
    @Override
    public int avgBreedWeight(){
        return breedWeight;
    }
    /*
    Переобпределил метод avgBreedWeight().
    В конструкторе добавил super(name) - так как у меня нет конструктора по умолчанию в классе родителе.
    */
}
