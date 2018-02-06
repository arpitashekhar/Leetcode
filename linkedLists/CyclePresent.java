package linkedLists;
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { 
      val = x; 
      next = null;
    }
}
public class CyclePresent {
	public boolean hasCycle(ListNode2 head) {
        if(head == null || head.next == null)
            return false;
        ListNode2 slow = head, fast = head;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}
