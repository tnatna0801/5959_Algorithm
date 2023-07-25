import java.util.*;
import java.io.*;

public class Main {

	static long [] lens;
	static int K, N;
	static long max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
		K = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		lens = new long[K];
		max = 0;
   
		for(int i=0; i<K; i++)
			lens[i] = Integer.valueOf(br.readLine());
    
		Arrays.sort(lens);
		binary(0, lens[K-1]+1);
		System.out.print(max);
	}

	static void binary(long left, long right) {
		while (left < right) { 
    	
			long mid = (left + right) / 2;
			long sum = 0;
    	
			for(int i=K-1; i>=0; i--)
				sum += (lens[i]/mid);
        	
			if(sum >= N) {
				max = max < mid ? mid : max;
				left = mid+1;
			}
			else
				right = mid;
		}
	}
}
