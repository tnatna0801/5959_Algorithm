import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2688 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			long[] pre = new long[10]; // 이전 자리수의 줄어들지 않는 개수
			long[] cur = new long[10]; // 현재 자리수의 줄어들지 않는 개수
			for(int i=0;i<10;i++) // 1자리수의 경우 0~9에 1씩 초기화 해둡니다
				pre[i]=1;
			for(int i=1;i<n;i++) { // 2자리수부터 n자리수까지 연산합니다!
				// i번째 자리수에 0부터 9까지 중 j라는 수가 왔을 때의 줄어들지 않는 개수는
				// i-1번째 자리에 j보다 큰 수가 왔을 때의 줄어들지 않는 개수를 모두 더해준 값과 같습니다.
				// 위 로직을 풀이하면 아래와 같습니다.
				long sum=0; // 이전 자리수의 줄어들지 않는 개수들을 합칠 sum값입니다
				for(int j=9;j>=0;j--) { //9부터 0까지
					sum+=pre[j]; // 이전 자리수의 줄어들지 않는 개수를 sum에 더해주고
					cur[j]=sum; // 현재 자리수의 줄어들지 않는 개수에 sum을 대입합니다.
				}
				for(int j=0;j<10;j++) // 연산이 끝나면 다음 자리수 연산을 위해 이전 자리수에 현재 자리수 개수를 넣어줍니다.
					pre[j]=cur[j];
			}
			long ans=0;
			for(int i=0;i<10;i++)
				ans+=pre[i]; // 연산이 다 끝난 뒤 n자리에 0부터 9까지 왔을 때의 줄어들지 않는 개수를 모두 더합니다
			System.out.println(ans);
		}
	}
}
