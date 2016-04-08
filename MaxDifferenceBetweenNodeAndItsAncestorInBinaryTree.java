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
	public int maxDiff(TreeNode root){
		HashMap<TreeNode,Integer> map=new HashMap<>();
		helper(root,map);
		int max=0;
		for(TreeNode node:map.keySet()){
			if(!map.get(node).equals(Integer.MAX_VALUE)){
				max=Math.max(max,Math.abs(map.get(node)-node.val));
			}
		}
		//print each node and its child with minimum val;
		// for(TreeNode t:map.keySet()){
		// 	if(!map.get(t).equals(Integer.MAX_VALUE)){
		// 	System.out.println(Integer.toString(t.val)+","+Integer.toString(map.get(t)));}
		// }
		return max;

	}
	public int helper(TreeNode root,HashMap<TreeNode,Integer> map){
		if(root==null){
			map.put(null,Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}
		int min=root.val;
		int left=Math.min(min,helper(root.left,map));
		int right=Math.min(min,helper(root.right,map));
		min=Math.min(min,left);
		min=Math.min(min,right);
		map.put(root,Math.min(left,right));
		return min;
	}

	public static void main(String[] args){
		Solution s=new Solution();
		TreeNode root=new TreeNode(8);
		root.left=new TreeNode(3);
		// root.right=new TreeNode(10);
		// root.left.left=new TreeNode(1);
		// root.left.right=new TreeNode(6);
		// root.left.right.left=new TreeNode(4);
		// root.left.right.right=new TreeNode(7);
		// root.right.right=new TreeNode(14);
		// root.right.right.left=new TreeNode(13);
		System.out.println(s.maxDiff(root));

	}
}
