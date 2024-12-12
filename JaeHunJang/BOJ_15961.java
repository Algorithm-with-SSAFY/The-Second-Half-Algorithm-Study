import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 회전 초밥
public class BOJ_15961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, d, k, c, maxCount, sushi[];
	static Map<Integer, Integer> sushiType;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		sushi = new int[N]; // 초밥 벨트에 놓인 초밥
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		sushiType = new HashMap<>();
		for (int i = 0; i < k; i++) {
			sushiType.put(sushi[i], sushiType.getOrDefault(sushi[i], 0) + 1);
		}
		maxCount = sushiType.size();
		if (sushiType.getOrDefault(c, -1) < 0) maxCount++;
	}
	
	private static void solve() throws Exception {
		slidingWindow();
		sb.append(maxCount);
	}
	
	private static void slidingWindow() {
		int key, value;
		for(int i = 0; i < N; i++) {
			key = sushi[i%N]; // 내가 먹는 거에서 뺄 초밥
			value = sushiType.get(key)-1;
			if (value == 0) sushiType.remove((Integer)key);
			else {
				sushiType.put(key, value);
			}
			
			key = sushi[(i+k)%N]; // 새로 넣을 초밥
			sushiType.put(key, sushiType.getOrDefault(key, 0) + 1);
			
			if (sushiType.getOrDefault(c, -1) < 0) { // 쿠폰으로 받을 초밥이 없다면 +1 해줌
				maxCount = Math.max(maxCount, sushiType.size()+1);
			} else {
				maxCount = Math.max(maxCount, sushiType.size());
			}
		}
	}
}