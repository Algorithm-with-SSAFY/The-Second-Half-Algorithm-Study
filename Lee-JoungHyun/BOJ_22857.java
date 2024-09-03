import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22857 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int l = 0, r = 0;
		int tempK = (nums[0] % 2 == 1)? 1: 0;
		int temp = (nums[0] % 2 == 0)? 1: 0;
		ans = temp;
		while (true) {
			if (tempK > K) {
				if (nums[l++] % 2 == 0) {
					temp--;
				} else {
					tempK--;
				}
			} else {
				r++;
				if (r >= nums.length) break;
				if (nums[r] % 2 == 0) {
					temp++;
					if (temp > ans) ans = temp;
				} else {
					tempK++;
				}
			}
		}
		System.out.println(ans);
	}
}
