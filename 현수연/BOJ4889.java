import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in = br.readLine().toCharArray(); // 문자열 입력
		StringBuilder sb = new StringBuilder(); // 출력할 StringBuilder
		int no=1; // 테스트 케이스 번호
		while(in[0]!='-') { // 만일 한개이상의 -가 입력될 경우 종료
			sb.append(no++).append(". ");
			int openNum=0, closeNum=0, cnt=0; // 여는 괄호 개수, 닫는 괄호 개수, 연산 수
			for(int i=0;i<in.length;i++) { // 문자열 크기만큼 반복
				if(in[i]=='{') // '{'일 경우
					openNum++; // 여는 괄호 개수 카운팅
				else {			// '}'일 경우
					if(closeNum>=openNum) { // 닫는 괄호 개수가 여는 괄호 개수 이상일 경우 ('{'이 아직 앞에 없는데 '}'이 온 경우)
						// '}'을 '{'로 바꿔주는 연산을 진행
						openNum++; // 여는 괄호 개수 카운팅
						cnt++;		// 연산 수 카운팅
					}
					else // 여는 괄호 개수가 닫는 괄호 개수보다 클 경우 ('}'앞에 짝이 될'{'이 있을경우)
						closeNum++; // 닫는 괄호 개수 카운팅
				}
			}
			if(openNum>closeNum) { // 여는 괄호 개수가 아직 많이 남아 있을 경우
				// 짝이 되는 경우를 모두빼고, 남은 여는 괄호의 절반을 '}'로 바꿔주는 연산 진행
				cnt+=(openNum-closeNum)/2; //연산 수 카운팅
			}
			sb.append(cnt).append("\n"); // 결과 StringBuilder에 추가
			in = br.readLine().toCharArray(); // 다음 문자열 입력받기
		}
		System.out.println(sb); // 최종 출력
	}
}
