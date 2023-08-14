import java.util.*;

public class BOJ1911 {
	static int N,L,min;
	static int[][] d;
	public static void main(String [] arsg) {
		Scanner sc = new Scanner(System.in);
		
		// 물웅덩이 개수 N, 널빤지 길이 L
		N = sc.nextInt();
		L = sc.nextInt();
		
		d = new int[N][2];
		min = Integer.MAX_VALUE;
		
		// 물웅덩이 정보
		for(int i=0; i<N; i++) {
			d[i][0] = sc.nextInt();
			d[i][1] = sc.nextInt();
		}
		
		Arrays.sort(d, (o1, o2) -> o1[0] - o2[0]);
		
		// 마지막 널빤지 끝부분 위치+1
		int index = d[0][0];
		
		// 널빤지 카운트 변수
		int count = 0;
		
		for(int i=0; i<N; i++) {
			// index가 d[i][0]보다 작을 경우
			if(index < d[i][0])
				index = d[i][0];
			
			// index가 d[i][0]보다 크거나 같을 경우
			// 계속 진행
			
			for(int j=index; j<d[i][1]; j+=L) {
				index += L;
				count += 1;
			}
		}
		
		System.out.println(count);
	}
}
