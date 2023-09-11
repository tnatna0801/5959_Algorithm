import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // Pn의 n 입력
		int M = Integer.parseInt(br.readLine()); // 문자열 S의 크기 입력
		int cnt=0; // Pi(이 때 i는 1이상의 특정 수)의 크기
		int ans=0; // Pn의 개수 변수
		char pre='0'; // 문자열 안을 검토한 이전 값 ('0'으로 초기화시켜준 이유는 처음엔 이전 값이 없어서 아무거나 넣어줬습니다)
		char cur;  // 문자열 안을 검토한 현재 값
		char[] in = br.readLine().toCharArray(); // 입력받은 문자열을 char 배열로 변환시켜 줍니다!
		for (int i = 0; i < M; i++) { // 문자열 크기만큼 검토를 진행합니다!
			cur = in[i]; // 현재 값
			if(cnt==0&&cur=='I') // 혹시 아직 Pi의 카운팅을 시작하지 않았고, 현재 값이 I로 시작할 경우
				cnt++; // Pi의 크기로서 카운팅을 하나 올려줍니다!
			else if(cur!=pre) // 이전 값과 현재 값이 다를 경우
				cnt++; // Pi가 아직 끝나지 않은 것으로 계속 크기를 세줍니다
			else { // 만일 Pi가 아닐 경우,(이전값과 동일한 값이 나올 경우)
				if(cur=='I') cnt=1; // II의 경우 다시 I부터 카운팅해야하기 때문에 카운팅 값을 1로
				else cnt=0; // OO의 경우 I가 나오면 카운팅을 시작해야하기 때문에 카운팅 값을 0으로 만들어줍니다
			}
			if(cnt>=N*2+1&&cnt%2==1) // 만일 현재 Pi의 값이 Pn의 크기와 같거나 크면서 홀수일 경우 (Pn이 문자열에서 발견!)
				ans++; // Pn의 개수를 카운팅해줍니다 
			pre=cur; // 마지막으로 이전 값에 현재 값을 넣어주고 문자열 크기만큼 다시 반복해줍니다
		}
		System.out.println(ans); // 최종적으로 모두 카운팅한 답을 출력합니다
	}
}
