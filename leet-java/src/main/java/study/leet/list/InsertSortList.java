package study.leet.list;


	public class InsertSortList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode result = new ListNode(head.val);
		while (head.next != null) {
			ListNode index = new ListNode(head.next.val);
			result = insert(result, index);
			head = head.next;
		}
        return result;
    }
	public ListNode insert(ListNode list, ListNode toInsert) {
		if (list == null) {
			return toInsert;
		}
		ListNode iter = list;
		ListNode pre = new ListNode(100);
		ListNode tempPre = pre;
		pre.next = list;
		while (iter != null) {
			if (iter.val > toInsert.val) {
				toInsert.next = iter;
				pre.next = toInsert;
				return tempPre.next;
			}
			pre = pre.next;
			iter = iter.next;
		}
		if (iter == null) {
			pre.next = toInsert;
		}
		return tempPre.next;
	}
	public static void main(String[] args) {
		InsertSortList sortList = new InsertSortList();
		ListNode node1 = new ListNode(1);
		node1.next =new ListNode(4);
		node1.next.next = new ListNode(9);
		node1.next.next.next = new ListNode(5);
		node1.next.next.next.next = new ListNode(3);
		//ListNode node = new ListNode(5);
		//ListNode noden = sortList.insert(node1, node);
		ListNode noden = sortList.insertionSortList(node1);
		while (noden != null) {
			System.out.println(noden.val);
			noden = noden.next;
		}
	}
}
