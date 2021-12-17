package task29;

class A
{
    {
        System.out.println(1);
    }

    class B
    {
        {
            System.out.println(2);
        }

        class C
        {
            {
                System.out.println(3);
            }
        }
    }

    int method()
    {
        class B
        {
            {
                System.out.println(2);
            }

            class C extends A
            {
                {
                    System.out.println(3);
                }
            }
        }
        return 2;
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}

