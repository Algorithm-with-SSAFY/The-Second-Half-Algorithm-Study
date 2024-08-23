import java.io.*;

public class BOJ_15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringBuilder reverse = new StringBuilder(str).reverse();
        int len = str.length();
        int answer = len;

        if (str.contentEquals(reverse)) {
            String s = str.replaceAll(String.valueOf(str.charAt(0)), "");
            answer = s.isEmpty() ? -1 : len - 1;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}