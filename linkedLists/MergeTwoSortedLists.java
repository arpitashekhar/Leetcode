package linkedLists;

public class MergeTwoSortedLists {
	public ListNodes mergeTwoLists(ListNodes l1, ListNodes l2) {
        ListNodes node = new ListNodes(0);
        ListNodes head = node;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if(l1 != null) {
            head.next = l1;
        }
        if(l2 != null) {
            head.next = l2;
        }
        
        return node.next;
    }
}
