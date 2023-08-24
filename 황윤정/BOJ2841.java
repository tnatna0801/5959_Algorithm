import java.io.*;
import java.util.*;

public class BOJ2841 {
	static int N, P, result;
	static Stack<Integer>[] stacks;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		stacks = new Stack[N+1]; // 스택 배열 생성
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken()); // 줄 번호
			int plat = Integer.parseInt(st.nextToken()); // 프렛 번호
			
			if(stacks[line] == null) { // 해당 줄 번호 스택 안 만든 경우
				stacks[line] = new Stack<>(); // 스택 객체 만들고
				stacks[line].push(plat); // 프렛 번호 저장
				result++; // 손 움직인 횟수 증가
			}
			else { // 해당 줄 번호 스택 만든 경우
				if(!stacks[line].isEmpty()) { // 스택이 비어있지 않다면
					int top = stacks[line].peek(); // 스택 상단 비교
					if(top > plat) { // 스택 상단의 값이 입력받은 프렛보다 크다면
						while(top > plat) { // 프렛보다 큰 값 다 빼기
							stacks[line].pop();
							result++;
							if(!stacks[line].isEmpty()) { // 스택 비었는지 확인하고
								top = stacks[line].peek(); // top 갱신
							}
							else {
								break; // 뺄거 없으면 탈출
							}
						}
						if(plat != top) { // 같은 프렛 아니면
							stacks[line].push(plat); // 프렛 번호 저장
							result++;
						}
					}
					else if(top < plat) { // 입력받은 프렛이 이전 프렛보다 크면
						stacks[line].push(plat); // 프렛 번호 바로 저장
						result++;
					}
				}
				else { // 스택 비었으면
					stacks[line].push(plat); // 바로 프렛 번호 저장
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
