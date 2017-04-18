package parafeel.pageone;

/**
 * 
 * @author wh-pc
 * @date 2017年4月18日
 * @keywords Sort a linked list in O(n log n) time using constant space
 *           complexity.
 * 
 *           对一个链表进行排序，要求时间复杂度为O（nlogn）
 */

public class Soliton4 {
	/**
	 * 使用堆排序，利用递归进行堆排序。堆排序就是将数据分为 若干个堆，对每个堆进行排序，排序之后再合并。
	 * 对于链表的思路是，把链表分成左右两部分，对两部分进行排序。进这两部分的左右两部分，
	 * 分别继续对左右两部分进行排序，递归进行到最低的堆，排序之后再与其旁边的堆合并，合并 之后再合并。 10 4 6 3 8 5 2 7 分为两堆
	 * (10 4 6 3 ) (8 5 2 7 )再各自分为两堆 （10 4） （6 3） （8 5） （2 7）最后在各自分堆 （10） （4 ）
	 * （6） (3) (8) (5) (2) (7 )，再对相邻两堆进行排序得： 4 10 3 6 5 8 2 7，之后对相邻两堆进行合并： (4
	 * 10) (3 6) (5 8) (2 7) ，再对相邻两堆合并 (3 4 6 10 ) (2 4 7 8)，再对相邻两堆合并 2 3 4 4 6
	 * 7 8 10
	 * 
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = this.findMiddle(head);
		ListNode right = sortList(middle.next);
		middle.next = null;
		ListNode left = sortList(head);
		return this.mergeList(left, right);
	}

	public ListNode findMiddle(ListNode head) {
		ListNode slower = head;
		ListNode faster = head.next;
		while (faster != null && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;
		}
		return slower;
	}

	public ListNode mergeList(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode before = new ListNode(Integer.MIN_VALUE);
		ListNode head = before;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1 == null) {
			head.next = l2;
		}
		if (l2 == null) {
			head.next = l1;
		}
		return before.next;
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