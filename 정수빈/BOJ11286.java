import java.util.*;
import java.io.*;

public class BOJ11286 {
	
	public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    Queue<Integer> q = new PriorityQueue<>((o1, o2) -> { 	    
	    	int a = Math.abs(o1);
	    	int b = Math.abs(o2);
	    
	    	// 절댓값이 같으면 수가 더 큰 쪽이 우선
	    	if(a == b) return o1 > o2 ? 1 : -1;
	    	// 절댓값이 더 큰 쪽이 우선
	    	if(a > b) 		return a - b;
	    	// 절댓값이 더 작은 쪽은 찬밥
	    	else    		return -1;
	    });
	    
	    for(int i=0; i<N; i++) {
	    	int n = Integer.parseInt(br.readLine());
	    	
	    	if(n == 0) {
	    		// 배열에서 절댓값이 가장 작은 값을 출력 & 제거
	    		Integer value = q.poll();
	    		
	    		if(value == null)	System.out.println(0);
	    		else 	  			System.out.println(value);
	    	}
	    	else {
	    		// 배열에 삽입
	    		q.add(n);
	    	}
	    }
	}
}
