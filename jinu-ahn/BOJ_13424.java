import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13424 {
    static int N, M, K;
    static List<int[]>[] nodes;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            nodes = new ArrayList[N+1];

            for (int i = 1; i <= N; i++) nodes[i] = new ArrayList<>();

            for (int i = 0 ; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                nodes[from].add(new int[]{to, cost});
                nodes[to].add(new int[]{from, cost});
            }

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] ans = new int[N+1];
            for (int i = 0; i < K; i++) {
                int friend = Integer.parseInt(st.nextToken());
                bfs(friend);
                for (int j = 1; j <= N; j++) {
                    ans[j] += dist[j];
                }
            }
            int result = Integer.MAX_VALUE;
            int res = 0;
            for (int i = 1; i <= N; i++) {
                if (ans[i] < result) {
                    result = ans[i];
                    res = i;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void bfs(int start) {
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        boolean[] check = new boolean[N+1];
        q.add(new int[]{start, 0});
        dist[start] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(check[cur[0]] == true) continue;
            check[cur[0]] = true;

            for (int[] node : nodes[cur[0]]) {
                if (dist[node[0]] > dist[cur[0]] + node[1]) {
                    dist[node[0]] = dist[cur[0]] + node[1];
                    q.add(new int[]{node[0], dist[node[0]]});
                }
            }
        }
    }
}
