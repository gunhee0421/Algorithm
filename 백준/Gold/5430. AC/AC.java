import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int c=0; c<T; c++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length()-1);

            Deque<String> q = new ArrayDeque<>();
            if (str.length() > 0) {
                String[] copy = str.split(",");
                q.addAll(Arrays.asList(copy));
            } else{
                q.clear();
            }
            char[] adr = p.toUpperCase().toCharArray();
            AC(q, adr);
        }
        System.out.println(sb);
    }

    static void AC(Deque<String> q, char[] adr) {
        boolean first = true;
        for (int i = 0; i < adr.length; i++) {
            if (adr[i] == 'R') {
                first = !first;
            } else if (adr[i] == 'D') {
                if(q.isEmpty()){
                    sb.append("error\n");
                    return;
                }
                if (first) q.pollFirst();
                else q.pollLast();
            }
        }
        sb.append("[");
        if (!first) {
            while (!q.isEmpty()) {
                sb.append(q.pollLast());
                if (!q.isEmpty()) {
                    sb.append(",");
                }
            }
        } else {
            while (!q.isEmpty()) {
                sb.append(q.pollFirst());
                if (!q.isEmpty()) {
                    sb.append(",");
                }
            }
        }
        sb.append("]\n");
    }
}