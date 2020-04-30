package 链表;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author yitong
 * 
 */
public class 删除链表的节点 {

	public ListNode deleteNode(ListNode head, int val) {
		if (head.val == val) {
			return head;
		}
		ListNode preNode = head;
		ListNode currentNode = preNode.next;
		while (true) {
			if (currentNode.val == val) {
				preNode.next = currentNode.next;
				return preNode;
			}
			preNode.next = currentNode;
			currentNode = currentNode.next;
		}
		
    }
}
