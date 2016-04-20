import java.util.Random;
public class Solution{
	public void quicksort(int[] nums,int low,int high){
		if(low>=high){
			return;
		}
		Random r=new Random();
		int pivotIndex=r.nextInt(high-low+1)+low;
		int pivot=nums[pivotIndex];
		nums[pivotIndex]=nums[high];
		nums[high]=pivot;

		int i=low;
		int j=high-1;
		while(i<j){
			while(nums[i]<pivot&&i<=j){
				i++;
			}
			while(nums[j]>pivot&&i<=j){
				j--;
			}
			if(i<j){
				swap(nums,i,j);
			}
		}
		nums[high]=nums[i];
		nums[i]=pivot;
		quicksort(nums,low,i-1);
		quicksort(nums,i+1,high);
	}

	public void swap(int[] nums,int i,int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}

	public static void main(String[] args){
		Solution s=new Solution();
		int[] nums={4,1,2,4,2,5,6,1,7};
		s.quicksort(nums,0,nums.length-1);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}

}
