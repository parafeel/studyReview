package leetcode;

/**
 * 
 * @author Administrator
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:Can you solve it without using extra space?
 * 给定一个链表，判断其是否有环
 */

public class Solution10 {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next!= null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return true;
			}
		}
		return false;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}