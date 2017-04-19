package parafeel.pageone;

/**
 * 
 * @author wh-pc
 * @date 2017年4月19日
 * @keywords Sort a linked list using insertion sort.
 * 用插入排序链表
 */

public class Solution5 {
	
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode root  = new ListNode(0);
		root.next = head;
		ListNode before = head;
		ListNode after;
		ListNode current;
		while(before !=null && before.next != null) {
			if(before.val <= before.next.val) {
				before = before.next;
			} else {
				after = before.next;
				before.next = before.next.next;
				current = root;
				while(current.next.val < after.val) {
					current = current.next;
				}
				after.next = current.next;
				current.next = after;
			}
		}
		return root.next;
    }
}
