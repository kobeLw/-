package 二叉树;

import java.util.ArrayList;
import java.util.List;

import com.test.test;

public class 翻转二叉树 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(2);
		node.right.left = new TreeNode(3);
		
		翻转二叉树 test = new 翻转二叉树();
		System.out.println(test.preorderTraversal(node).toString());
		
	}
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) {
			return null;
		}
        
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
	
	List<Integer> list = new ArrayList();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        
        TreeNode node = root;
//        System.out.println(root.val);
        while (node != null) {
            if (node.left != null) {
				list.add(node.val);
			}
        }
        

        return list;
    }
}
