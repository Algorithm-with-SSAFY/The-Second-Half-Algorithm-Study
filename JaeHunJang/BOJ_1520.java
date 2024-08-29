import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 내리막 길
public class BOJ_1520 {
    static int N, M;
    static int[][] map, dp;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  // DP 배열 초기화 (아직 방문하지 않음을 나타냄)
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int r, int c) {
        // 도착지에 도달하면 1 반환
        if (r == M - 1 && c == N - 1) {
            return 1;
        }

        // 이미 계산된 경로가 있으면 그 값을 반환
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;  // 현재 위치에서 출발하는 경로의 수 초기화

        // 네 방향으로 이동
        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            // 맵의 범위를 벗어나지 않으면서 내리막일 경우
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] < map[r][c]) {
                dp[r][c] += dfs(nr, nc);
            }
        }

        return dp[r][c];
    }
}
