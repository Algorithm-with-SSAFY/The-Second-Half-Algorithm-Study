import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13424 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int matrix[][] = new int[N+1][N+1];
			
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				matrix[a][b]=c;
				matrix[b][a]=c;
			}
			int K = Integer.parseInt(br.readLine());
			int arr[] = new int [N+1];
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<K;k++) {
				int roomNum = Integer.parseInt(st.nextToken());
				int distances[] = new int[N+1];
				boolean visited[] = new boolean[N+1];
				Arrays.fill(distances, 100000000);
				
				distances[roomNum]=0;
				for(int i=1;i<=N;i++) {
					int MIN = Integer.MAX_VALUE;
					int minIdx = -1;
					for(int j = 1;j<=N;j++) {
						if(distances[j]<MIN&&!visited[j]) {
							MIN = distances[j];
							minIdx = j;
						}
					}
					if(minIdx==-1)break;
					visited[minIdx]=true;
					for(int j=1;j<=N;j++) {
						if(matrix[minIdx][j]>0&&!visited[j]&&distances[j]>MIN+matrix[minIdx][j]) {
							distances[j]=MIN+matrix[minIdx][j];
						}
					}
				}
				for(int j=1;j<=N;j++) {
					arr[j]+=distances[j];
				}
			}
			int MIN = Integer.MAX_VALUE;
			int minIdx = -1;
			for(int n=1;n<=N;n++) {
				if(arr[n]<MIN) {
					MIN = arr[n];
					minIdx=n;
				}
			}
			System.out.println(minIdx);
		}

	}

}
