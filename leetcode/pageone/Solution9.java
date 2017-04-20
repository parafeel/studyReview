package leetcode;
/**
 * 
 * @author 
 * 
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, returnnull.Follow up:
 * Can you solve it without using extra space?
 * 
 * һ�������ҵ�����ʼ�Ľ�㣬���û�л����򷵻�null��
 * ���Բ��ö���Ŀռ�ȥ�����
 *
 */


public class Solution9 {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow ) {
				ListNode p = head ;
				while (slow != p) {
					p = p.next;
					slow = slow.next;
				}
				return p;
			}
		}
		return null;
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