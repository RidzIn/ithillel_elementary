package task22;

public class Main {
    public static void main(String[] args) {
        int a = new OuterClass.InnerClass().i;
    }
}

class OuterClass
{
    static class InnerClass
    {
        int i;
    }
}
