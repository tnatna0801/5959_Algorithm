package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_1303 {
	static boolean[][] chk;
	static int flag, n, m;
	static int[][] go;
	static char[][] map;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력 받아오기 배열 사이즈, 배열 내부 값
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 색 별 결과 값 저장할 배열
		int[] color = new int[2];

		// BFS 탐색시 사용할 방향 배열
		go = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		// 방문 체크 배열
		chk = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (chk[i][j])// 이미 탐색한 배열이면 넘어감
					continue;

				int count = bfs(i, j, 0, map[i][j]);// 배열 방문한 만큼의 값을 int로 return

				if (map[i][j] == 'B') {// B일 경우 값을 합함
					color[1] += count * count;
				} else {// W일 경우 값을 합함
					color[0] += count * count;
				}

			}
		}
		// StringBuilder를 통해 출력
		sb.append(color[0] + " ");
		sb.append(color[1]);
		System.out.println(sb.toString());

	}

	private static int bfs(int i, int j, int cnt, char flag) {// cnt를 리턴하는 BFS
		// 초기 시작 위치값 넣어주기
		q.offer(new int[] { i, j });
		chk[i][j] = true;// 방문 체크

		while (!q.isEmpty()) {// 큐 돌리기
			int[] temp = q.poll();
			cnt++;// poll할때마다 카운트 체크

			for (int w = 0; w < 4; w++) {// 4방향 탐색해서 유효값일 경우 Queue에 추가
				int x = temp[0] + go[w][0];
				int y = temp[1] + go[w][1];

				if (checking(x, y, flag)) {// checking 함수에서 유효한지 검사
					q.offer(new int[] { x, y });
					chk[x][y] = true;
				}
			}
		}
		return cnt;
	}

	private static boolean checking(int x, int y, char flag) {// 해당 위치가 유효한 값이고, 방문하지 않았고, 탐색하고자 하는 flag와 같은 값인지 체크
		return (x >= 0 && y >= 0 && x < m && y < n && chk[x][y] == false && map[x][y] == flag);

	}

}
