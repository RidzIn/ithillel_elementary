package homework_32;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> list = fillList();
        printResult(resultList(deleteCopies(deletePunctuationMarks(list))));

    }

    public static List<String> fillList() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("/Users/danieldorofeev/IdeaProjects/classes/src/homework_32/text.txt"));

        List<String> list = new ArrayList<>();
        String line;
        while ((line = bf.readLine()) != null) {
            String[] subStr = line.split(" ");
            list.addAll(Arrays.asList(subStr));
        }
        return list;
    }

    private static List<String> deletePunctuationMarks(List<String> list) {
        return list.stream()
                .map(str -> str.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", ""))
                .collect(Collectors.toList());
    }

    private static List<String> deleteCopies(List<String> list) {
        return list.stream()
                .map(str -> str.toLowerCase(Locale.ROOT))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> resultList(List<String> list) {
        ArrayList<String> subList = new ArrayList<>();
        StringBuilder subString = new StringBuilder();


        for (int i = 1; i < list.size()-1; i++) {

            subString.append(list.get(i)).append(" ");

            if(list.get(i).charAt(0) != list.get(++i).charAt(0)){
                subList.add(subString.toString());
                subString = new StringBuilder();

            }
            if(i == list.size()-1){
                subList.add(list.get(i));
            }
            i--;
        }
        return subList;
    }

    private static void printResult(List<String> list){
        for(String str : list){
            System.out.println(str);
        }
    }
}
