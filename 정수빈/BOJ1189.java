import java.util.*;

public class BOJ1189 {
	static int dx[]={0,0,-1,1}, dy[]={-1,1,0,0};
    static int R, C, K, count;
	static char map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();

		map = new char[R][C];
		count = 0;

		for(int i=0; i<R; i++)
		      map[i]=sc.next().toCharArray();

        map[R-1][0]='T';
		 dfs(R-1, 0, 1);

		 System.out.println(count);
	}
    
	// 위치 x, y, count
	static void dfs(int x, int y, int dist) {
		if(x==0 && y==C-1)
			if(dist == K)
			   count += 1;
		

		// 4방향 탐색
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];

			if(xx<0 || xx>=R || yy<0 || yy>=C)
			    continue;

			if(map[xx][yy]=='T')
			    continue;

			 // map에 T 표시해 놓고 백트래킹
			map[xx][yy]='T';
			dfs(xx, yy, dist+1);
			map[xx][yy]='.';
		}
	}
}
