import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    static int N;
    static char map[][];

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        split(0, 0, N);
        System.out.println(sb);

    }
    static void split(int startY, int startX, int size) {
        if (check(startY, startX, size)) {
            sb.append(map[startY][startX]);
        }
        else {
            sb.append("(");
            split(startY, startX, size/2);
            split(startY, startX + size/2, size/2);
            split(startY + size/2, startX, size/2);
            split(startY + size/2, startX + size/2, size/2);
            sb.append(")");
        }
    }
    static boolean check(int startY, int startX, int size) {
        char tmp = map[startY][startX];
        for (int y = startY; y < startY + size; y++) {
            for (int x = startX; x < startX + size; x++) {
                if (map[y][x] != tmp)
                    return false;
            }
        }
        return true;
    }


}
