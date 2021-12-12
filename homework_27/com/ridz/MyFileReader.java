package com.ridz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class MyFileReader {
    static final String filePath = "/Users/danieldorofeev/Desktop/homework_27/src/main/java/com/ridz/journalEvents.txt";

    public static int countOfLines() throws IOException {
        return (int) Files.lines(Path.of(filePath)).count();
    }

    public static Day[] readFile() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        int counter = 0;
        String line;
        String[] tempLine;
        Day[] arrayOfDays = new Day[countOfLines()];

        while ((line = bf.readLine()) != null) {
            tempLine = line.split(",");
            Day day = new Day(Arrays.copyOf(tempLine, tempLine.length - 1), Boolean.parseBoolean(tempLine[tempLine.length - 1]));
            arrayOfDays[counter++] = day;
        }
        return arrayOfDays;
    }
}
