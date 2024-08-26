import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 계란으로 계란치기
public class BOJ_16987 {
    static int N, max;
    static Egg[] eggs;
    static StringBuilder sb = new StringBuilder();

    static class Egg {
        int s, w;
        boolean isBroken;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
            isBroken = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        int s, w;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }

        max = 0;
        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int idx) {
        if (idx == N) {
            int brokenCount = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i].isBroken) brokenCount++;
            }
            max = Math.max(max, brokenCount);
            return;
        }

        if (eggs[idx].isBroken) {
            dfs(idx + 1);
            return;
        }

        boolean allBrokenOrSame = true;
        for (int i = 0; i < N; i++) {
            if (i == idx || eggs[i].isBroken) continue;

            allBrokenOrSame = false;

            // 부딪힘
            eggs[idx].s -= eggs[i].w;
            eggs[i].s -= eggs[idx].w;

            if (eggs[idx].s <= 0) eggs[idx].isBroken = true;
            if (eggs[i].s <= 0) eggs[i].isBroken = true;

            dfs(idx + 1);

            // 원상복구
            eggs[idx].s += eggs[i].w;
            eggs[i].s += eggs[idx].w;

            if (eggs[idx].s > 0) eggs[idx].isBroken = false;
            if (eggs[i].s > 0) eggs[i].isBroken = false;
        }

        // 만약 계란을 부딪힐 수 있는 다른 계란이 없다면 다음으로 진행
        if (allBrokenOrSame) {
            dfs(idx + 1);
        }
    }

    public static boolean collision(Egg e1, Egg e2) {
        e2.s -= e1.w;
        e1.s -= e2.w;
        if (e1.s <= 0) e1.isBroken = true;
        if (e2.s <= 0) e2.isBroken = true;
        return e1.isBroken || e2.isBroken;
    }

    public static void recover(Egg e1, Egg e2) {
        e2.s += e1.w;
        e1.s += e2.w;
        if (e1.s > 0) e1.isBroken = false;
        if (e2.s > 0) e2.isBroken = false;
    }

}