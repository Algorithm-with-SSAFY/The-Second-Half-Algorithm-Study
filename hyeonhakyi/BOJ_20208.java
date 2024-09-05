package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20208 {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,h,answer = 0,size = 0;
    static Node home;
    static boolean[] visited;
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    home = new Node(i,j);
                }else if(x == 2){
                    list.add(new Node(i,j));
                    size++;
                }
            }
        }

        visited = new boolean[size];
        dfs(home.x, home.y, 0);
        System.out.println(answer);
    }//main end

    public static void dfs(int x,int y,int count){
        for(int i = 0; i < size; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;

            Node node = list.get(i);

            int nx = node.x;
            int ny = node.y;
            int dis = distance(x,y,nx,ny);

            if(dis <= m){
                m += h;
                m -= dis;
                if(distance(home.x, home.y, nx,ny) <= m){
                    answer = Math.max(answer,count+1);
                }
                dfs(nx,ny,count+1);
                m -= h;
                m += dis;
            }
            visited[i] = false;
        }
    }//dfs end


    public static int distance(int x,int y,int sx,int sy){
        return Math.abs(x-sx)+Math.abs(y-sy);
    }//distance end
}//class end
