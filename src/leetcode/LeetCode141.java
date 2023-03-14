package leetcode;

import algorithms.linkedlist.ListNode;

import java.util.HashSet;

/**
 * @className: LeetCode141
 * @description:给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。
 * 仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 来源：力扣（LeetCode）
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Miluo
 * @date: 2023/3/14
 **/
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<ListNode>();
        set.add(head);
        while (head.next != null) {
            ListNode curr = head.next;
            if(set.contains(curr)) {
                return true;
            }else {
                set.add(curr);
            }
            head = head.next;
        }
        return false;
    }

}
