import java.util.HashMap;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		this.val=x;
	}
}

public class Solution{
	public TreeNode construct(TreeNode root){
		HashMap<TreeNode,TreeNode> map=new HashMap<>();
		map.put(root,new TreeNode(root.val));
		helper(root,map);
		return map.get(root);
	}
	public void helper(TreeNode root,HashMap<TreeNode,TreeNode> map){
		if(root==null){
			return;
		}
		TreeNode tmp=map.get(root);
		if(root.left!=null){
			tmp.right=new TreeNode(root.left.val);
			map.put(root.left,tmp.right);
		}
		if(root.right!=null){
			tmp.left=new TreeNode(root.right.val);
			map.put(root.right,tmp.left);
		}
		helper(root.left,map);
		helper(root.right,map);
	}

	public static void main(String[] args){
		Solution s=new Solution();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		TreeNode res=s.construct(root);
		System.out.println(res.right.right.val);
	}
}
