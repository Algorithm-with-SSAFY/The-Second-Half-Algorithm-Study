package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904 {
    public static char answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Moo(num);

        System.out.println(answer);
    }

    public static void Moo(int num) {
        int size = 3;
        int index = 0;

        if (num == 1) {
            answer = 'm';
        } else if (num <= 3)
            answer = 'o';
        else {
            while (size < num) {
                size = size * 2 + index + 4;
                index++;
            }

            int front_back = (size - index - 3) / 2;

            if (size - front_back + 1 <= num) {
                Moo(num - size + front_back);
            } else if (num == front_back + 1)
                answer = 'm';
            else
                answer = 'o';
        }
    }
}
