package com.amazon.problems;


class ListNode {
	 		int val;
	 		ListNode next;
	 		ListNode() {}
	 		ListNode(int val) { this.val = val; }
	 		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }



class LinkedList{
	ListNode head = null;
	
	public ListNode add(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	public void print(ListNode h1) {
		ListNode curr = h1;
		while(curr != null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
}

public class LinkedListProblems {
	
	// reverse list
	public static ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	
	// odd-even node
	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) {return head;}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while(even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
	
	// detect cycle
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	// detect cycle
	public static ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) {return null;}
		ListNode slow = head; 
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				ListNode ptr = head;
				while(ptr != slow) {
					ptr = ptr.next;
					slow = slow.next;
				}
				return ptr;
			}
		}
		return null;
	}
	
	// break cycle
	public static void breakCycle(ListNode head) {
		if(head==null || head.next == null) return;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				ListNode ptr = head;
				while(ptr != slow) {
					ptr = ptr.next;
					slow = slow.next;
				}
				ListNode temp = ptr;
				while(temp.next != ptr) {
					temp = temp.next;
				}
				temp.next = null;
				return;
			}
		}
	}
	
	// remove nth node
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || head.next == null) {return null;};
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		for(int i=0; i<=n; i++) {
			fast = fast.next;
		}
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
	
	// maximum twin sum
	public static int pairSum(ListNode head) {
		if(head == null || head.next == null) {return 0;}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode prev = null;
		ListNode next = null;
		while(slow != null) {//current 
			next = slow.next;
			slow.next = prev;
			prev = slow; // prev = current
			slow = next; // current = next
		}
		
		int max = 0;
		ListNode first = head;
		ListNode second = prev;
		while(second != null) {
			max = Math.max(max, first.val + second.val);
			first = first.next;
			second = second.next;
		}
		return max;
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				tail.next = l1;
				l1 = l1.next;
			}else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		// attach remaining
		if(l1 != null) tail.next = l1;
		if(l2 != null) tail.next = l2;
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		ListNode head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode current = head;
		while(current != null) {
			current = current.next;
		}
		ListNode newHead = oddEvenList(head);
		current = newHead;
		while(current != null && current.next != null) {
			current = current.next;
		}
	}

}
