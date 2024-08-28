package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2457 {
    private static class Flower implements Comparable<Flower>{
        int s;
        int e;

        public Flower(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Flower o) {
            if(s == o.s){
                return e - o.e;
            }else{
                return s - o.s;
            }
        }
    }
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        Flower[] flower = new Flower[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int start = sm * 100 + sd;
            int end = em * 100 + ed;
            flower[i] = new Flower(start,end);
        }

        Arrays.sort(flower);
        int startDay = 301;
        int endDay = 1201;
        int count = 0;
        int max = 0;
        int idx = 0;

        while(startDay < endDay){
            boolean check = false;

            for(int i = idx; i < n; i++){
                if(flower[i].s > startDay){
                    break;
                }

                if(max < flower[i].e){
                    check = true;
                    max = flower[i].e;
                    idx = i + 1;
                }
            }

            if(check){
                startDay = max;
                count++;
            }else{
                break;
            }
        }

        if(max < endDay){
            System.out.println(0);
        }else{
            System.out.println(count);
        }
    }//main end
}//class end
