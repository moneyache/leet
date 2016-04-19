package study.leet.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.val).compareTo(o2.val);
			}
		});
		for (ListNode listNode : lists) {
			if (listNode == null) {
				continue;
			}
			queue.add(listNode);
		}
		ListNode res = new ListNode(0);
		ListNode iter = res;
		while (!queue.isEmpty()) {
			ListNode cur = queue.remove();
			ListNode other = cur.next;
			cur.next = null;
			iter.next = cur;
			iter = iter.next;
			if (other != null) {
				queue.add(other);
			}
		}
		return res.next;
	}
	public ListNode merge2List(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode init = new ListNode(0);
		ListNode res = init;
		ListNode pre = res;
		while (head1 != null && head2 != null) {
			if (head1.val > head2.val) {
				pre.next = head2;
				pre = pre.next;
				head2 = head2.next;
			}
			else {
				pre.next = head1;
				pre = pre.next;
				head1 = head1.next;
			}
		}
		if (head1 != null) {
			pre.next = head1;
		}
		if (head2 != null) {
			pre.next = head2;
		}
		return res.next;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.next = node3;
		node3.next = node5;
		node5.next = node7;
		node2.next = node4;
		node4.next = node6;
		MergeKLists mergeKLists = new MergeKLists();
		List<ListNode> list = new ArrayList<ListNode>();
/*		list.add(node1);
		list.add(node2);*/
		list.add(null);
		ListNode res = mergeKLists.mergeKLists(list);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
