import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공주님의 정원
public class BOJ_2457 {
    static int s, N, K, R1, R2, C1, C2, sSize;
    static char[][] arr = new char[51][51];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++)
                flowers[i][j] = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
        }

        Arrays.sort(flowers, (f1, f2) -> {
            if (f1[0] != f2[0]) return f1[0] - f2[0];
            return f1[1] - f2[1];
        });

        int ans = 0, date = 301, findIndex = -1;
        while (date <= 1130) {
            boolean findDate = false;
            int maxDate = date;
            for (int i = findIndex + 1; i < N; i++) {
                if ((flowers[i][0] <= date && date <= flowers[i][1] && maxDate < flowers[i][1])) {
                    maxDate = flowers[i][1];
                    findDate = true;
                    findIndex = i;
                }
            }
            if (!findDate) break;
            ans += 1;
            date = maxDate;
        }

        if (date <= 1130) System.out.println(0);
        else System.out.println(ans);
    }
}