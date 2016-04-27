import java.util.Deque;
import java.util.LinkedList;
import java.util.HashMap;
public class Solution{
	public TreeNode construct(int[] inorder,int[] levelorder){
		Deque<TreeNode> node=new LinkedList<>();
		Deque<int[]> range=new LinkedList<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		int index=1;
		TreeNode root=new TreeNode(levelorder[0]);
		node.offer(root);
		range.offer(new int[]{0,inorder.length-1});
		
		for(int i=0;i<inorder.length;i++){
			map.put(inorder[i],i);
		}
		while(!node.isEmpty()){
			TreeNode n=node.poll();
			int[] r=range.poll();
			int i=r[0];
			int j=r[1];
			int pos=map.get(n.val);
			if(i<=pos-1){
				TreeNode tmp=new TreeNode(levelorder[index]);
				n.left=tmp;
				node.offer(tmp);
				range.offer(new int[]{i,pos-1});
				index++;
			}
			if(j>=pos+1){
				TreeNode tmp=new TreeNode(levelorder[index]);
				n.right=tmp;
				node.offer(tmp);
				range.offer(new int[]{pos+1,j});
				index++;
			}
		}
		return root;
	}

	public static void main(String[] args){
		int[] inorder={4,8,10,12,14,20,22};
		int[] levelorder={20,8,22,4,12,10,14};
		Solution s=new Solution();
		System.out.println(s.construct(inorder,levelorder));
	}
}
