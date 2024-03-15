import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        int[] number = new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
        
        int count = 0; int strat=0; int end=number.length-1;
        while(strat<end){
            if(number[strat]+number[end]==M){
                count++;
                strat++;
            }else if(number[strat]+number[end]>M){
                end--;
            }else if(number[strat]+number[end]<M){
                strat++;
            }
        }
        System.out.println(count);
    }
}