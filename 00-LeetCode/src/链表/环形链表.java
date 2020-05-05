package 链表;

public class 环形链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		
//		ListNode node = new ListNode(1);
//		node.next = new ListNode(2);
//		node.next.next = new ListNode(1);
		
		
		
		环形链表 test = new 环形链表();
//		System.out.println(test.hasCycle(node));
//		System.out.println(test.mergeTwoLists(node, node1).next.next);
	}
	
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
	        return false;
	    }
		ListNode slowNode = head;
		ListNode fastNode = head.next;
		while (slowNode != fastNode) {
			if (slowNode == null || fastNode == null) {
				return false;
			}
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return true;
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode last = head;
		
		
		return false;
    }

}
