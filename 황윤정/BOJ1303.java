import java.io.*;
import java.util.*;

public class BOJ1303 {
	static int N, M, white, blue; // 배열 크기, 병사들 위력의 합
	static char[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M][N];
		visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<M; i++) { // 배열 탐색
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) { // 아직 방문하지 않았다면
					bfs(i, j); // 간다
				}
			}
		}
		System.out.println(white+" "+blue); // 결과 출력
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int[] dr = {-1, 0, 1, 0}; // 4방향 이동(상-우-하-좌)
		int[] dc = {0, 1, 0, -1};
		int cnt=0; // 연속되는 병사의 수
		boolean isEnemy=false;
		queue.add(new int[] {r,c}); // 시작점
		visited[r][c] = true;
		cnt++;
		if(arr[r][c] == 'B') { // 시작점이 B면 적군들 찾기
			isEnemy = true;
		}
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = now[0]+dr[i]; // 다음 방문 후보 좌표
				int nc = now[1]+dc[i];
				if(nr < 0 || nr >= M || nc < 0 || nc >= N) // 범위 체크
					continue; // 범위 넘으면 방문 안함
				if(!visited[nr][nc] && arr[nr][nc] == arr[now[0]][now[1]]) {
					// 아직 방문안했고 같은 병사라면
					queue.add(new int[] {nr, nc}); // 큐에 add
					visited[nr][nc] = true; // 방문 처리
					cnt++; // 병사 수 증가
				}
			}
		}
		if(!isEnemy) { // 적군 플래그 아니면
			white += cnt*cnt; // 아군 위력 변수에 병사 수 제곱 더하기
		}
		else {
			blue += cnt*cnt; // 적군 위력 변수에 병사 수 제곱 더하기
		}
	}
}
