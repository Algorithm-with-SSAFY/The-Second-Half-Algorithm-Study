package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992{
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        DFS(n,0,0);
        System.out.println(sb);
    }//main end

    public static void DFS(int n,int x,int y){
        int size = n/2;
        if(isSame(n,x,y)){
            sb.append(arr[x][y]);
            return;
        }

        sb.append("(");
        DFS(size,x,y);
        DFS(size,x,y+size);
        DFS(size,x+size,y);
        DFS(size,x+size,y+size);
        sb.append(")");
    }//dfs end

    public static boolean isSame(int size,int x,int y){
        int value = arr[x][y];

        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(arr[i][j] != value){
                    return false;
                }
            }
        }
        return true;
    }//isSame end
}//class end
