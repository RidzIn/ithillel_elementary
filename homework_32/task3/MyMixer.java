package ua.ridz.task3;

import java.util.*;

public class MyMixer<T> {
    T[] array;

    public MyMixer(T[] array) {
        this.array = array;
    }

    public T[] shuffle(T[] array){
        Random rd = new Random();

        for (int i = array.length-1; i > 0; i--) {
            int j = rd.nextInt(i+1);
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
