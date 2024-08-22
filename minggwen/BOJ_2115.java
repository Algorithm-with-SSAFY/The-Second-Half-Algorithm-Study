import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2115 {
    static int M,N;
    static boolean[][] gallery;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        gallery = new boolean[M][N];
        for(int m=0;m<M;m++){
            String str = br.readLine();
            for(int n=0;n<N;n++){
                gallery[m][n] = str.charAt(n) == '.'?true:false;
            }
        }
        int cnt =0;
        int left =0;
        for(int n=1;n<N;n++){
            for(int m=1;m<M;m++){
                if(gallery[m][n-1]!=gallery[m][n]) {
                    if (left == 0) {
                        left++;
                        continue;
                    }
                    if(left!=0&&gallery[m-1][n]==gallery[m][n]) {
                        left++;
                        continue;
                    }
                    cnt += left / 2;
                    left = 1;
                }else{
                    cnt += left / 2;
                    left = 0;
                }
            }
            cnt += left / 2;
            left = 0;
        }
        int up = 0;
        for(int m=1;m<M;m++){
            for(int n=1;n<N;n++){
                if(gallery[m-1][n]!=gallery[m][n]) {
                    if (up == 0) {
                        up++;
                        continue;
                    }
                    if(up!=0&&gallery[m][n-1]==gallery[m][n]) {
                        up++;
                        continue;
                    }
                    cnt += up / 2;
                    up = 1;
                }else{
                    cnt += up / 2;
                    up = 0;
                }
            }
            cnt += up / 2;
            up = 0;
        }
        System.out.println(cnt);
    }
}
