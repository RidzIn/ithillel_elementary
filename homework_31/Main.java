package homework_31;


public class Main {
    public static void main(String[] args) {
        String[] courses = new String[]{"Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes"};

        DataStructure<String> ds = new DataStructure<>(courses);

        ds.printEven();
    }
}
