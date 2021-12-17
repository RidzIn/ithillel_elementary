package task23;

public class Main {
    public static void main(String[] args) {

        A.B b = new A().new B();
    }
}

class A {
    static int a = 10;
    class B {
        {
            System.out.println(a);
        }
    }
}
