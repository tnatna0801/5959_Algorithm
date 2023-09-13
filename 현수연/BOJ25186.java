import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 옷의 종류를 입력 받습니다.
		long sum = 0; // 사람 수
		int max = 0; // 한 종류의 옷에 대한 최대 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int d = Integer.parseInt(st.nextToken()); // 한 종류의 옷에 대한 개수
			sum += d; // 최종 사람 수를 구하는 식
			max = Math.max(d, max); // 한 종류의 옷을 최대한 몇명이 돌려입을 수 있는지 구하는 식
		}
		if(sum==1) // 만일 사람 수가 한명일 경우
			System.out.println("Happy"); // 조건 만족
		else if(max>sum/2) // 만일 한 종류의 옷이 전체 사람 수의 절반보다 많을 경우
			System.out.println("Unhappy"); // 조건 불만족
		else
			System.out.println("Happy"); // 나머지 조건 만족
	}
}
