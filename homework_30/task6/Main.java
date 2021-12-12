package task6;

 class A
{
    static String s = "AAA";

    static void methodA()
    {
        System.out.println(s);
    }

     static class B
    {
        void methodB()
        {
            methodA();
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
