package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_22857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int r = 0,l = 0;
        int Odd = 0;
        int Even = 0;
        if(list[0] % 2 == 0){
            Even++;
        }else{
            Odd++;
        }
        int answer = Even;
        while(r >= l){
            if(Odd > k){
                if(list[l] % 2 == 0){
                    Even--;
                }else{
                    Odd--;
                }
                l++;
            }else{
                r++;
                if(r>=n){
                    break;
                }
                if(list[r] % 2 == 0){
                    Even++;
                }else{
                    Odd++;
                }
                answer = Math.max(answer, Even);
            }
        }
        System.out.println(answer);
    }//main end
}//class end
