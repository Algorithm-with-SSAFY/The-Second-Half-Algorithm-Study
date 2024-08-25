import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_15927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean flag = false;
		int len = str.length();

		for(int i=0;i<len/2;i++) {
			if(str.charAt(i)!=str.charAt(len-i-1)) {
				System.out.println(len);
				System.exit(0);
			}
			if(str.charAt(i)!=str.charAt(i+1)) {
				flag = true;
			}
		}
		System.out.println(flag?len-1:-1);
	}

}
