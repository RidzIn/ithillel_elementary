package ua.ridz.task3;

import java.util.Arrays;

public class Runner {
    public void run(){
        System.out.println("Coled runner from Task_3");

        String[] arrayOfStrings = new String[]{"A","B","C","D","F"};
        Integer[] arrayOfIntegers = new Integer[]{1,2,3,4,5};

        MyMixer<String> myMixer1 = new MyMixer<>(arrayOfStrings);
        MyMixer<Integer> myMixer2 = new MyMixer<>(arrayOfIntegers);

        System.out.println(Arrays.toString(myMixer1.shuffle(arrayOfStrings)));
        System.out.println(Arrays.toString(myMixer2.shuffle(arrayOfIntegers)));

    }
}
