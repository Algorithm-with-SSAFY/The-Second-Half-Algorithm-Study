import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class number implements Comparable<number>{
        int num;
        int wei;
        public number(int num, int wei){
            this.num = num;
            this.wei = wei;
        }

        @Override
        public int compareTo(number o) {
            return this.wei-o.wei;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<number>[] set = new ArrayList[n+1];
        for(int i = 0 ; i<=n ; i++){
            set[i] = new ArrayList<>();
        }
        for(int i = 0 ; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            set[a].add(new number(b,c));
            set[b].add(new number(a,c));

        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<number> pq = new PriorityQueue<>();
        pq.add(new number(s,0));
        boolean[] visited = new boolean[n+1];
        int[] answer = new int[n+1];
        Arrays.fill(answer,Integer.MAX_VALUE);
        answer[s] = 0;
        while(!pq.isEmpty()){
            number cur = pq.poll();
            if(visited[cur.num]) continue;
            visited[cur.num] = true;
            for(number x : set[cur.num]){
                if(answer[x.num]>answer[cur.num]+x.wei){
                    answer[x.num] = answer[cur.num]+x.wei;
                    pq.add(new number(x.num,answer[x.num]));
                }
            }

        }

        System.out.println(answer[t]);

    }


}
