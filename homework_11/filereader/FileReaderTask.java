package homework_11.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static homework_11.filereader.MyConstants.FILE_PATH;


public class FileReaderTask {
    private static int countOfLines;
    static {
        try {
            countOfLines = countOfLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String[][] actionArray = new String[countOfLines][];
    public static boolean[] boolArray = new boolean[countOfLines];

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
    }
}

