import java.io.*;
import java.util.*;

public class BOJ5397 {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			char[] input = br.readLine().toCharArray();
			Deque<Character> deque = new ArrayDeque<>(); // 데이터 담는 덱 (메인 저장)
			Stack<Character> tmp = new Stack<>(); // 커서 옮길 때 최근 값 이동하는 임시 스택
			for(int i=0; i<input.length; i++) {
				if(input[i] == '<') { // 커서를 왼쪽으로 옮길 때
					if(deque.size() > 0) {
						tmp.push(deque.pollLast()); // 이전 값이 덱의 최상위에 있도록 커서 밖의 값을 tmp로
					}
				}
				else if(input[i] == '>') { // 커서를 오른쪽으로 옮길 때
					if(tmp.size() > 0) {
						deque.offerLast(tmp.pop()); // 이전에 커서이동으로 tmp에 옮겨둔 값 있으면 덱으로 이동
					}
				}
				else if(input[i] == '-') { // 현재 커서에 있는 값 제거
					if(deque.size() > 0) {
						deque.pollLast(); // 덱에 마지막으로 들어온 값 삭제 
					}
				}
				else { // 대소문자 추가
					deque.offerLast(input[i]); // 덱에 데이터 추가
				}
			}
			while(!tmp.isEmpty()) {
				deque.offerLast(tmp.pop()); // 왼쪽 커서 이동으로 tmp에 옮겨둔 값을 모두 덱으로 합치기
			}
			while(!deque.isEmpty()) {
				sb.append(deque.pollFirst()); // 덱에 처음 들어온 수부터 내보내기
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}