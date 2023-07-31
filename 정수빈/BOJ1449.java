import java.util.*;
import java.io.*;

public class BOJ1449 {

    static int[] n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        n = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        
        
        for(int i=0; i<N; i++)
        	n[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(n);
        
        // 테이프 개수
        int cnt = 0;
        // 이전 테이프 위치
        int tape = -L;
        
        for(int i=0; i<N; i++) {
        	int num = n[i];
        	
        	if(tape <= num) {
        		tape = num+L;
        		cnt += 1;
        	}
        	//System.out.printf("%d)--%d-%d--%d\n",i, num, tape, cnt);
        }
        
        System.out.println(cnt);
    }
}
