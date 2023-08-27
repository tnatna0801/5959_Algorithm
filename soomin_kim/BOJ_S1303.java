package w0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1303 {
	static int width;
	static int height;
	static String[][] army;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken()); // 가로크기
		height = Integer.parseInt(st.nextToken()); // 세로크기

		//입력
		army = new String[height][width];
		for (int i = 0; i < height; i++) {
			army[i] = br.readLine().split("");
		}
		
		int blue = 0; // 적팀 파워
		int white = 0; // 우리팀 파워
		visited =  new boolean[height][width];
	
		//for문 돌면서 같은 색깔 탐색
		for(int y = 0; y < height; y++) {
			for(int x = 0; x<width; x++) {
				if(!visited[y][x]) {
					count = 0; //같은색이 몇개 있는지 저장하는 변수
					visited[y][x] = true; //방문처리
					dfs(y,x);
					if(army[y][x].equals("B")) {
						blue += count * count;
					}
					else {
						white += count * count;
					}
				}
			}
			
		}
		
		System.out.println( white + " " + blue);

	}

	public static void dfs(int y, int x) { 
		
		String current = army[y][x];
		count++;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (!isAvailable(current, nextY, nextX))
				continue;
				
			visited[nextY][nextX] = true;
			dfs(nextY, nextX);
		}

	}

	// 탐색 가능한지 판별하는 메소드
	private static boolean isAvailable(String current, int nextY, int nextX) {
		return nextX >= 0 && nextY >= 0 && nextX < width && nextY < height 
				&& !visited[nextY][nextX] && current.equals(army[nextY][nextX]);
	}
}
