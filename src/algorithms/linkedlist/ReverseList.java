package algorithms.linkedlist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @className: ReverseList
 * @description: 反转链表
 * @author: Miluo
 * @date: 2023/2/8
 **/
public class ReverseList {

    public static ListNode algorithm(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        List<ListNode> collect = IntStream.rangeClosed(0, 10)
                .mapToObj(ListNode::new)
                .collect(Collectors.toList());
        System.out.println(collect.size());
        ListNode head = collect.get(0);
        for (int i = 0; i < collect.size() - 1 ; i++) {
            collect.get(i).next = collect.get(i + 1);
        }
        print(head);

        ListNode reverse = algorithm(head);
        print(reverse);
    }

    public static void print(ListNode head) {
        do {
            System.out.println(head.val);
            head = head.next;
        } while (head != null);
    }
}
