package cocodingding;
//안전영역

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2468 {
	static int[][]chk;
	static int n;
	static int[][] map;
	static Queue<int[]>q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		int[][] turn= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//방향 탐색(동, 남, 서, 북)
		int max=0;
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				max=Math.max(max, map[i][j]);//물 높이 설정을 위해 최대 값 설정
			}
		}
		int cnt_max=0;//최대 부분 체킹
		for(int k=0;k<max;k++) {
			int cnt=0;
			chk=new int[n][n];//새로운 물 높이 마다 chk를 초기화
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(chk[i][j]!=1 &&map[i][j]>k) {//물높이가 k 보다 높고 아직 간적 없는 곳일 때
						int [] cur= new int[]{i,j};
						chk[i][j]=1;
						q=new LinkedList<>();
						q.offer(cur);//큐에 시작 값 넣어주기
						bfs(q,turn,k);//bfs 돌리기
						cnt++;//돌린 수 = 안전지대 1개
					}
				}
			}
			cnt_max=Math.max(cnt_max, cnt);//카운트 최대 값을 매번 교체
		}
		System.out.println(cnt_max);
	}
	
	public static void bfs(Queue<int[]>q, int[][] turn, int k) {
		
		while(!q.isEmpty()) {
			int[] now=q.poll();
	
			
			for(int i=0;i<4;i++) {//방향 4번 탐색
				if(now[0]+turn[i][0]>=0 && now[0]+turn[i][0]<n && now[1]+turn[i][1]>=0 && now[1]+turn[i][1]<n 
						&& chk[now[0]+turn[i][0]][now[1]+turn[i][1]]!=1 && map[now[0]+turn[i][0]][now[1]+turn[i][1]]>k) {//해당 idx 할 값들이 범위에 넘지 않고, chk하지 않았던 곳, k보다 물높이가 높은 경우 일때
					int[]temp= {now[0]+turn[i][0], now[1]+turn[i][1]};
					chk[temp[0]][temp[1]]=1;//방문 체킹 해주기
					q.offer(temp);//큐에 값 넣기
				}
			}
		}
	}

}
