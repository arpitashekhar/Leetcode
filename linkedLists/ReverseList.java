package linkedLists;

public class ReverseList {
	public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode temp = reverseList(head.next);
        head.next.next = head.next;
        head.next = null;
        return temp;
    }
}
