package algorithms.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: ValidParentheses
 * @description: 有效括号
 * @author: Miluo
 * @date: 2023/2/14
 **/
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "[";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Map<String, String> map = new HashMap<>(3);
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        List<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char sub = s.charAt(i);
            if(map.get(String.valueOf(sub)) != null) {
                list.add(String.valueOf(sub));
            }else {
                if(list.size() == 0) {
                    return false;
                }else {
                    if(!map.get(list.get(list.size() - 1)).equals(String.valueOf(sub))) {
                        return false;
                    }else {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return list.size() == 0;
    }
}
