/*Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s. 
**Expected time complexity is O(n) and auxiliary space is O(1).
**Only 1 0 allowed to be flipped here
*/
public class Solution{
	public int maxLen(int[] nums){
		int maxLen=0;
		int left=0;
		int i=-1;
		int j=0;
		int index=Integer.MAX_VALUE;
		while(i<nums.length){
			while(j<nums.length&&nums[j]==1){
				j++;
			}
			if(left+j-i>maxLen){
				index=i;
				maxLen=left+j-i;
			}
			left=j-i-1;
			i=j;
			j++;
		}
		return index;
	}
}
