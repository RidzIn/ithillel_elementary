package homework_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static homework_03.MyConstants.FILE_PATH;


public class FileReaderTask {
    static String[][] actionArray;

    static {
        try {
            actionArray = new String[countOfLines()][];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean[] boolArray;

    static {
        try {
            boolArray = new boolean[countOfLines()];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static int countOfLines() throws IOException {
        return (int) Files.lines(Path.of(FILE_PATH)).count();
    }

    public static void readFile() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH));
        int counter = 0;
        String line;
        String[] tempLine;

        while ((line = bf.readLine()) != null) {
            tempLine = line.split(",");
            actionArray[counter] = Arrays.copyOf(tempLine, tempLine.length - 1);
            boolArray[counter++] = Boolean.parseBoolean(tempLine[tempLine.length - 1]);
        }
        printActionArray();
    }

    public static void printActionArray() {
        for (int i = 0; i < actionArray.length; i++) {
            for (int j = 0; j < actionArray[i].length; j++) {
                if (j != actionArray[i].length - 1) {
                    System.out.print(actionArray[i][j] + ", ");
                } else {
                    System.out.println(actionArray[i][j]);
                    System.out.println(boolArray[i]);
                }
                System.out.println();
            }
        }
    }
}

