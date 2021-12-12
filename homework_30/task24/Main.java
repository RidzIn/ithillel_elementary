package task24;

public class Main {
    public static void main(String[] args) {

    }
}

class A
{
    class B
    {

    }
}

class C extends A.B {
    public C(){
        new A().super();
    }
}
