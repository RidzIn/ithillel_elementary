package task14;

public class Main {
    public static void main(String[] args) {

    }
}

class A {
    int a;
    class B {
        int b = A.this.a;
    }
}

class C {
    static int c;
     class D{
        int c = C.c;
    }
}
