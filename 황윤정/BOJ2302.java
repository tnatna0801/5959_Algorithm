import java.io.*;
import java.util.*;

public class BOJ2302 {
	static int N, M;
	static int[] vip;
	static int[] dp;
	static int result = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		vip = new int[M];
		for (int i = 0; i < M; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[41];
		initDp();
		getSeat();
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
	
	static void initDp() {
		//dp 배열 초기화
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
	}
	
	static void getSeat() {
		// vip석 사이의 좌석수 구하기
		int start = 0;
		for(int v : vip) {
			result *= dp[v - start - 1];
			start = v;
		}
		result *= dp[N-start];
	}
}
