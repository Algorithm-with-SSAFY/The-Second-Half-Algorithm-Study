import java.io.*;

public class BOJ_13019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();
        int[] arr = new int[26];
        for (char c : A.toCharArray()) {
            arr[c - 'A']++;
        }
        for (char c : B.toCharArray()) {
            arr[c - 'A']--;
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                answer = -1;
            }
        }

        if (answer != -1) {
            int idxB = A.length() - 1;
            for (int i = A.length() - 1; i >= 0; i--) {
                if (A.charAt(i) == B.charAt(idxB)) {
                    idxB--;
                } else {
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}