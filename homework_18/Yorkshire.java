package homework_18;

public class Yorkshire extends Dog{
    private int weight = 8;

    public Yorkshire(String name) {
        super(name);
    }

    public String speak(){
        return "woof";
    }

    @Override
    public int avgBreedWeight() {
        return weight;
    }
    /*
    Переопределал метод avgBreedWeight()
    Добавил локальную переменную weight
     */
}
