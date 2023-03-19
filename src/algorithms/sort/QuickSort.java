package algorithms.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(0, 10).map(x -> {
            Random random = new Random();
            return random.nextInt(100);
        }).toArray();
        System.out.println(Arrays.toString(arr));

        quickSort(arr,0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        if (low >= high) {
            return;
        }

        int i = low, j = high;
        int pivot = arr[low + (high - low) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }
}
