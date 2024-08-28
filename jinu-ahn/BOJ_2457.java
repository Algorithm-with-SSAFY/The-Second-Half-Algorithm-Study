import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Flower {
    int start;
    int end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class BOJ_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) * 100;
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) * 100;
            int d = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(a+b , c+d);
        }

        Arrays.sort(flowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int last = 301;
        int lastidx = -1;
        int cnt = 0;
        a: while (true) {
            int temp = last;
            int i = lastidx;
            boolean isget = false;
            while (true) {
                if (++i >= N) {
                    if (!isget) {
                        cnt = 0;
                        break a;
                    }
                    break;
                }
                if (flowers[i].start > temp) {
                    if (!isget) {
                        cnt = 0;
                        break a;
                    }
                    break;
                }
                if (flowers[i].end > last) {
                    lastidx = i;
                    last = flowers[i].end;
                    isget = true;
                }
            }
            cnt++;
            if (last >= 1201)
                break;
        }
        System.out.println(cnt);
    }
}
