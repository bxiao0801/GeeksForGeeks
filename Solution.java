import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		this.val=x;
	}
}

public class Solution{
	public List<Integer> bottomView(TreeNode root){
		List<Integer> res=new ArrayList<>();
		Deque<TreeNode> qNode=new LinkedList<>();
		Deque<Integer> qLevel=new LinkedList<>();
		Map<Integer,Integer> map=new TreeMap<>();
		qNode.offer(root);
		qLevel.offer(0);
		while(!qNode.isEmpty()){
			TreeNode node=qNode.poll();
			Integer level=qLevel.poll();
			map.put(level,node.val);
			if(node.left!=null){
				qNode.offer(node.left);
				qLevel.offer(level-1);
			}
			if(node.right!=null){
				qNode.offer(node.right);
				qLevel.offer(level+1);
			}
		}

		for(Integer i:map.keySet()){
			res.add(map.get(i));
		}

		return res;
	}
	public static void main(String[] args){
		TreeNode root=new TreeNode(20);
		root.left=new TreeNode(8);
		root.right=new TreeNode(22);
		root.left.left=new TreeNode(5);
		root.left.right=new TreeNode(3);
		root.left.right.left=new TreeNode(10);
		root.left.right.right=new TreeNode(14);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(25);

		Solution s=new Solution();
		System.out.println(s.bottomView(root));
	}
}