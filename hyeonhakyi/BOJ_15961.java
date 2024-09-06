package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {
    static int n,d,k,c;
    static int[] chobab;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        chobab = new int[n];
        visited = new int[d+1];

        for(int i = 0; i < n; i++){
            chobab[i] = Integer.parseInt(br.readLine());
        }
        int res = 1;
        visited[c]++;
        for(int i = 0; i < k; i++){
            if(visited[chobab[i]] == 0){
                res++;
            }
            visited[chobab[i]]++;
        }

        int cnt = res;
        for(int i = 1; i < n; i++){
            visited[chobab[i-1]]--;
            if(visited[chobab[i-1]] == 0) cnt--;

            if(visited[chobab[(i+k-1)%n]] == 0) cnt++;
            visited[chobab[(i+k-1)%n]]++;

            res = Math.max(res,cnt);
        }
        System.out.println(res);
    }
}

