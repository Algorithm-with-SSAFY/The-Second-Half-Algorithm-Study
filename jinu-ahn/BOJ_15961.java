import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15961 {
    private static int N,d,k,c;
    private static int[] sushi;
    private static int result;
    private static int[] choice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        choice = new int[d+1];
        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        slide();

        System.out.println(result);
    }

    static void slide() {
        int left = 1;
        int right = k;
        int cnt = 0;

        /* 초기 결과값 세팅*/
        for(int i = 0 ; i < k; i++) {
            if(choice[sushi[i]] == 0)
                cnt++;
            choice[sushi[i]]++;
        }
        result = choice[c] == 0 ? cnt+1 : cnt; // 쿠폰 초밥을 먹지 않았다면 결과 + 1
        if(result == k+1) return;

        while(left != N) {
            if(choice[sushi[left-1]] == 1)  // 왼쪽 값이 중복되어있지 않을 때
                cnt--;
            choice[sushi[left-1]]--;
            if(choice[sushi[right]] == 0)  // 오른쪽 값이 중복되어 있지 않을 때
                cnt++;
            choice[sushi[right]]++;

            result = choice[c] == 0 ? Math.max(result,cnt+1) : Math.max(result,cnt);
            if(result == k+1) break;

            right = (right+1) % N;
            left++;
        }
    }
}
