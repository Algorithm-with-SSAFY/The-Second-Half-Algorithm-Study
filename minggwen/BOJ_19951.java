import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sends[]= new int[N];
        int plus[] = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int n=0;n<N;n++) {
            sends[n]=Integer.parseInt(st.nextToken());
        }
        for(int m=0;m<M;m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            plus[a-1]+=k;
            plus[b]-=k;
        }
        int sumPlus[] = new int[N+1];
        sumPlus[0]=plus[0];
        for(int n=1;n<=N;n++) {
            sumPlus[n]=sumPlus[n-1]+plus[n];
        }
        StringBuilder sb = new StringBuilder();
        for(int n=0;n<N;n++) {
            sb.append(sends[n]+sumPlus[n]);
            sb.append(" ");
        }
        System.out.println(sb.toString());

    }

}
