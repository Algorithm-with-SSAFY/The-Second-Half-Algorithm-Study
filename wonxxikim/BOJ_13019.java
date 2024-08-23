import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer;
    static String A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().trim();
        B = br.readLine().trim();
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for(int i = 0 ; i<26 ; i++){
            mapA.put((char) (i+'A'),0);
            mapB.put((char) (i+'A'),0);
        }
        for(int i = 0 ; i<A.length();  i++){
            mapA.put(A.charAt(i), mapA.getOrDefault(A.charAt(i), 0) + 1);
            mapB.put(B.charAt(i), mapB.getOrDefault(B.charAt(i), 0) + 1);
        }
        for(int i = 0 ; i<26 ; i++){
            if(mapA.get((char) (i+'A'))!=mapB.get((char) (i+'A'))) {
                System.out.println(-1);
                return;
            }
        }

        int idx = A.length() - 1;
        int targetIdx = B.length() - 1;

        int result = 0;
        while (idx >= 0) {
            if (B.charAt(targetIdx) != A.charAt(idx)) {
                result++;
            } else {
                targetIdx--;
            }
            idx--;
        }

        System.out.println(result);


    }


}
