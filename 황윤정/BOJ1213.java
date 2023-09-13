import java.io.*;
import java.util.*;

public class BOJ1213 {
	static int[] alpha = new int[26];
	static char[] result;
	static ArrayList<Character> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		for(int i=0; i<input.length(); i++) {
			list.add(input.charAt(i));
		}
		Collections.sort(list);
		int N = list.size();
		result = new char[N];
		
		// 짝수인 경우
		if(N % 2 == 0) { 
			// 앞뒤 맞춰서 list의 문자로 팰린드롬 만들기
			int res = fillChar(N);
			if(res == -1) {
				return;
			}
		}
		// 홀수인 경우
		else { 
			// 1. 배열에 각 문자별 개수 저장
			for(int i=0; i<N; i++) {
				alpha[list.get(i)-'A']++;
			}
			int oddCnt=0;
			char oddCh='A';
			for(int i=0; i<alpha.length; i++) {
				if(alpha[i] % 2 != 0) {
					oddCnt++;
					oddCh = (char)('A' + i);
				}
			}
			// 2. 홀수인 문자가 2개 이상이면 팰린드롬 만들기 불가
			if(oddCnt > 1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
			// 3. 홀수인 문자 1개를 마지막 한개에 끼우도록 빼두기
			for(int i=0; i<N; i++) {
				if(list.get(i) == oddCh) {
					list.remove(i);
					break;
				}
			}
			// 4. 짝수 개수 문자끼리 앞뒤 맞춰서 채우고, 남은자리에 빼놓은 문자채워서 팰린드롬 완성
			int last = fillChar(N);
			if(last == -1) {
				return;
			}
			result[last] = oddCh; 
		}
		for(int i=0; i<N; i++) {
			sb.append(result[i]);
		}
		System.out.println(sb.toString());
	}
	
	// ArrayList에서 앞뒤 쌍을 맞춰서 result에 문자를 채우는 메서드
	static int fillChar(int N) {
		int low=0, high=N-1;
		for(int i=0; i<N-1; i+=2) {
			// 문자 매칭 안되는 경우 바로 종료
			if(list.get(i) != list.get(i+1)) {
				System.out.println("I'm Sorry Hansoo");
				return -1;
			}
			// 투포인터로 처음, 끝 가리키면서 2개 문자쌍 채워나가기
			result[low++] = list.get(i);
			result[high--] = list.get(i+1);
		}
		return low;
	}
}
