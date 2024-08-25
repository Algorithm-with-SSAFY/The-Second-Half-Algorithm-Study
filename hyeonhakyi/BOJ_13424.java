package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13424 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dist = new int[n+1][n+1];

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(i==j){
                        dist[i][j] = 0;
                    }else{
                        dist[i][j] = 100000;
                    }
                }
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                dist[from][to] = value;
                dist[to][from] = value;
            }

            for(int k = 1; k <= n; k++){
                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= n; j++){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }

            int k = Integer.parseInt(br.readLine());
            int[] person = new int[k+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < k; i++){
                person[i] = Integer.parseInt(st.nextToken());
            }

            int ansLen = 10000000;
            int ans = -1;
            for(int i = 1; i <= n; i++){
                int temp = 0;
                for(int j = 0; j < k; j++){
                    temp += dist[person[j]][i];
                }

                if(temp < ansLen){
                    ansLen = temp;
                    ans = i;
                }
            }
            System.out.println(ans);
        }
    }//main end
}//class end
