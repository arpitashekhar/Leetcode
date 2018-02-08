package linkedLists;

public class ReverseList {
	public static ListNodes reverseList(ListNodes head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNodes temp = reverseList(head.next);
        head.next.next = head.next;
        head.next = null;
        return temp;
    }
	
	// non - recursive version
	Node reverse(Node node) {
		if(node == null)
            return null;
        if(node.next == null)
            return node;
		
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
