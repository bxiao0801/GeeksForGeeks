import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
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
	public List<Integer> diagonalSum(TreeNode root){
		List<Integer> res=new ArrayList<>();
		Deque<TreeNode> qNode=new LinkedList<>();
		Deque<Integer> qLevel=new LinkedList<>();
		HashMap<Integer,Integer> map=new HashMap<>();

		qNode.offer(root);
		qLevel.offer(0);
		while(!qNode.isEmpty()){
			TreeNode tmp=qNode.poll();
			Integer level=qLevel.poll();

			while(tmp!=null){
				if(tmp.left!=null){
					qNode.offer(tmp.left);
					qLevel.offer(level+1);
				}
				
				if(map.containsKey(level)){
					map.put(level,map.get(level)+tmp.val);
				}else{
					map.put(level,tmp.val);
				}
				
				tmp=tmp.right;
			}
		}
		for(Integer i:map.keySet()){
			res.add(map.get(i));
		}
		return res;
	}
	public static void main(String[] args){
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(9);
		root.left.right=new TreeNode(6);
		root.left.left.right=new TreeNode(10);
		root.left.right.left=new TreeNode(11);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(5);
		root.right.left.left=new TreeNode(12);
		root.right.left.right=new TreeNode(7);
		Solution s=new Solution();
		System.out.println(s.diagonalSum(root));
	}
}
