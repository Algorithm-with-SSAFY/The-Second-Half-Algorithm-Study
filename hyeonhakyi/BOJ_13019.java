package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int size = a.length();
        int count = 0;
        int target = size - 1;

        for(int i = size - 1; i >= 0; i--) {
            if(a.charAt(i) != b.charAt(target)) {
                count++;
            }else{
                target--;
            }
        }

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        Arrays.sort(charA);
        Arrays.sort(charB);

        a = String.valueOf(charA);
        b = String.valueOf(charB);

        if(a.equals(b)) {
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }//main end
}//class end
