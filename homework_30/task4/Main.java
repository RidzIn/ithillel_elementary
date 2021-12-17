package task4;

public class Main {
    public static void main(String[] args) {
        System.out.println(new ABC().new XYZ().i);
    }
}
class ABC{
      class XYZ {
         int i = 111;
    }
}
