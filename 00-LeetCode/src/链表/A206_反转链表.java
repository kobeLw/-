package 链表;

public class A206_反转链表 {
	
	/*
	 * 方法一
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
		ListNode node = head.next;
		ListNode preNode = head;
		preNode.next = null;
		ListNode afterNode;
		
		while (true) {
			if (node.next == null) {
				node.next = preNode;
                preNode = node;
				return preNode;
			}
			afterNode = node.next;
			node.next = preNode;
			preNode = node;
            node = afterNode;
		}
	}
	*/
	
	/*
	 * 方法二  递归
	public ListNode reverseList(ListNode head) {
        if (head.next == null || head == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
	}
	*/
}
