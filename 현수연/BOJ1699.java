import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1]; // 입력받은 수+1만큼 dp 배열 (저장하며 연산)
		for(int i=1;i<=N;i++)
			dp[i]=i; // 1로만 가득 채워진 값을 미리 넣어둡니다
		for(int i=2;i<=N;i++) { 
			// 2이상의 제곱수를 고려해 주되, i보다 작은 수에서 연산을 진행합니다
			for(int j=2;j*j<=i;j++) {
				// 만약 특정 제곱수를 제외하고 저장된 dp값 중 최소값을 저장합니다
				dp[i]=dp[i]<dp[i-j*j]+1?dp[i]:dp[i-j*j]+1;
			}
		}
		System.out.println(dp[N]);
	}
}
