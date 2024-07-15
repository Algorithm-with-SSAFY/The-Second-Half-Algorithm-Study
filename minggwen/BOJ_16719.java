import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16719 {

	static String str;
	static String MINSTR;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		str = br.readLine();
		visited = new boolean[str.length()];
		dfs(0,str.length()-1);
		System.out.println(sb.toString());
		
	}
	private static void dfs(int left,int right) {
		if(left>right) return;
		int idx = left;
		for(int i=left;i<=right;i++) {
			if(str.charAt(idx)>str.charAt(i)) {
				idx=i;
			}
		}
		visited[idx] = true;
		for(int i=0;i<str.length();i++) {
			if(visited[i]) {
				sb.append(str.charAt(i));
			}
		}
		sb.append("\n");
		dfs(idx+1,right);
		dfs(left,idx-1);
	}

}
