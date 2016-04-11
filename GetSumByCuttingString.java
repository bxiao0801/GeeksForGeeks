import java.util.List;
import java.util.ArrayList;

public class Solution{
	public List<List<String>> cut(String s,int target){
		List<List<String>> res=new ArrayList<>();
		helper(0,target,new ArrayList<String>(),s,res);
		return res;
	}

	public void helper(int start,int target,ArrayList<String> tmp,String s,List<List<String>> res){
		//reach the end of string
		if(start==s.length()){
			if(target==0){
				res.add(new ArrayList<String>(tmp));
			}
			return;
		}
		//before reaching the end,the rest of the string are alreay smaller than target, and we can only make it smaller when cutting, so we stop earlier
		if(Integer.parseInt(s.substring(start,s.length()))<target){
			return;
		}
		//we make a bigger move previously, so we backtrack and try other possibilities
		if(target<0){
			return;
		}
		for(int i=start;i<s.length();i++){
			String curr=s.substring(start,i+1);
			tmp.add(curr);
			helper(i+1,target-Integer.parseInt(curr),tmp,s,res);
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args){
		Solution s=new Solution();
		List<List<String>> res=s.cut("1234");
		for(List<String> l:res){
			System.out.println(l);
		}
	}
}
