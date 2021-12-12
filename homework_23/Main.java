package homework_23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listArray = addStringToArrayList(10);
        System.out.println(listArray);

        LinkedList<String> listLink = addStringToLinkedList(10);
        System.out.println(listLink);

        // printTaskThee(listArray, listLink);
        printTaskFour(listArray, listLink);
    }

    public static ArrayList<String> addStringToArrayList(int count) {
        ArrayList<String> listArray = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            listArray.add("ar_" + i);
        }
        return listArray;
    }

    public static LinkedList<String> addStringToLinkedList(int count) {
        LinkedList<String> listLink = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            listLink.add(randomNumber(i), "li_" + i);
        }
        return listLink;
    }

    private static int randomNumber(int maxValue) {
        return (int) (Math.random() * (maxValue));
    }

    public static void printTaskThee(ArrayList<String> listArray, LinkedList<String> listLink) {
        ListIterator<String> listIterator = listArray.listIterator(listArray.size());
        int count = 0;
        while (listIterator.hasPrevious()) {
            listLink.add(count, listIterator.previous());
            count += 2;
        }
        System.out.println(listLink);
    }

    public static void printTaskFour(ArrayList<String> listArray, LinkedList<String> listLink) {

        ListIterator<String> listIterator = listArray.listIterator(listArray.size());

        int count = 0;
        while (listIterator.hasPrevious()) {
            if (listLink.size() > 14) {
                listLink.addLast(listIterator.previous());
            } else {
                listLink.add(count, listIterator.previous());
                count += 3;
            }
        }
        System.out.println(listLink);
    }
}
