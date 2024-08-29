import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2457 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<>();
		for(int n =0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());
			int d = 0;
			d+=startM*1000000;
			d+=startD*10000;
			d+=endM*100;
			d+=endD;
			if(d/10000<d%10000) {
				arr.add(d);
			}
		}
		Collections.sort(arr);
		int ex = 301;
		int exIDX = -1;
		int cnt = 0;
		boolean flag = false;
		boolean cantChoice = false;
		for(int idx=0;idx<arr.size();idx++) {
			int MAX = 0;
			for(int k=exIDX+1;k<arr.size();k++) {
				if(arr.get(k)/10000<=ex&&MAX<arr.get(k)%10000) {
					exIDX = k;
					MAX = arr.get(k)%10000;
				}
				if(MAX>1130) {
					flag=true;
					break;
				}else if(MAX==0) {
					cantChoice = true;
					break;
				}
			}
			ex=MAX;
			if(!cantChoice)cnt++;
			if(flag||cantChoice)break;
		}
		System.out.println(cantChoice||!flag?0:cnt);
	}

}
