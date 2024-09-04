import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class BOJ_2058 {
 
    static int M;
    static boolean[] state;
    static int[] energy;
    static boolean[] visited;
 
    public static void main(String[] args) throws Exception{
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 원자 상태의 개수
        M = Integer.parseInt(st.nextToken()); // 양성자의 개수
 
        // 원자가 가질 수 있는 에너지 상태
        state = new boolean[1_000_001];
        // 임의로 정한 루트 노드의 값
        int start = 0;
        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());
 
            if(i == 0) start = n;
            state[n] = true;
        }
        energy = new int[M];
        for (int i = 0; i < M; i++) {
            energy[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[1_000_001];
        
        int[] result = dfs(start);
        System.out.println(Math.max(result[0], result[1]));
    }
 
    private static int[] dfs(int now) { // now := 현재 상태
 
        visited[now] = true;
        int[] result = new int[2];
        result[0] = now;
 
        int[] tmp;
        for (int i = 0; i < M; i++) {
            for(int newState : new int[] {now + energy[i], now - energy[i]}) {
                if(newState > 0 && newState < 1_000_001) {
                    if(state[newState] && !visited[newState]) {
                        tmp = dfs(newState);
                        result[0] += tmp[1];
                        result[1] += Math.max(tmp[0], tmp[1]);
                    }
                }
            }
        }
 
        return result;
    }
}
