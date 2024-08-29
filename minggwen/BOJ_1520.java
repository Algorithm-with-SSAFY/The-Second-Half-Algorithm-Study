import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
	static int M,N;
	static int delta[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static int map[][], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map =new int[M][N];
		dp = new int[M][N];
		for(int[] d:dp) {
			Arrays.fill(d, -1);
		}
		for(int m=0;m<M;m++) {
			st=new StringTokenizer(br.readLine());
			for(int n=0;n<N;n++) {
				map[m][n]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(dfs(0,0));
		
	}
	private static int dfs(int row, int col) {
		if(row==M-1&&col==N-1)return 1;

		if(dp[row][col]==-1) {
			dp[row][col]=0;
			for(int d=0;d<4;d++) {
				int rd = row+delta[d][0];
				int cd = col+delta[d][1];
				if(!isIn(rd,cd))continue;
				if(map[row][col]>map[rd][cd]) {
					dp[row][col]+=dfs(rd,cd);
				}
			}
		}
		return dp[row][col];
	}
	private static boolean isIn(int row,int col) {
		return 0<=row&&row<M&&0<=col&&col<N?true:false;
	}

}
