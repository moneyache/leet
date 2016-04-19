package study.leet.list;

public class RemoveDup {

    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null) {
			return head;
		}
        int curVal = head.val;
        ListNode iter = head.next;
        ListNode preIter = head;
        while (iter != null) {
			if (iter.val == curVal) {
				preIter.next = iter.next;
			}
			else {
				curVal = iter.val;
				preIter = preIter.next;
			}
			iter = iter.next;
		}
    	return head;
    }
    public static void main(String[] args) {
		
	}
}
