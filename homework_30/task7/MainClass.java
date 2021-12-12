package task7;

abstract class A
{
    {
        System.out.println(1);
    }

    static
    {
        System.out.println(2);
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A() { };
    }
}
