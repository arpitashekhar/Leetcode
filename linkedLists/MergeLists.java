package linkedLists;
class ListNode1 {
      int val;
      ListNode1 next;
      ListNode1(int x) { val = x; }
 }
public class MergeLists {
	ListNode1 head;
	
	public static ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        // ListNode result = new ListNode(0);
        if(l1 == null)	return l2;
        if(l2 == null)	return l1;  
        
        if(l1.val < l2.val) {
        	l1.next = mergeTwoLists(l1.next, l2);
        	return l1;
        } else {
        	l2.next = mergeTwoLists(l2.next, l1);
        	return l2;
        }
    }
	
	public static void main(String args[]) {
		ListNode1 l1 = new ListNode1(5);
		ListNode1 l2 = new ListNode1(2);
		l1.next = new ListNode1(5);
		l2.next = new ListNode1(4);
		System.out.println(mergeTwoLists(l1, l2).val);
	}
}
