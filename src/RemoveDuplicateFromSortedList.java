
public class RemoveDuplicateFromSortedList {

 //Definition for singly-linked list.
 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
 
	public ListNode deleteDuplicates(ListNode a) {
	    if(a == null){
	        return null;
	    }
	    ListNode node = a, nextNode;
	    while(node!= null && node.next != null) {
	        //System.out.println(node.val);
	        //if(node.val == node.next.val) {
	            while(node.val == node.next.val){
	            if(node.next.next != null) {
	                node.next = node.next.next;
	            } else {
	                node.next = null;
	                break;
	            }
	        }
	        //}
	        node = node.next;
	    }
	    return a;
	}
}

