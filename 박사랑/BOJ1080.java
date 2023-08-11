import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080 {

	static int N, M;
	static boolean[][] map_a, map_b;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map_a=new boolean[N][M];
		map_b=new boolean[N][M];
		
		// input 입력
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			for(int j=0;j<M;j++) {
				if(s.charAt(j)=='1') {
					map_a[i][j]=true;
				}else {
					map_a[i][j]=false;
				}
			}
		}
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			for(int j=0;j<M;j++) {
				if(s.charAt(j)=='1') {
					map_b[i][j]=true;
				}else {
					map_b[i][j]=false;
				}
			}
		}
		
		// 알고리즘 구현
		int cnt=0;
		for(int i=0;i<=N-3;i++) {
			for(int j=0;j<=M-3;j++) {
				if(map_a[i][j]!=map_b[i][j]) {
					cnt++;
					overturn(i,j);
				}
			}
		}
		
		// 똑같이 만들었는지 검사
		boolean flag=true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map_a[i][j]!=map_b[i][j]) flag=false;
			}
		}
		
		if(flag) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
	}
	
	public static void overturn(int r,int c) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				map_a[r+i][c+j]=(!map_a[r+i][c+j]);
			}
		}
	}

}
