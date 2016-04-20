public class Solution{
	public ListNode sortList(ListNode head){
		ListNode dummyHead=new ListNode(0);
		dummyHead.next=head;
		ListNode idx0=dummyHead;
		ListNode idx1=dummyHead;
		ListNode curr=dummyHead;
		while(curr.next!=null){
			if(curr.next.val==2){
				curr=curr.next;
			}else if(curr.next.val==0){
				if(idx0.next!=curr.next){
					ListNode tmp=curr.next.next;
					curr.next.next=idx0.next;
					idx0.next=curr.next;
					idx0=idx0.next;
					curr.next=tmp;
				}else{
					curr=curr.next;
					idx1=idx1.next;
					idx0=idx0.next;

				}
			}else{
				if(idx1.next!=curr.next){
					ListNode tmp=curr.next.next;
					curr.next.next=idx1.next;
					idx1.next=curr.next;
					idx1=idx1.next;
					curr.next=tmp;

				}else{
					curr=curr.next;
					idx1=idx1.next;
				}
			}
		}
		return dummyHead.next;

	}
	public static void main(String[] args){
		ListNode head=new ListNode(0);
		head.next=new ListNode(2);
		head.next.next=new ListNode(1);
		head.next.next.next=new ListNode(1);
		head.next.next.next.next=new ListNode(0);


		Solution s=new Solution();
		ListNode n=s.sortList(head);
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
	}
}
