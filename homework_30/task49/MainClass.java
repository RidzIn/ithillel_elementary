package task49;

interface X
{
    void methodOne(String s);

    void methodTwo(String s);
}

abstract class Y implements X
{
    String s = "ONE";

    public void methodOne(String s)
    {
        System.out.println(this.s+s);
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        X x = new Y()
        {
            {
                s = s + s;
            }

            public void methodTwo(String s)
            {
                System.out.println(this.s+s);
            }
        };

        x.methodOne("1");

        x.methodTwo("2");
    }
}
