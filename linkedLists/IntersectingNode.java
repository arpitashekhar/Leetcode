package linkedLists;

public class IntersectingNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int size1 = 1, size2 = 1;
		ListNode current = headA;
		
		while(current != null && current.next != null) {
			size1++;
			current = current.next;
		}
		ListNode eol1 = current;
		current = headB;
		while(current != null && current.next != null) {
			size2++;
			current = current.next;
		}
		
		if(current != eol1)
			return null;
		
		int diff;
		ListNode longListNode, shortListNode;
		if(size1 < size2) {
			diff = size2 - size1;
			longListNode = headB;
			shortListNode = headA;
		} else {
			diff = size1 - size2;
			longListNode = headA;
			shortListNode = headB;
		}
		
		for(int i = 0; i != diff; i++) {
			longListNode = longListNode.next;
		}
		
		while(longListNode != null) {
			if(longListNode == shortListNode)
				return shortListNode;
			shortListNode = shortListNode.next;
			longListNode = longListNode.next;
		}
		return null;
    }
}
