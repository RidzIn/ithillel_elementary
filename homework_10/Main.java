package homework_10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr10 = randomArray(10);
        int[] arr10000 = randomArray(10000);
        int[] arr1000000 = randomArray(1000000);

        long timeLinear = System.currentTimeMillis();
        System.out.println(linearSearch(arr10, 79));
        System.out.println(linearSearch(arr10000, 89));
        System.out.println(linearSearch(arr1000000, 99));
        System.out.println(System.currentTimeMillis() - timeLinear);

        long timeBinary = System.currentTimeMillis();
        System.out.println(binarSearch(arr10, 79, arr10.length - 1, 0));
        System.out.println(binarSearch(arr10000, 99, arr10.length - 1, 0));
        System.out.println(binarSearch(arr1000000, 89, arr10.length - 1, 0));
        System.out.println(System.currentTimeMillis() - timeBinary);

        long timeQuickSort = System.currentTimeMillis();
        System.out.println(quickSort(arr10, 0, arr10.length - 1));
        System.out.println(quickSort(arr10000, 0, arr10.length - 1));
        System.out.println(quickSort(arr1000000, 0, arr10.length - 1));
        System.out.println(System.currentTimeMillis() - timeQuickSort);

        long timeInsertSort = System.currentTimeMillis();
        System.out.println(insertionSort(arr10));
        System.out.println(insertionSort(arr10000));
        System.out.println(insertionSort(arr1000000));
        System.out.println(System.currentTimeMillis() - timeInsertSort);
    }

    public static String linearSearch(int[] arr, int numberToFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numberToFind) {
                return "The number witch you was looking for at " + i + " index";
            }
        }
        return "The number does not exist in array";
    }

    public static String binarSearch(int[] arr, int numberToFind, int high, int low) {
        Arrays.sort(arr);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < numberToFind) {
                low = mid + 1;
            }
            if (arr[mid] > numberToFind) {
                high = mid - 1;
            }
            if (arr[mid] == numberToFind) {
                return "The number witch you was looking for at " + mid + " index";
            }
        }
        return "The number does not exist in array";
    }

    public static String quickSort(int[] arr, int low, int high) {
        if (arr.length == 0 || low == high) {
            return "";
        }
        int mid = low + (high - low) / 2;
        int midNumber = arr[mid];

        int i = low;
        int j = high;

        while (arr[i] < midNumber) {
            i++;
        }
        while (arr[j] > midNumber) {
            j--;
        }
        if (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
        return Arrays.toString(arr);
    }

    public static String insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int number = arr[i];
            int j = i - 1;
            while (j >= 0 && number < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
                arr[j + 1] = number;
            }
        }
        return Arrays.toString(arr);
    }

    public static int[] randomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}
