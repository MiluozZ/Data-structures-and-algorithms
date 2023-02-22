package algorithms.sort;

import java.util.Arrays;

import java.util.Random;
import java.util.stream.IntStream;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(0, 10).map(x -> {
            Random random = new Random();
            return random.nextInt(100);
        }).toArray();
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (j > arr.length) {
                    return;
                }
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
