package task11;

class X
{
    {
        System.out.println(1);
    }

    static
    {
        System.out.println(2);
    }

    public X()
    {
        new Y();
        new Y();
        new Y();
        new Y();
        new Y();
    }

    static class Y
    {

        {
            System.out.println(3);
        }

        static
        {
            System.out.println(4);
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        X x = new X();

        X.Y y = new X.Y();
    }
}
