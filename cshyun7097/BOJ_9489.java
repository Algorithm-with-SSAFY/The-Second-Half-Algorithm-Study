import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) break;

            int target = 0;
            int[] arr = new int[n + 1];
            int[] parent = new int[n + 1];
            int idx = -1;

            parent[0] = -1;
            arr[0] = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == k) target = i;
                if (arr[i] != arr[i - 1] + 1) idx++;
                parent[i] = idx;
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]) res++;
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
