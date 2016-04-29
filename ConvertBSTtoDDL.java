/**
*pre is the rightmost end of DDL,head is the leftmost end of DDL
*/
import java.util.Stack;
public class Solution{
	public TreeNode bstToLL(TreeNode root){
		TreeNode pre=null;
		TreeNode curr=root;
		TreeNode head=null;
		Stack<TreeNode> stack=new Stack<>();
		while(!stack.empty()||curr!=null){
			if(curr!=null){
				stack.push(curr);
				curr=curr.left;
			}else{
				curr=stack.pop();
				//record head
				if(pre==null){
					head=curr;
				}
				//edit left pointer of curr and right pointer of pre
				curr.left=pre;
				if(pre!=null){
					pre.right=curr;
				}
				pre=curr;
				curr=curr.right;
			}
		}
		return head;

	}
	public static void main(String[] args){
		Solution s=new Solution();
		TreeNode root=new TreeNode(15);
		root.left=new TreeNode(10);
		root.right=new TreeNode(20);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(12);
		root.right.left=new TreeNode(17);
		root.right.right=new TreeNode(21);
		TreeNode res=s.bstToLL(root);
		while(res!=null){
			System.out.println(res.val);
			res=res.right;
		}
		
	}
}
