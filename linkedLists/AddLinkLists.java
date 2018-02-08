package linkedLists;
/*Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807*/

class ListNode {
    int val;
    ListNodes next;
    ListNode(int x) { 
      val = x; 
      next = null;
    }
}

public class AddLinkLists {
	public ListNodes addTwoNumbers(ListNodes l1, ListNodes l2) {
        
        ListNodes result = null, temp = null, prev = null;
        int sum, carry = 0;
        
        while(l1 != null || l2 != null) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            
            temp = new ListNodes(sum);
            
            if(result == null) {
                result = temp;
            } else {
                prev.next = temp;   
            }
            prev = temp;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry > 0) {
            temp = new ListNodes(carry);
			prev.next = temp;
        }
        
        return result;
    }
}
