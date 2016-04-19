package study.leet.list;

import leetcode.tree.TreeNode;



public class List2BST {

    public TreeNode sortedListToBST(ListNode head) {
        return recurse(head);
    }
    private TreeNode recurse(ListNode head) {
    	if (head == null) {
			return null;
		}
    	if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		fast = slow.next.next;
		TreeNode root = new TreeNode(slow.next.val);
		slow.next = null;
		root.left = recurse(head);
		root.right = recurse(fast);
		return root;
	}
}
