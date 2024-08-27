import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소셜 네트워킹 어플리케이션 / 30분
public class BOJ_7511 {
    static StringBuilder sb = new StringBuilder();
    static int n, k, m, parents[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            sb.append("Scenario ").append((t+1)).append(":\n");
            n = Integer.parseInt(br.readLine()); // 유저 수
            parents = new int[n];
            for (int i = 0; i < n; i++) { // make-set
                parents[i] = i;
            }

            k = Integer.parseInt(br.readLine()); // 친구 관계 수
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            m = Integer.parseInt(br.readLine()); // 관계를 구할 수
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (find(u) == find(v)) {
                    sb.append(1);
                } else sb.append(0);
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        parents[pa] = pb;

        return true;
    }

}