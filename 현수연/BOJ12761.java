import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// BFS 함수 호출 및 출력
		System.out.println(BFS(A,B,N,M,new boolean[100001]));
		
	}
	static int BFS(int A, int B, int N, int M, boolean[] visited) {
		int move[] = {1, -1, A, -A, B, -B}; // 이동 및 점프
		int jump[] = {A, B}; // 배수 점프
		Queue<Integer> q = new ArrayDeque<>(); // 위치 큐
		q.offer(N); // 첫 위치 offer
		int cnt=0; // 이동한 횟수
		while(!q.isEmpty()) { // 큐가 빌 때까지 반복
			int size = q.size(); // 큐 현재 사이즈 입력
			for(int i=0;i<size;i++) { // 사이즈만큼 반복 후, 이동횟수 갱신
				int pos = q.poll(); // 현재 위치 poll
				if(pos==M) // 도달하고자하는 위치가 나올 경우 이동횟수 return
					return cnt;
				for(int j=0;j<6;j++) { // 이동 및 점프 탐색
					int nextPos = pos+move[j]; // 다음 위치 설정
					if(nextPos<0||nextPos>100000||visited[nextPos]) continue; // 범위를 벗어나거나 이미 방문했으면 continue
					visited[nextPos]=true; // 방문 체크
					q.offer(nextPos); // 큐 offer
				}
				for(int j=0;j<2;j++) { // 배수 점프 탐색
					int nextPos = pos*jump[j];
					if(nextPos<0||nextPos>100000||visited[nextPos]) continue;
					visited[nextPos]=true;
					q.offer(nextPos);
				}
			}
			cnt++; // 횟수 갱신
		}
		return 0;
	}
}
