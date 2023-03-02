package algorithms.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @className: InsertionSort
 * @description: 插入排序
 * @author: Miluo
 * @date: 2023/3/2
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(0, 10).map(x -> {
            Random random = new Random();
            return random.nextInt(100);
        }).toArray();
        System.out.println(Arrays.toString(arr));

        insertionSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param a 数组
     * @param n 数组大小
     */
    private static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i -1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
