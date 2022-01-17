package ua.ridz.task1;

import java.util.Comparator;

public class MyTestMethod<T extends Number,V extends Number> implements Comparator<Number> {
    public int calcNum(T[] arr, V value) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += compare(arr[i], value);
        }
        return count;
    }

    public double calcSum(T[] arr, V value) {
        double sum = 0.0;
        for (T t : arr) {
            if (compare(t, value) > 0) {
                sum += t.doubleValue();
            }
        }
        return sum;
    }



    @Override
    public int compare(Number o1, Number o2) {

        if (o1.doubleValue() > o2.doubleValue()) {
            return 1;
        } else {
            return 0;
        }
    }
}
