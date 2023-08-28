import java.io.*;
import java.util.*;

public class boj1303 {

	static int n, m;
	
	static char[][] array;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static HashMap<Character, Integer> map = new HashMap<>();
	static int[] answer = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		array = new char[m][n];
		for (int i=0; i<m; i++) {
			array[i] = br.readLine().toCharArray();
		}
		
		// 흰색 병사들은 answer[0], 파란색 병사들은 answer[1]에 저장하기 위해 map으로 관리함.
		map.put('W', 0);
		map.put('B', 1);
		
		visited = new boolean[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				// 방문한 적이 없으면 bfs
				if (!visited[i][j]) {
					// 같은 팀의 병사들의 수를 세고 제곱해서 정답에 추가
					int cnt = bfs(i, j);
					answer[map.get(array[i][j])] += cnt * cnt;
				}
			}
		}
		
		// 정답 출력
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<2; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
		

	}

	static int bfs(int x, int y) {
		int cnt = 1; // 같은 팀 병사들의 수
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		char target = array[x][y]; // 어떤 팀인지
		
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			x = q[0];
			y = q[1];
			
			for (int i=0; i<4; i++) {
				// 이동
				int mx = x + dx[i];
				int my = y + dy[i];
				
				// 범위 벗어나면 통과
				if (mx < 0 || mx >= m || my < 0 || my >= n) {
					continue;
				}
				
				// 이미 방문한 적 있으면 통과
				if (visited[mx][my]) {
					continue;
				}
				
				// 같은 팀이 아니면 통과
				if (array[mx][my] != target) {
					continue;
				}
				
				// 개수 늘리고 큐에 넣기
				queue.add(new int[] {mx, my});
				visited[mx][my] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
}
