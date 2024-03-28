import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            answer = new StringBuilder();

            int len = (int) Math.pow(3, n);
            for (int i = 0; i < len; i++) {
                answer.append("-");
            }
            problem(0, len);
            System.out.println(answer);
        }
    }

    public static void problem(int start, int len) {
        if (len == 1) {
            return;
        }
        int size = len / 3;
        for (int i = start + size; i < start + 2 * size; i++) {
            answer.setCharAt(i, ' ');
        }
        problem(start, size);
        problem(start+2*size, size);
    }
}