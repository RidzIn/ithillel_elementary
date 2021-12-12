package homework_11;

import homework_11.filereader.FileReaderTask;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReaderTask.readFile();
        arrayOfEvents();
        print();
    }

    private static double phi(int[] arr) {
        return (arr[3] * arr[0] - arr[2] * arr[1]) /
                Math.sqrt((arr[2] + arr[3]) *
                        (arr[0] + arr[1]) *
                        (arr[1] + arr[3]) *
                        (arr[0] + arr[2]));
    }

    private static int[] intRepresentation(String event) {
        int[] arr = new int[4];
        for (int i = 0; i < FileReaderTask.actionArray.length; i++) {
            if (Arrays.asList(FileReaderTask.actionArray[i]).contains(event) && !(FileReaderTask.boolArray[i])) {
                arr[1] += 1;
            }
            if (Arrays.asList(FileReaderTask.actionArray[i]).contains(event) && (FileReaderTask.boolArray[i])) {
                arr[3] += 1;
            }
            if (!(Arrays.asList(FileReaderTask.actionArray[i]).contains(event)) && (FileReaderTask.boolArray[i])) {
                arr[2] += 1;
            }
            if (!(Arrays.asList(FileReaderTask.actionArray[i]).contains(event)) && !(FileReaderTask.boolArray[i])) {
                arr[0] += 1;
            }
        }
        return arr;
    }

    private static String[] arrayOfEvents() {
        String[] arrayOfEvents = new String[90];
        int count = 0;
        for (int i = 0; i < FileReaderTask.actionArray.length; i++) {
            for (int j = 0; j < FileReaderTask.actionArray[i].length; j++) {
                if (!(Arrays.asList(arrayOfEvents).contains(FileReaderTask.actionArray[i][j]))) {
                    arrayOfEvents[count++] = FileReaderTask.actionArray[i][j];
                }
            }
        }
        return Arrays.copyOf(arrayOfEvents, count);
    }

    private static void print() {
        String[] arrOfEvents = arrayOfEvents();
        for (String arrOfEvent : arrOfEvents) {
            if (phi(intRepresentation(arrOfEvent)) > 0.1 || phi(intRepresentation(arrOfEvent)) < -0.1)
                System.out.println(arrOfEvent + ":" + String.format("%.5f", phi(intRepresentation(arrOfEvent))));
        }
    }
}
