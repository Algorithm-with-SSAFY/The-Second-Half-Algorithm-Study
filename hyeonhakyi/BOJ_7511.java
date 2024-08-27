package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7511 {
    static int tc,n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int tc = Integer.parseInt(br.readLine());

        for(int t = 1; t <= tc; t++) {
            sb = new StringBuilder();
            sb.append("Scenario " + t + ":\n");
            n = Integer.parseInt(br.readLine());

            parent = new int[n];

            for(int i = 1; i < n; i++) {
                parent[i] = i;
            }


            m = Integer.parseInt(br.readLine());

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                union(from, to);
            }

            m = Integer.parseInt(br.readLine());

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if(find(from) == find(to)) {
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }
            System.out.println(sb);
        }
    }//main end

    private static void union(int a,int b){
        int A = find(a);
        int B = find(b);

        if(A > B){
            parent[A] = B;
        }else if(A < B){
            parent[B] = A;
        }
    }//union end

    private static int find(int x){
        if(parent[x] == x) {
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
}//class end
