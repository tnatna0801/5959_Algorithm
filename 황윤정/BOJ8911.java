import java.io.*;

public class BOJ8911 {
	static int[] dc = {0,1,0,-1}; // 상, 우, 하, 좌 방향
	static int[] dr = {1,0,-1,0};
	static int T, minR, maxR, minC, maxC;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			String input = br.readLine();
			int r = 0, c = 0;
			int idx = 0; // dr, dc 배열 인덱스
			minR = 0; // 가장 아래쪽 좌표
			maxR = 0; // 가장 위쪽 좌표
			minC = 0; // 가장 왼쪽 좌표
			maxC = 0; // 가장 오른쪽 좌표
			// 좌표 이동
			for(int i=0; i<input.length(); i++) {
				char now = input.charAt(i); // 1문자씩 처리
				if(now == 'F') { // 현재 좌표에 dr, dc값 더하기 
					r += dr[idx];
					c += dc[idx];
					calc(r,c);
				}
				else if(now == 'B') { // 현재 좌표에 dr, dc값 빼기
					r -= dr[idx];
					c -= dc[idx];
					calc(r,c);
				}
				else if(now == 'R') { // 방향전환 : dr, dc 인덱스 증가
					idx++;
					if(idx > 3) { // dr, dc 순회 인덱스 범위 체크
						idx -= 4;
					}
				}
				else { // 방향전환 : dc, dr 인덱스 감소
					idx--;
					if(idx < 0) {
						idx += 4;
					}
				}
			}
			// 면적 계산
			sb.append(((maxR - minR) * (maxC - minC)) + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static void calc(int r, int c) {
		minR = Math.min(r, minR);
		maxR = Math.max(r, maxR);
		minC = Math.min(c, minC);
		maxC = Math.max(c, maxC);
	}
}
