package ua.ridz.task1;

public class Runner {
    public void run(){
        System.out.println("Coled runner from Task_1");
        MyTestMethod<Integer,Integer> myTestMethod1 = new MyTestMethod<>();
        MyTestMethod<Double,Double> myTestMethod2 = new MyTestMethod<>();

        Integer[] arrOfInts = new Integer[]{1,2,3,4,5};
        Double[] arrOfDoubles = new Double[]{1.0,2.0,3.0,4.0,5.0};

        System.out.println(myTestMethod1.calcNum(arrOfInts,2));
        System.out.println(myTestMethod2.calcNum(arrOfDoubles, 3.9));
        System.out.println("------------------");
        System.out.println(myTestMethod1.calcSum(arrOfInts,2));
        System.out.println(myTestMethod2.calcSum(arrOfDoubles, 3.9));

    }
}
