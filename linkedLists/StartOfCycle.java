package linkedLists;

public class StartOfCycle {
	public ListNodes detectCycle(ListNodes head) {
	    if(head == null || head.next == null) {
            return null;
        }

        ListNodes fast = head;
        ListNodes slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                slow = head;
                while(slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
	}
}
