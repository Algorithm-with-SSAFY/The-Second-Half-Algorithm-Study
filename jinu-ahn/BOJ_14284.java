import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class BOJ_14284 {
    static List<int[]>[] nodes;
    static boolean[] visited;
    static int s,t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[a].add(new int[]{b,c});
            nodes[b].add(new int[]{a,c});
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        System.out.println(bfs(s));
    }

    static int bfs(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[]{start,0});
        visited[start] = true;

        while(!pq.isEmpty()){
            int[] cur= pq.poll();

            if(cur[0] == t) return cur[1];
            visited[cur[0]] = true;
            for (int[] node : nodes[cur[0]]) {
                if(!visited[node[0]]) {
                    pq.offer(new int[]{node[0],cur[1] + node[1]});
                }
            }
        }
        return -1;
    }
}
