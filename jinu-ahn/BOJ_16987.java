import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {
    static int N, answer;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        per(0, 0);
        System.out.println(answer);
    }

    static void per(int level, int sum) {
        if(level==N) return;

        for (int i = 0; i < N; i++) {
            if(i == level || arr[i][0]<=0) continue;
            if(arr[level][0]<=0) {
                per(level+1, sum);
                return;
            }
            arr[level][0] -= arr[i][1];
            arr[i][0] -= arr[level][1];
            int cnt = 0;
            if (arr[level][0] <= 0)
                cnt++;
            if (arr[i][0] <= 0)
                cnt++;
            answer = Math.max(answer, sum+cnt);
            per(level + 1, sum + cnt);
            arr[level][0] += arr[i][1];
            arr[i][0] += arr[level][1];
        }
    }
}
