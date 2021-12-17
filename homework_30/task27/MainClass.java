package task27;


class ABC
{
    class XYZ
    {
        String s = "Inner - XYZ";
        {
            System.out.println(s);
        }

    }
}

class XYZ extends ABC
{
    String s = "Outer - XYZ";

    {
        System.out.println(s);
    }

    class ABC extends XYZ
    {

    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new XYZ().new ABC();
    //   System.out.println(new XYZ().new ABC().s);
    }
}
