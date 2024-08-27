import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {

	static int dura[],weight[],N;
	static int MAX = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		dura = new int[N];
		weight = new int[N];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			dura[n]=Integer.parseInt(st.nextToken());
			weight[n] = Integer.parseInt(st.nextToken());
		}
		back(0,0);
		System.out.println(MAX);
	}
	public static void back(int idx,int cnt) {
		if(idx==N) {
			MAX = Math.max(MAX, cnt);
			return;
		}
		if(dura[idx]<=0 || cnt == N-1) {
			back(idx+1,cnt);
			return;
		}
		int nCnt = cnt;
		for(int n=0;n<N;n++) {
			if(n==idx)continue;
			if(dura[n]<=0)continue;
			dura[idx]-=weight[n];
			dura[n]-=weight[idx];
			if(dura[idx]<=0) {
				cnt++;
			}
			if(dura[n]<=0) {
				cnt++;
			}
			back(idx+1,cnt);
			dura[idx]+=weight[n];
			dura[n]+=weight[idx];
			cnt=nCnt;
		}
		
	}

}
