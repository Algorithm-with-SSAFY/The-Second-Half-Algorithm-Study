import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine());
        int[][] eggs = new int[N][2];
        for(int i = 0 ; i<N ; i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }
        hit(0,0,eggs);
        System.out.println(answer);

    }
    public static void hit(int cnt, int num, int[][] eggs){
        if(cnt==N){
            answer = Math.max(answer,num);
            return;
        }
        if(eggs[cnt][0]<=0) hit(cnt+1,num,eggs);
        else{
            boolean flag = false;
            for(int i = 0 ; i<N ; i++){
                if(i==cnt || eggs[i][0]<=0) continue;
                flag = true;
                int thisnum = num;
                eggs[cnt][0]-=eggs[i][1];
                eggs[i][0]-=eggs[cnt][1];
                if(eggs[cnt][0]<=0) thisnum++;
                if(eggs[i][0]<=0) thisnum++;
                hit(cnt+1,thisnum,eggs);
                eggs[cnt][0]+=eggs[i][1];
                eggs[i][0]+=eggs[cnt][1];
            }
            if(!flag)hit(cnt+1,num,eggs);
        }

    }

}
