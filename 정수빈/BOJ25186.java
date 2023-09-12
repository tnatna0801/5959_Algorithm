import java.util.*;

public class BOJ25186 {
	static int N;
	static long d[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		d = new long[N];
		
		long max = 0;
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			d[i] = sc.nextInt();
			
			sum += d[i];
			
			if(d[i] > max)
				max = d[i];
		}
		
		// 가장 많은 옷의 개수가 전체 절반 이하이면 가능하다
		if(max==1 || max<=sum/2)
			System.out.println("Happy");
		else
			System.out.println("Unhappy");
	}
}
