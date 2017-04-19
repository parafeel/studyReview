package parafeel.pageone;

/**
 * 
 * @author wh-pc
 * @date 2017年4月19日
 * @keywordsGiven a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * 
 * 思路：分割链表+反转链表+合并链表
 */

public class Solution8 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode current = head;
		current.next = new ListNode(2);
		current = current.next;
		current.next = new ListNode(3);
		current = current.next;
		current.next = new ListNode(4);
		current = current.next;
		
		new Solution8().reorderList(head);
	}
	
	public void reorderList(ListNode head) {
		if(head.next.next == null) {
			return;
		}
		ListNode leftBegin = head;
		ListNode rightBegin = this.splitLeftAndRight(head);
		rightBegin = this.sortListNode(rightBegin);
		merge(leftBegin, rightBegin);
    }
	
	public ListNode splitLeftAndRight(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while(p2 !=null && p2.next !=null) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		ListNode rs = p1.next;
		p1.next = null;
		return rs;
	}
	
	public ListNode sortListNode(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = p1.next;
		ListNode p3;
		while (p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			
			p1 = p2;
			p2 = p3;
		}
		head.next = null;
		head = p1;
		return head;
	}
	
	public void merge(ListNode l1,ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode next1,next2 ;
		while(p2 != null) {
			next1 = p1.next;
			next2 = p2.next;
			p1.next = p2;
			p2.next = next1;
			
			p1 = next1;
			p2 = next2;
		}
	}
	
}
