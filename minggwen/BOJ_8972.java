import java.io.*;
import java.util.*;

public class BOJ_8972{

    static int rows, cols;
    static char[][] grid;
    static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    static LinkedList<Node> crazyArduinoList;
    static Node hero;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());

        grid = new char[rows][cols];
        crazyArduinoList = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            str = bf.readLine();
            for(int j = 0; j < cols; j++) {
                grid[i][j] = str.charAt(j);

                if(grid[i][j] == 'R') crazyArduinoList.add(new Node(i, j));
                else if(grid[i][j] == 'I') hero = new Node(i, j);
            }
        }
        String commands = bf.readLine();

        int moveCount = 1;
        boolean gameOver = false;
        for(int k = 0; k < commands.length(); k++){
            grid[hero.x][hero.y] = '.';
            hero.x = hero.x + dx[commands.charAt(moveCount - 1) - '0'];
            hero.y = hero.y + dy[commands.charAt(moveCount - 1) - '0'];

            if(grid[hero.x][hero.y] == 'R') {
                gameOver = true;
                break;
            }
            grid[hero.x][hero.y] = 'I';

            if(!moveCrazyArduinos()) {
                gameOver = true;
                break;
            }
            moveCount++;
        }

        if(gameOver) System.out.println("kraj " + moveCount);
        else printBoard();
    }

    public static boolean moveCrazyArduinos() {
        int[][] crazyArduinoCount = new int[rows][cols];

        int crazyArduinoSize = crazyArduinoList.size();
        for(int i = 0; i < crazyArduinoSize; i++) {
            Node current = crazyArduinoList.poll();
            grid[current.x][current.y] = '.';

            int dir = findClosestDirection(current);
            int nx = current.x + dx[dir];
            int ny = current.y + dy[dir];

            if(grid[nx][ny] == 'I') return false;
            crazyArduinoCount[nx][ny]++;
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(crazyArduinoCount[i][j] == 1) {
                    grid[i][j] = 'R';
                    crazyArduinoList.add(new Node(i, j));
                }
            }
        }
        return true;
    }

    public static int findClosestDirection(Node current) {
        int min = Integer.MAX_VALUE;
        int minDir = -1;
        for(int i = 1; i <= 9; i++) {
            if(i == 5) continue;
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];
            if(nx < 0 || ny < 0 || nx >= rows || ny >= cols) continue;

            int distance = Math.abs(nx - hero.x) + Math.abs(ny - hero.y);
            if(min > distance) {
                min = distance;
                minDir = i;
            }
        }
        return minDir;
    }

    public static void printBoard() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
