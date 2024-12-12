import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 젊은 날의 생이여 / 60분
public class BOJ_18866 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] u = new int[N];  // 행복도
        int[] v = new int[N];  // 피로도

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            u[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int max_diff = 0;
        int min_diff = 0;
        for (int i = 0; i < N; i++) {
            int diff = u[i] - v[i];  // 행복도와 피로도의 차이
            max_diff = Math.max(max_diff, max_diff + diff);
            min_diff = Math.min(min_diff, min_diff + diff);
        }

        int result = (max_diff - min_diff) / 2;
        System.out.println(result);
    }
}
