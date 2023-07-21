import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_S2302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 좌석 개수
		int n = Integer.parseInt(br.readLine());
		// 경우의 수를 저장할 배열
		int[] dp = new int[n + 1];

		//vip석 개수
		int vip_n = Integer.parseInt(br.readLine());
		int[] vip = new int[vip_n];
		
		//vip석 좌석 번호 입력
		for (int i = 0; i < vip_n; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
		
		//경우의 수 구하기
		dp[0] = 1; //좌석이 0개일 경우 경우의 수는 1가지
		dp[1] = 1; //좌석이 1개일 경우 경우의 수는 1가지
		for (int i = 2; i <= n; i++) {
			//점화식 
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int count = 0; //연속되는 좌석 개수를 저장할 변수
		int result = 1; //총 경우의 수를 저장할 변수
		int index = 0; //vip[] 배열을 탐색하기 위한 인덱스
		
		// 좌석 개수만큼 반복문을 돌면서 총 경우의 수를 구한다.
		// 0~vip[0] * vip[0]~vip[1]
		for (int i = 1; i <= n; i++) {
			if (index < vip_n) { // index가 배열의 범위를 벗어나는 경우를 방지
				if (i == vip[index]) { 
					result *= dp[count]; //vip석을 제외한 연속되는 좌석의 경우의 수들을 곱한다.(동시에 일어나니까 곱한다.)
					count = 0; //연속되는 좌석 개수 초기화
					index++;
				}
				else
					count++;
			} else
				count++;
		}
		//* vip[1]~n
		result *= dp[count];

		System.out.println(result);
	}
}
