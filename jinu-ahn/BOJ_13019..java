import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] aArr = br.readLine().toCharArray();
        char[] bArr = br.readLine().toCharArray();

        int len = bArr.length-1;
        int cnt = 0;
        for (int i = aArr.length-1; i >= 0; i--) {
            if(aArr[i] != bArr[len]) cnt++;
            else len--;
        }


        Arrays.sort(aArr);
        Arrays.sort(bArr);

        for (int i = 0; i < aArr.length; i++) {
            if(aArr[i] != bArr[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }
}
