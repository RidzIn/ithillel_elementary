package homework_17;

public class AnimalFactory {


    public static Animal getAnimaByKey(String key) {
        switch (key) {
            case "da":
                return new Dog("Арамис");
            case "db":
                return new Dog("Блек");
            case "dc":
                return new Dog("Спайки");
            case "ca":
                return new Cat("Амадей");
            case "cb":
                return new Cat("Барсик");
            case "cc":
                return new Cat("Снежок");
            default:
                return null;
        }

    }


    private static boolean isKeyExist(String key) {
        String[] keyArray = new String[]{"da", "db", "dc", "ca", "cb", "cc"};
        for (String s : keyArray) {
            if (s == key) {
                return true;
            }
        }
        return false;
    }
}
