import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

// 진우의 민트초코우유 / 60분
public class BOJ_20208 {

    static int N, M, H, jinwoo, answer;
    static HashSet<Integer> visited = new HashSet<>();
    static List<Integer> chocomilk = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) jinwoo = i * N + j;
                if (v == 2) chocomilk.add(i * N + j);
            }
        }
        dfs(jinwoo, M);
        System.out.println(answer);
    }

    static void dfs(int curr, int hp) {
        int cx = curr / N, cy = curr % N;
        if(hp >= Math.abs(cx - jinwoo / N) + Math.abs(cy - jinwoo % N)){
            answer = Math.max(answer, visited.size());
        }
        for (int next : chocomilk) {
            if (visited.contains(next)) continue;
            int nx = next / N, ny = next % N;
            if (hp < Math.abs(cx - nx) + Math.abs(cy - ny)) continue;
            visited.add(next);
            dfs(next, hp - (Math.abs(cx - nx) + Math.abs(cy - ny)) + H);
            visited.remove(next);
        }
    }

}