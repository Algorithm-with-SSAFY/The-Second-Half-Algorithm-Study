import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        int size = A.length();

        if(!isPalindrome()){
            System.out.println(size);
            return;
        }

        int answer = size-1;
        boolean flag = true;
        char check = A.charAt(0);
        for(int i = 1 ;  i<size ; i++){
            if(A.charAt(i)!=check) {
                flag = false;
                break;
            }
        }
        if(flag) answer = -1;

        System.out.println(answer);


    }
  
    public static boolean isPalindrome(){
        int size = A.length();
        for(int i = 0  ; i<size/2 ; i++){
            if(A.charAt(i)!=A.charAt(size-1-i)) return false;
        }

        return true;
    }


}
