package task13;
class ABC
{
    int i = 10101;

    {
        i--;
    }

    public ABC()
    {
        --i;
    }

    class XYZ
    {
        int i = this.i;

        {
            i++;
        }

        public XYZ()
        {
            ++i;
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        ABC abc = new ABC();

        System.out.println(abc.i);

        ABC.XYZ xyz = abc.new XYZ();

        System.out.println(xyz.i);

        ABC.XYZ xyz1 = new ABC().new XYZ();

        System.out.println(xyz1.i);


        System.out.println();
    }
}
