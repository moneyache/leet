package study.leet.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CopyRanList {

	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
			return null;
		}
        RandomListNode copyHead = new RandomListNode(head.label);
        RandomListNode copyIter = copyHead;
        Map<RandomListNode, RandomListNode> record = new HashMap<>();
        record.put(head, copyHead);
        while (head != null) {
			if (head.next != null) {
				RandomListNode copyNext = record.get(head.next);
				if (copyNext == null) {
					copyNext = new RandomListNode(head.next.label);
					record.put(head.next, copyNext);
				}
				copyIter.next = copyNext;
			}
			if (head.random != null) {
				RandomListNode copyRan = record.get(head.random);
				if (copyRan == null) {
					copyRan = new RandomListNode(head.random.label);
					record.put(head.random, copyRan);
				}
				copyIter.random = copyRan;
			}
			head = head.next;
			copyIter = copyIter.next;
		}
        return copyHead;
    }
}
