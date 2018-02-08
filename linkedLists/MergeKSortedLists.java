package linkedLists;

public class MergeKSortedLists {
	public ListNodes mergeKLists(ListNodes[] lists) {
        if(lists == null || lists.length == 0)  return null;
        return mergeSort(lists, 0, lists.length - 1);
    }
    
    public ListNodes mergeSort(ListNodes[] lists, int low, int high) {
        if(low >= high) return lists[low];
        int mid = (high - low) / 2 + low;
        ListNodes l1 = mergeSort(lists, low, mid);
        ListNodes l2 = mergeSort(lists, mid + 1, high);
        return merge(l1, l2);
    }
    
    public ListNodes merge(ListNodes l1, ListNodes l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        if(l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } 
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
