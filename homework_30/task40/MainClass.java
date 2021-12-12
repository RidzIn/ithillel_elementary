package task40;

public class MainClass {
    public static void main(String[] args) {
        new A().new B().methodB();
    }
}

class A {
    static String name = "WRLD";
    class B{
        void methodB(){
            System.out.println(name);
        }

    }
}
