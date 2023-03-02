package leetcode;

import java.util.Arrays;

/**
 * @className: LeetCode2418
 * @description:给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * 来源：力扣（LeetCode）
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Miluo
 * @date: 2023/2/22
 **/
public class LeetCode2418 {
    public static void main(String[] args) {
        String[] names = {"Alice","Bob","Bob"};
        int[] heights = {155,185,150};
        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        if(names.length <= 1) {
            return names;
        }
        for(int x = 0; x< names.length; x++) {
            boolean flag = false;
            for(int y = 0; y < names.length - x - 1; y++) {
                if(heights[y] < heights[y+1]) {
                    String temp = names[y];
                    int temp2 = heights[y];
                    names[y] = names[y+1];
                    heights[y] = heights[y+1];
                    names[y+1] = temp;
                    heights[y+1] = temp2;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
        return names;
    }
}
