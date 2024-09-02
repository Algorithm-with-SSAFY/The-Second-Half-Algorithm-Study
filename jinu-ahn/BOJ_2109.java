import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        boolean[] checked = new boolean[10_001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{p,d});
        }
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int[] cur = pq.poll();
            if(checked[cur[1]]){
                for (int j = cur[1]; j >= 1; j--) {
                    if(!checked[j]) {
                        checked[j] = true;
                        sum += cur[0];
                        break;
                    }
                }
            } else {
                checked[cur[1]] = true;
                sum += cur[0];
            }
        }
        System.out.println(sum);
    }
}
