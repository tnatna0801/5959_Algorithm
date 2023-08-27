import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6236 {

	static int[] money;
	static int n, m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		money = new int[n];
		int tmp=0;
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
			tmp=Math.max(tmp, money[i]);
		}

		int min = tmp;
		int max = 100000 * 10000;
		int mid = 0;
		int result = 0;
    
		while (min <= max) {
			mid = (max + min) / 2;
			if (checking(mid)) { // k=mid으로 가능
				max = mid - 1;
        result = mid;
			} else { // k=mid으로 불가능
				min = mid + 1;
			}
		}
		System.out.println(result);
	}

	public static boolean checking(int k) { // 매개변수 k로 M번 입출금 가능한지 체크하는 함수
		int remain = 0;
		int chance = 0;
		for (int i = 0; i < n; i++) {
			if (remain < money[i]) { // 남은 돈이 오늘 쓸 돈 보다 적을 때 돈을 다시 넣음
				remain = k;
				chance++;
			}
			remain -= money[i]; // 출금
		}
		if (chance > m) {
			return false;
		} else return true;
	}
}
