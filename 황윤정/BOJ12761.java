import java.io.*;
import java.util.*;

public class BOJ12761 {
	static int A,B,N,M;
	static int result = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
    
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // 시작 위치
		M = Integer.parseInt(st.nextToken()); // 목표 위치
		visited = new boolean[100001];
		bfs();
		System.out.println(result);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N,0}); // 큐에 현재 위치, 이동 횟수 저장
		visited[N] = true;
		int[] nums = new int[8]; // 이동 예정 위치 저장
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == M) { // M에 도착했다면 이동 횟수 최솟값 저장
				result = Math.min(now[1], result);
			}
			else {
				nums[0] = now[0]*A;
				nums[1] = now[0]*B;
				nums[2] = now[0]+A;
				nums[3] = now[0]+B;
				nums[4] = now[0]+1;
				nums[5] = now[0]-1;
				nums[6] = now[0]-A;
				nums[7] = now[0]-B;
				for(int i=0; i<8; i++) { // 갈 수 있는 모든 경우 탐색
					if(nums[i] < 0 || nums[i] > 100000 || visited[nums[i]]) {
						// 이동범위를 벗어나거나 이미 방문한 곳 거르기
						continue;
					}
					q.add(new int[] {nums[i], now[1]+1}); // 이동한 위치와 이전 이동 횟수+1 저장
					visited[nums[i]] = true; // 방문 처리
				}
			}
		}
	}
}
