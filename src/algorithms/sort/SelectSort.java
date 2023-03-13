package algorithms.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @className: SelectSort
 * @description: 选择排序
 * @author: Miluo
 * @date: 2023/3/13
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(0, 10).map(x -> {
            Random random = new Random();
            return random.nextInt(100);
        }).toArray();
        System.out.println(Arrays.toString(arr));

        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j<= arr.length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int min = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
