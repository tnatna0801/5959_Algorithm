import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		StringBuilder sb = new StringBuilder();
		int arr[][]= new int[10001][2]; // dp배열
		// arr[n][m] -> n : 구하게 될 수 / m : 2, 3을 하나 제하고 얻을 수 있는 경우의 수에 대한 인덱스 값
		// 1로만 구성된 수, 2가 적어도 하나라도 구성된 수, 3이 적어도 하나라도 구성된 수를 모두 따로 dp로서 계산을 진행했습니다
		arr[2][0] = 1; // 2를 사용하여 2를 구하는 수
		arr[3][0] = 1; // 2를 사용하여 3을 구하는 수
		arr[3][1] = 1; // 3을 사용하여 3을 구하는 수
		for (int i = 4; i <= 10000; i++) { // 4부터 10000까지 1, 2, 3을 이용하여 구하는 수를 연산
			arr[i][0] = 1 + arr[i - 2][0];
			arr[i][1] = 1 + arr[i - 3][0] + arr[i - 3][1];
		}
		for (int testcase = 0; testcase < T; testcase++) { // 테스트케이스 경우만큼 반복
			int ans;
			int n = Integer.parseInt(br.readLine()); // n을 입력받아
			ans = 1 + arr[n][0] + arr[n][1]; // 모든 경우의 수를 더하여 답을 출력
			sb.append(ans).append("\n");
		}
		System.out.println(sb); // 최종 답 출력
	}
}
