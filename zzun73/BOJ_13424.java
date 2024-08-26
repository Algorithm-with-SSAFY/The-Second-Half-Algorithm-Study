import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13424 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N + 1][N + 1];

            for (int[] row : map) {
                Arrays.fill(row, 1_000_000_000);
            }
            for (int i = 1; i <= N; i++) {
                map[i][i] = 0;
            }

            while (M-- > 0) {

                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a][b] = c;
                map[b][a] = c;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (i == j) {
                            continue;
                        }
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            int maxLen = Integer.MAX_VALUE;
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 0; j < K; j++) {
                    sum += map[arr[j]][i];
                }

                if (sum < maxLen) {
                    answer = i;
                    maxLen = sum;
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}