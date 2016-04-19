package study.leet.list;


public class PartionList {

    public ListNode partition(ListNode head, int x) {
    	if (head == null) {
			return null;
		}
    	ListNode iter = head;
    	ListNode lesser = null;
    	ListNode lesserIter = null;
    	ListNode greater = null;
    	ListNode greaterIter = null;
    	while (iter != null) {
			if (iter.val >= x) {
				if (greater == null) {
					greater = iter;
					greaterIter = iter;
				}
				else {
					greaterIter.next = iter;
					greaterIter = greaterIter.next;
				}
			}
			else {
				if (lesser == null) {
					lesser = iter;
					lesserIter = iter;
				}
				else {
					lesserIter.next = iter;
					lesserIter = lesserIter.next;
				}
			}
			iter = iter.next;
		}
    	if (lesser == null) {
			return greater;
		}
    	if (greater == null) {
			return lesser;
		}
    	lesserIter.next = greater;
    	if (greaterIter.next != null) {
			greaterIter.next = null;
		}
        return lesser;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		PartionList partionList = new PartionList();
		head = partionList.partition(head, 3);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
