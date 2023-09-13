package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1342 {
	static char[] in;
	static int[] result, chk,alpha;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		in = br.readLine().toCharArray();
		
		result = new int[in.length];	//순열 넣을 배열
		alpha=new int[26];//알파벳 카운트 배열
		for(char c:in) {//입력받은 char형 값을 카운트 해준다
			alpha[c-'a']++;
		}
		ans = 0;//답 초기화

		permu(0);//순열을 진행한다
		
		System.out.println(ans);//결과 출력
	}

	private static void permu(int cnt) {

		if (cnt == in.length) {
			ans++;
			return;
		}
		for (int i = 0; i < 26; i++) {//알파벳 크기만큼 반복
			if (alpha[i]<1||(cnt>0 && i == result[cnt - 1]))//해당 알파벳 수를 다 사용했거나, 이전 값과 같은 알파벳이면 continue
				continue;
			alpha[i]--;//사용시 카운트 하나 지워줌
			result[cnt] = i;// result배열에 값 넣어주기
			permu(cnt + 1);//재귀 호출
			alpha[i]++;//다시 ++로 반환
		}
	}

}
