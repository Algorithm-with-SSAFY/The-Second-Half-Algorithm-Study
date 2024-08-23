import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int result = Integer.MAX_VALUE;
    static char[] now;
    static char[] finish;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        now = br.readLine().toCharArray();
        finish = br.readLine().toCharArray();

        calc();
        System.out.println(result);
    }

    static void calc() {
        if(new String(now).equals(new String(finish))) {
            sb.append(0);
            return;
        }
        char[] copy = now.clone();

        int firstCaseCnt = 1;

        // 처음 스위치를 누르고 시작한 경우
        now[0] = pushSwitch(now[0]);
        now[1] = pushSwitch(now[1]);
        firstCaseCnt = result(now, firstCaseCnt);
        if (new String(now).equals(new String(finish)))
            result = Math.min(result,firstCaseCnt);

        // 처음 스위치를 누르지 않고 시작한 경우
        now = copy;

        int secondCaseCnt = 0;

        secondCaseCnt = result(now, secondCaseCnt);
        if (new String(now).equals(new String(finish)))
            result = Math.min(result,secondCaseCnt);

        if (result == Integer.MAX_VALUE)
            sb.append(-1);
        else
            sb.append(result);
    }

    static int result(char[] now, int cnt) {
        int idx = 1;
        while (idx < N) {
            if (now[idx - 1] != finish[idx - 1] && idx + 1 < N) {
                now[idx - 1] = pushSwitch(now[idx - 1]);
                now[idx] = pushSwitch(now[idx]);
                now[idx + 1] = pushSwitch(now[idx + 1]);
                cnt++;
            } else if (now[idx - 1] != finish[idx - 1]) {
                now[idx - 1] = pushSwitch(now[idx - 1]);
                now[idx] = pushSwitch(now[idx]);
                cnt++;
            }
            idx++;
        }
        return cnt;
    }

    static char pushSwitch(char status) {
        return status == '0' ? '1' : '0';
    }
}
