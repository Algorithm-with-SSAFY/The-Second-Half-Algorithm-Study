
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {

	static boolean map[][];
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N;j++) {
				if(str.charAt(j)=='1') {
					map[i][j] = true;
				}
			}
		}
		compression(0,0,N);
		
		System.out.println(sb.toString());
	}
	private static void compression(int row, int col, int len) {
		if(len<1) {
			sb.append(map[row][col]?1:0);
		}
		if(!check(row,col,len)) {
			sb.append("(");
			compression(row,col,len/2);
			compression(row,col+len/2,len/2);
			compression(row+len/2,col,len/2);
			compression(row+len/2,col+len/2,len/2);
			sb.append(")");
		}else {
			sb.append(map[row][col]?1:0);
		}
	}
	private static boolean check(int row, int col, int len) {
		boolean tmp = map[row][col];
		for(int i=row; i<row+len; i++) {
			for(int j =col; j<col+len; j++) {
				if(map[i][j]!=tmp) {
					return false;
				}
			}
		}
		return true;
	}

}
