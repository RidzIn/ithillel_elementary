package homework_39;


public class Foo5 {
    public void run(){
        throw new IllegalStateException("This method should not be called");
    }

    public void initialize(){
        System.out.println("Class Foo5 initialized!");
    }
}
