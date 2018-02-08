package linkedLists;
class ListNodes {
	 int val;
	 ListNodes next;
	 ListNodes(int x) {
		 val = x;
		 next = null;
	 }
}
public class RemoveCycle {
	public ListNodes detectCycle(ListNodes head) {
        ListNodes fast = head, slow = head, result = null;
        if(head == null || head.next == null)
            return null;
        
        while(fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                result = removeCycle(slow, head);
                break;
            }
        }
        
        return result;
    }
    public ListNodes removeCycle(ListNodes slow, ListNodes head) {
        ListNodes fast = head;
        if(slow == fast)
            return fast;
        while(fast != null && slow != null && fast.next != null && slow.next != null) {
            if(fast.next == slow.next) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
            
        }
        return fast.next;
    }
}
