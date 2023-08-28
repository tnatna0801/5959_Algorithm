import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{ // x, y좌표를 가지고있는 노드 클래스 입니다.
		int x;
		int y;
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
	static boolean[][] visited;
	static int n,m;
	static char[][] board;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); // n열과 m행을 입력받습니다
		int Wcnt=0, Bcnt=0; // 우리팀인 흰병사와 적팀인 파란병사 카운팅 변수입니다
		visited = new boolean[m][n];  // 방문 2차원 배열입니다
		board = new char[m][n];  // 병사들이 서있는 전투지 2차원 배열입니다.
		for(int i=0;i<m;i++)
			board[i]=br.readLine().toCharArray();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) { // 아직 방문하지 않았는데
					if(board[i][j]=='W') // 흰병사 W일 경우
						Wcnt+=bfs(new Node(i,j)); // 흰병사 카운팅에 bfs값을 넣어줍니다
					else
						Bcnt+=bfs(new Node(i,j)); // 파란병사 카운팅에 bfs값을 넣어줍니다
				}
			}
		}
		sb.append(Wcnt).append(" ").append(Bcnt);
		System.out.println(sb); // StringBuilder에 저장하여 출력합니다
	}
	static int bfs(Node node) { // bfs 함수입니다
		Queue<Node> queue = new ArrayDeque<>();
		char temp = board[node.getX()][node.getY()]; // 첫 노드의 문자형 값을 저장해둡니다
		
		queue.offer(node); // 첫 노드를 큐에 넣어줍니다
		visited[node.getX()][node.getY()]=true; // 첫 노드를 방문 체크합니다
		int cnt=1; // 카운팅 값을 하나 올립니다
		
		while(!queue.isEmpty()) {  // 큐가 빌 때까지 반복합니다
			Node current = queue.poll();  // 큐에 있는 노드 값을 꺼내서 현재 노드값으로서 사용합니다
			for(int i=0;i<4;i++) {  // 상하좌우 방향으로 탐색합니다
				Node next = new Node(current.getX()+dx[i],current.getY()+dy[i]);
				if(next.getX()<0||next.getX()>=m||next.getY()<0||next.getY()>=n)
					continue;  // 전투지에서 벗어나는 노드일 경우 continue 해줍니다
				if(board[next.getX()][next.getY()]==temp  // 상하좌우로 이동한 값이 첫 노드와 동일할 경우
						&&!visited[next.getX()][next.getY()]) { // 그리고 아직 해당 이동한 전투지를 아직 방문하지 않았을 경우
					queue.offer(next); // 큐에 이동한 노드를 넣어줍니다
					visited[next.getX()][next.getY()]=true; // 그리도 해당 노드 방문 체크합니다
					cnt++; // 카운팅 값을 올려줍니다
				}
			}
		}
		return cnt*cnt; // 최종적으로 얻은 카운팅 값의 제곱값을 return합니다
	}
}
