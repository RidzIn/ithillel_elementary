package task15;

class P
{
    String s = "PPP";

    {
        System.out.println(s);
    }

    String methodP()
    {
        class Q
        {
            String s = P.this.s+"QQQ";

            {
                System.out.println(s);
            }
        }

        return new Q().s+s;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        P p = new P();

        System.out.println(p.methodP());
    }
}
