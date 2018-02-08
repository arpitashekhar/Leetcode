package linkedLists;

import java.util.HashMap;
import java.util.Map;

class Node {
	int value;
	Node next, random;
	
	Node(int value) {
		this.value = value;
		this.next = this.random = null;
	}
}
public class LinkedList {
	private Node head;
	
	public LinkedList(Node node) {
		this.head = node;
	}

	public boolean isEmpty() {
		return (head == null);
	}
	
	public void addFirst(int data) {
		Node new_node = new Node(data);
		new_node = head;
		head = new_node;
	}
	
	public void insertAfter(Node node, int data) {
		if(node == null)
			return;
		
		Node new_node = new Node(data);
		new_node.next = node.next;
		node.next = new_node;
	}
	
	public void addEnd(int data) {
		Node new_node = new Node(data);
		if(head == null) {
			head = new_node;
			return;
		}
		
		new_node = null;
		Node last = head;
		
		while(last.next != null)
			last = last.next;
		
		last.next = new_node;
		return;
	}
	
	public Node getFirst() {
		return head;
	}
	
	public Node getLast() {
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		return last;
	}
	
	public void clear() {
		head = null;
	}
	
	public boolean contains(Node node) {
		if(head == null)
			return false;
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
			if(temp.equals(node))
				return true;
		}
		return false;
	}
	
	public void deleteAt(int index) {
		if(head == null)
			return;
		Node temp = head;
		if(index == 0)
			head = temp.next;
		
		for(int i = 0; i < index - 1 && temp != null; i++) {
			temp = temp.next;
		}
		
		if(temp == null || temp.next == null) 
			return;
		
		Node next = temp.next.next;
		temp.next = next;
	}
	
	public LinkedList clone() {
		Node origCurr = this.head, cloneCurr = null;
		Map<Node, Node> map = new HashMap<Node, Node>();
 
        while (origCurr != null) {
            cloneCurr = new Node(origCurr.value);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }
 
        origCurr = this.head;
 
        while (origCurr != null) {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }
 
        return new LinkedList(map.get(this.head));
	}
}
