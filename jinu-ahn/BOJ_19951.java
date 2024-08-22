import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] area = new int[N+1];
        int[] sum = new int[N+2];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            area[i] = Integer.parseInt(st.nextToken());
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int depth = Integer.parseInt(st.nextToken());

            sum[x] += depth;
            sum[y+1] -= depth;
        }

        for (int i = 1; i <= N; i++) {
            sum[i] += sum[i-1];
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(area[i] + sum[i] + " ");
        }
    }
}
