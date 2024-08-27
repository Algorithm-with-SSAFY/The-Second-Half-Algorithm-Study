import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7511 {

	static int N, parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			System.out.println("Scenario "+t+":");
			int N = Integer.parseInt(br.readLine());
			parents = new int[N+1];
			for(int n=0;n<=N;n++) {
				parents[n]=n;
			}
			int K = Integer.parseInt(br.readLine());
			for(int k=0;k<K;k++) {
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				merge(a,b);
			}
			int M = Integer.parseInt(br.readLine());
			for(int m=0;m<M;m++) {
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(find(a)==find(b)) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
			System.out.println();
		}
	}
	private static int find(int num) {
		return num==parents[num]?num:find(parents[num]);
	}
	private static void merge(int a,int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa==pb)return;
		else if(pa<=pb) {
			parents[pb]=pa;
		}else {
			parents[pa]=pb;
		}
	}
}
