
public class AddTwoNumbersAsList {

  //Definition for singly-linked list.
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    ListNode aNode = a, bNode = b;
	    ListNode newHead = new ListNode(0);
	    ListNode newNode = newHead;
	    int countA = 1, countB = 1, minCount;
	    while(aNode.next != null) {
	        aNode = aNode.next;
	        countA++;
	    }
	    while(bNode.next != null) {
	        bNode = bNode.next;
	        countB++;
	    }
	    //System.out.println(bNode.val);
	    aNode = a; 
	    bNode = b;
	    int carry = 0;
	    minCount = (countA < countB) ? countA : countB;
	    for(int i = 0; i < minCount; i++) {
	        newNode.next = new ListNode((aNode.val + bNode.val + carry) % 10);
	        carry = (aNode.val + bNode.val + carry) / 10;
	        aNode = aNode.next;
	        bNode = bNode.next;
	        newNode = newNode.next;
	    } 
	    if(countA < countB) {
	        for(int i = 0; i < (countB - countA); i++) {
	            newNode.next = new ListNode((carry + bNode.val) %10);
	             carry = (bNode.val + carry) / 10;
	             newNode = newNode.next;
	             bNode = bNode.next;
	             //System.out.println(bNode.val);
	        }
	    } else if(countA > countB) {
	        for(int i = 0; i < (countA - countB); i++) {
	        newNode.next = new ListNode((carry + aNode.val) %10);
	         carry = (aNode.val + carry) / 10;
	         aNode = aNode.next;
	         newNode = newNode.next;
	        }
	    }  
	    if(carry != 0){
	        newNode.next = new ListNode(carry);
	    }
	    //newNode.next = (countA < countB) ? new ListNode(carry + bNode.val) : new ListNode(carry + aNode.val);
	    return newHead.next;
	}
	
}

