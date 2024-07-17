import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] temp = new char[R][C];
        char[][] answer = new char[R][C];

        for (int y = 0; y < R; y++) {
            char[] tmp = br.readLine().toCharArray();
            for (int x = 0; x < C; x++) {
                answer[y][x] = tmp[x];
                temp[y][x] = 'O';
            }
        }

        if (N % 2 == 0) {
            printMap(temp);
            return;
        } else if (N == 1) {
            printMap(answer);
            return;
        }

        for (int i = 3; i <= N; i += 2) {
            answer = boom(answer, temp);
            temp = setting(R, C);
        }
        printMap(answer);
    }

    public static void printMap(char[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                sb.append(map[y][x]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static char[][] boom(char[][] answer, char[][] temp) {
        //char[][] nxtTemp = new char[answer.length][answer[0].length];
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        for (int y = 0; y < answer.length; y++) {
            //Arrays.fill(nxtTemp[y], 'O');
            for (int x = 0; x < answer[0].length; x++) {
                if(answer[y][x] == 'O') {
                    temp[y][x] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if(ny >= 0 && ny < answer.length && nx >= 0 && nx < answer[0].length) {
                            temp[ny][nx] = '.';
                        }
                    }
                }
            }
        }
        //System.out.println("폭파");
        return temp;
    }

    public static char[][] setting(int r, int c) {
        char[][] result = new char[r][c];
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                result[y][x] = 'O';
            }
        }
        return result;
    }
}
