package study.leet.list;



public class ReOrderList {
	public ListNode reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast= head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//fast as the head of the later half
		fast = slow.next;
		//break the pre half with the later half
		slow.next = null;
		//slow as the head of the pre half 
		slow = head;
		//reverse the back half
		fast = reverse(null, fast);
		//merge the pre half and the later half
		while (slow != null && fast != null) {
			ListNode slowThen = slow.next;
			ListNode fastThen = fast.next;
			slow.next = fast;
			slow.next.next = slowThen;
			fast = fastThen;
			slow = slowThen;
		}
		return head;
	}
	public ListNode reverse(ListNode pre, ListNode last) {
		if (last == null) {
			return pre;
		}
		ListNode lastThen = last.next;
		last.next = null;
		last.next = pre;
		return reverse(last, lastThen);
	}
	public static void main(String[] args) {
		ReOrderList orderList = new ReOrderList();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node = orderList.reorderList(node);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
