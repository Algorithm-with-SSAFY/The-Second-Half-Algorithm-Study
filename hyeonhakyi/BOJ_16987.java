package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {
    private static class Egg{
        int s;
        int w;

        public Egg(int s, int w){
            this.s = s;
            this.w = w;
        }
    }
    static int n,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        Egg[] eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }
        Break(0,eggs);

        System.out.println(ans);
    }//main end

    private static void Break(int idx, Egg[] eggs){
        if(idx == n){
            int sum = 0;
            for(int i = 0; i < eggs.length; i++){
                if(eggs[i].s <= 0){
                    sum++;
                }
            }
            ans = Math.max(ans, sum);
            return;
        }

        if(eggs[idx].s > 0){
            boolean next = false;
            for(int i = 0; i < n; i++){
                if(idx == i){
                    continue;
                }
                if(eggs[i].s <= 0){
                    continue;
                }

                next = true;
                eggs[idx].s -= eggs[i].w;
                eggs[i].s -= eggs[idx].w;

                Break(idx+1, eggs);

                eggs[idx].s += eggs[i].w;
                eggs[i].s += eggs[idx].w;
            }
            if(!next){
                Break(idx+1, eggs);
            }
        }else{
            Break(idx+1, eggs);
        }
    }//Break end
}//class end
