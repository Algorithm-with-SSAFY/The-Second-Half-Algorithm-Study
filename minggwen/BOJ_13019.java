import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_13019 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strA= br.readLine();
		String strB = br.readLine();
		Deque<Character> queA = new LinkedList<>();
		Deque<Character> queB = new LinkedList<>();
		if(strA.length()!=strB.length()) {
			System.out.println(-1);
			System.exit(0);
		}
		int arrA[] = new int[26];
		int arrB[] = new int[26];
		for(int i=0;i<strA.length();i++) {
			queA.addLast(strA.charAt(i));
			queB.addLast(strB.charAt(i));
			arrA[strA.charAt(i)-'A']++;
			arrB[strB.charAt(i)-'A']++;
		}
		for(int i=0;i<26;i++) {
			if(arrA[i]!=arrB[i]) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		int cnt=0;
		boolean flag = false;
		while(!queA.isEmpty()) {
			if(queA.peekLast()==queB.peekLast()) {
				queB.pollLast();
			}else {
				cnt++;
			}
			queA.pollLast();
			 
		}
		System.out.println(flag?-1:cnt);
	}

}
