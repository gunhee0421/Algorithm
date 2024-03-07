import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            LinkedList<int[]> q = new LinkedList<>();

            for(int j=0; j<t; j++){
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }
            sb.append(serch(q, len) + "\n");
        }
        System.out.println(sb);
    }
    public static int serch(LinkedList<int[]> queue, int target){
        int count=0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean isMax = true;
            for(int i=0; i<queue.size(); i++){
                if(cur[1]<queue.get(i)[1]){
                    queue.offer(cur);
                    for(int j=0; j<i; j++){
                        queue.offer(queue.poll());
                    }
                    isMax=false;
                    break;
                }
            }
            if(isMax){
                count++;
                if (cur[0] == target) {
                    break;
                }
            }
        }
        return count;
    }
}