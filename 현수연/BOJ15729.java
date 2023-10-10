import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15729 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int button[] = new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			// 쪽지에 적힌 배열 입력
			button[i]=Integer.parseInt(st.nextToken());
		int result[] = new int[N]; // 모드 꺼져있는 처음의 상태인 버튼 배열
		int cnt=0; // 버튼 누르는 횟수
		for(int i=0;i<N;i++) {
			// 처음부터 탐색하여 쪽지값과 다른 경우, 버튼 배열(result)을 갱신해줍니다
			if(button[i]!=result[i]) {
				for(int j=i;j<i+3;j++) {
					if(j>=N) continue;
					if(result[j]==1)
						result[j]=0;
					else
						result[j]=1;
				}
				// 갱신될 때마다 버튼 누르는 횟수를 카운트해줍니다
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
