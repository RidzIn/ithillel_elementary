package com.ridz;

import java.io.IOException;
import java.util.Arrays;

public class Analytics {

    private final Day[] days = MyFileReader.readFile();

    public Analytics() throws IOException {
    }

    private double phi(int[] arr) {
        return (arr[3] * arr[0] - arr[2] * arr[1]) /
                Math.sqrt((arr[2] + arr[3]) *
                        (arr[0] + arr[1]) *
                        (arr[1] + arr[3]) *
                        (arr[0] + arr[2]));
    }


    private int[] intRepresentation(String event) {
        int[] arr = new int[4];
        for (Day day : days) {
            if (Arrays.asList(day.getEvents()).contains(event) && !(day.isSquirrel())) {
                arr[1] += 1;
            }
            if (Arrays.asList(day.getEvents()).contains(event) && (day.isSquirrel())) {
                arr[3] += 1;
            }
            if (!(Arrays.asList(day.getEvents()).contains(event)) && (day.isSquirrel())) {
                arr[2] += 1;
            }
            if (!(Arrays.asList(day.getEvents()).contains(event)) && !(day.isSquirrel())) {
                arr[0] += 1;
            }
        }
        return arr;
    }

    private String[] arrayOfEvents() {
        String[] arrayOfEvents = new String[90];
        int count = 0;
        for (Day day : days) {
            for (int j = 0; j < day.getEvents().length; j++) {
                if (!(Arrays.asList(arrayOfEvents).contains(day.getEvents()[j]))) {
                    arrayOfEvents[count++] = day.getEvents()[j];
                }
            }
        }
        return Arrays.copyOf(arrayOfEvents, count);
    }

    public void print() {
        String[] arrOfEvents = arrayOfEvents();
        for (String arrOfEvent : arrOfEvents) {
            if (phi(intRepresentation(arrOfEvent)) > 0.1 || phi(intRepresentation(arrOfEvent)) < -0.1)
                System.out.println(arrOfEvent + ":" + String.format("%.5f", phi(intRepresentation(arrOfEvent))));
        }
    }
}
