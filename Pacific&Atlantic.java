import java.util.LinkedList;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class Solution{
	public static final int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
	public List<int[]> waterFlow(int[][] ground){
		List<int[]> res=new ArrayList<>();
		int row=ground.length;
		int col=ground[0].length;
		boolean[][] visited=new boolean[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				int[] reach=bfs(i,j,row,col,visited,ground);
				if(reach!=null){
					res.add(reach);
				}
			}
		}

		return res;
	}


	public int[] bfs(int i,int j,int row,int col,boolean[][] visited,int[][] ground){
		boolean[] res=new boolean[2];
		Deque<int[]> q=new LinkedList<>();
		q.offer(new int[]{i,j});
		while(!q.isEmpty()){
			int[] tmp=q.poll();
			int x=tmp[0];
			int y=tmp[1];
			visited[x][y]=true;
			if(x==0||y==0){
				res[0]=true;
			}
			if(x==row-1||y==col-1){
				res[1]=true;
			}
			for(int[] d:dirs){
				int m=d[0]+x;
				int n=d[1]+y;
				if(m>=0&&m<row&&n>=0&&n<col&&!visited[m][n]&&ground[m][n]<=ground[x][y]){
					q.offer(new int[]{m,n});
				}
			}
		}
		reset(visited);
		if(res[0]&&res[1]){
			return new int[]{i,j};
		}
		return null;
	}

	public void reset(boolean[][] visited){
		for(int i=0;i<visited.length;i++){
			for(int j=0;j<visited[0].length;j++){
				visited[i][j]=false;
			}
		}
	}

	public static void main(String[] args){
		int[][] ground={{1,2,2,3,5},
						{3,2,3,4,4},
						{2,4,5,3,1},
						{6,7,1,4,5},
						{5,1,1,2,4}};
		Solution s=new Solution();
		List<int[]> res=s.waterFlow(ground);
		for(int[] i:res){
			System.out.println(Integer.toString(i[0])+" "+Integer.toString(i[1]));
		}	
	}
}
