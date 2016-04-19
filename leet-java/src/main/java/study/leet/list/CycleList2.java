package study.leet.list;


public class CycleList2 {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		
		while ((fast != slow) && (fast != null) && (fast.next != null)) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast == slow) {
			return slow;
		}
        return null;
    }
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node;
		CycleList2 cycle = new CycleList2();
		System.out.println(cycle.detectCycle(node).val);
	}
}
