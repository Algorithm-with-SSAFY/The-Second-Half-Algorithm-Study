import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_20208 {
    static int n, m, h, max = 0, milk = 0;
    static Pair home;
    static ArrayList<Pair> milks = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    home = new Pair(i, j);
                } else if (x == 2) {
                    milks.add(new Pair(i, j));
                    milk++;
                }
            }
        }

        isVisited = new boolean[milk];

        dfs(home.x, home.y, 0);

        System.out.println(max);
    }

    static void dfs(int x, int y, int eat) {
        for (int i = 0; i < milk; i++) {
            if (isVisited[i]) continue;

            isVisited[i] = true;

            Pair pair = milks.get(i);

            int nx = pair.x;
            int ny = pair.y;
            int distNext = getDist(x, y, nx, ny);

            if (distNext <= m) {
                m += h;
                m -= distNext;
                if (getDist(home.x, home.y, nx, ny) <= m) max = Math.max(max, eat + 1);
                dfs(nx, ny, eat + 1);
                m -= h;
                m += distNext;
            }

            isVisited[i] = false;
        }
    }

    static int getDist(int ax, int ay, int bx, int by) {
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}
