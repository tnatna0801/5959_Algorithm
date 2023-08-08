import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

public class Main {
	static int n;
	static boolean visited[][];
	static int graph[][];
	static int[] dx = { 1, 0, -1, 0};
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];

		int min_height = 100, max_height = 0;
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(str[j]);
				min_height = Math.min(min_height, graph[i][j]);
				max_height = Math.max(max_height, graph[i][j]);
			}
		}
		int max_cnt = 0;
		for (int height = min_height; height <= max_height; height++) {
			int cnt = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][j] >= height && visited[i][j] == false) {
						q.offer(new Node(j, i));
						visited[i][j] = true;
						bfs(height);
						cnt++;
					}
				}
			}
			max_cnt = Math.max(max_cnt, cnt);
		}
		System.out.println(max_cnt);
	}

	public static void bfs(int height) {
		while (!q.isEmpty()) {
			Node nowNode = q.poll();
			int x = nowNode.getX();
			int y = nowNode.getY();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (graph[ny][nx] >= height && visited[ny][nx] == false) {
					q.offer(new Node(nx, ny));
					visited[ny][nx] = true;
				}
			}
		}
	}
}
