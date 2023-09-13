import java.util.*;

public class BOJ16401 {
	static int M, N;
	static long max, lengths[];
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt(); // M 명의 조카
		N = sc.nextInt(); // N 개의 과자
		
		lengths = new long[N];
		
		for(int i=0; i<N; i++) {
			lengths[i] = sc.nextLong();
		}
		
		Arrays.sort(lengths);
		
		max = 0; // 막대 과자의 최대 길이
		
		binarySearch(1, lengths[N-1]);
		
		System.out.println(max);
	}
	
	// 이분 탐색으로 최대 길이를 설정하면서, 그리디 하게 검사한다
	static void binarySearch(long left, long right) {
	    while(left <= right) {
	    	
	    	long mid = (left+right)/2;
	    	//System.out.println(left + " " + right + " " + mid);
	    	
	    	// 성공했을 경우 길이를 늘려 본다
	    	if(check(mid)) {
	        	max = mid;
	        	left = mid+1;
	    	}
	    	// 실패했을 경우 줄여 본다
	    	else {
	    		right = mid-1;
	    	}
	    }
	}
	
	// 뒤에서부터 할당량 채울 수 있는지 확인한다
	static boolean check(long value) {
		int count = 0;
		
		for(int i=N-1; i>=0; i--) {
			if(lengths[i]/value == 0) break;
			
			else count += lengths[i]/value;

			if(count >= M) return true;
		}
		
		//System.out.println("count:"+count);
		if(count >= M)
			return true;
		else
			return false;
	}
}
