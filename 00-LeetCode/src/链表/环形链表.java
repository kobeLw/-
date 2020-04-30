package 链表;

public class 环形链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(3);
		node.next = new ListNode(2);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(-4);
		node.next.next.next.next = new ListNode(2);
		
//		ListNode node = new ListNode(1);
//		node.next = new ListNode(2);
//		node.next.next = new ListNode(1);
		
		
		
		环形链表 test = new 环形链表();
		System.out.println(test.hasCycle(node));
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

}
