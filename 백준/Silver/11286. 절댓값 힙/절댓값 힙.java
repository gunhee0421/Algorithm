import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return -1;
                }
            }
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                pq.offer(n);
            } else {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}