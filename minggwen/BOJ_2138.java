import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138{

	static int N;
	static boolean[] arr1;
	static boolean[] arr2;
	static boolean[] answer;
	static int result = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		arr1= new boolean[N];
		arr2= new boolean[N];
		for(int n =0; n<N; n++) {
			if(str.charAt(n)=='0') {
				arr1[n] = true;
				arr2[n] = true;
			}
		}
		
		String tmp = br.readLine();
		answer = new boolean[N];
		for(int n =0; n<N; n++) {
			if(tmp.charAt(n)=='0') {
				answer[n] = true;
			}
		}
		int cnt1 = 0;
		int cnt2 = 0;
		
		onoff(0,arr2);
		cnt2++;
		
		for(int n=1; n<N;n++) {
			if(arr1[n-1]!=answer[n-1]) {
				onoff(n,arr1);
				cnt1++;
			}
			if(arr2[n-1]!=answer[n-1]) {
				
				onoff(n,arr2);
				cnt2++;
			}
		}
		if(checkSame(arr1)&&checkSame(arr2)) {
			result = Math.min(cnt1, cnt2);
		}else if(checkSame(arr1)) {
			result = cnt1;
		}else if(checkSame(arr2)) {
			result = cnt2;
		}
		
		System.out.println(result);
		
	}
	private static boolean checkSame(boolean[] arr) {

		for(int idx = 0; idx<N;idx++) {
			if(arr[idx] != answer[idx]) return false;
		}
		return true;
	}
	private static void onoff(int idx,boolean[] arr) {
		for(int i=idx-1; i<=idx+1;i++) {
			if(0<=i&&i<N) {
				arr[i] = !arr[i];
			}
		}
	}
}
