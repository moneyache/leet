package study.leet.list;

public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		ListNode res = mergeList(sortList(head), sortList(fast));
		return res;
	}
	public ListNode mergeList(ListNode head1, ListNode head2) {
		
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode head = new ListNode(100);
		ListNode preIter = head;
		
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				preIter.next = copyOf(head1);
				head1 = head1.next;
				preIter = preIter.next;
			}
			else {
				preIter.next = copyOf(head2);
				head2 = head2.next;
				preIter = preIter.next;
			}
		}
		while (head2 != null) {
			preIter.next = copyOf(head2);
			head2 = head2.next;
			preIter = preIter.next;
		}
		while (head1 != null) {
			preIter.next = copyOf(head1);
			head1 = head1.next;
			preIter = preIter.next;
		}
		return head.next;
	}
	private ListNode copyOf(ListNode node) {
		return new ListNode(node.val);
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(19);
		ListNode node7 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		SortList sortList = new SortList();
		ListNode head = sortList.sortList(node1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		/*ListNode test = new ListNode(0);
		ListNode test2 = new ListNode(2);
		ListNode test1 = null;
		test.next = test1;
		test1 = test2;
		while (test != null) {
			System.out.println(test.val);
			test = test.next;
		}*/
	}
}
