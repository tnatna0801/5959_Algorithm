import java.util.*;
import java.io.*;

public class BOJ1182 {
    static int N, K, cnt;
    static int[] num;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    cnt = 0;
    num = new int[N];
    check = new boolean[N];
    
    st = new StringTokenizer(br.readLine(), " ");
    for(int i=0; i<N; i++) {
        num[i] = Integer.parseInt(st.nextToken());
    }
    
    for(int i=0; i<N; i++) {
        check[i] = true;
        dfs(num[i], i);
        check[i] = false;
    }
    
    System.out.println(cnt);
}

    static void dfs(int sum, int idx) {
    	if(sum == K)
    		cnt += 1;
    
    	for(int i=idx; i<N; i++) {
    		if(check[i]) continue;
        
    		check[i] = true;
    		dfs(sum+num[i], i);
    		check[i] = false;
    	}
    }
}
