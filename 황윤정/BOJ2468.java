import java.io.*;
import java.util.*;

public class BOJ2468 {
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, result = 1;
	// result=1 : 잠기지 않는 경우를 고려한 초기값 설정
	static int N; 
	static int[][] arr; // 데이터 입력
	static boolean[][] visited; // 방문 배열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max); // 물 최대
				min = Math.min(arr[i][j], min); // 물 최소
			}
		}
		for(int i=min; i<max; i++) { // 물 최소 범위부터 최대범위 전까지(최대범위 포함하면 어차피 다 잠김)
			int safe=0; // 안전한 영역 개수
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(!visited[j][k] && arr[j][k] > i) { // 아직 방문안하고 && 물에 안 잠길때만
						bfs(j, k, i); // bfs로 영역 탐색
						safe++; // 찾은 영역 하나씩 증가
					}
				}
			}
			for(int j=0; j<N; j++) {
				Arrays.fill(visited[j], false); // 물 깊이 바꾸기전에 방문배열 초기화
			}
			result = Math.max(result, safe); // 안전한 영역 최대값
		}
		System.out.println(result);
	}
	
	static void bfs(int row, int col, int water) {
		Queue<int[]> q = new LinkedList<>();
		int[] dr = {-1, 0, 1, 0}; // 위부터 시계방향
		int[] dc = {0, 1, 0, -1};
		
		// 4방향 탐색
		q.add(new int[]{row, col});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			for(int i=0; i<4; i++) {
				int nextR = r+dr[i];
				int nextC = c+dc[i];
				if(nextR >= 0 && nextR < N &&
						nextC >= 0 && nextC < N) { // 배열 범위 초과 체크
					if(!visited[nextR][nextC] && arr[nextR][nextC] > water) {
						// 갈 수 있는곳(방문안함 && 물에 안잠긴 곳)이라면
						q.add(new int[] {nextR, nextC}); // 간다
						visited[nextR][nextC] = true;
					}
				}
			}
		}
	}
}