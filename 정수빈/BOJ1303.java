import java.util.*;

public class BOJ1303 {
	
	static int tmp, wsum, bsum, N, M;
	static char map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		tmp = 0;
		wsum = 0;
		bsum = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[M][N];
		
		for(int i=0; i<M; i++)
			map[i] = sc.next().toCharArray();
		
		//bfs
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'c')
					continue;
				
				char team = map[i][j];
				map[i][j] = 'c';
				dfs(i, j, team);
				
				if(team == 'B')
					bsum += (int)Math.pow((tmp+1), 2);
				else if(team == 'W')
					wsum += (int)Math.pow((tmp+1), 2);
				
				tmp = 0;
			}
		}
		
		System.out.println(wsum + " " + bsum);
		
	}
	
	static void dfs(int x, int y, char team) {
		if(x<0||x>=M||y<0||y>=N)
			return;
		
		for(int i=0; i<4; i++) {
        	int xx = x+dx[i];
        	int yy = y+dy[i];
        	
            if(xx<0||xx>=M||yy<0||yy>=N||map[xx][yy]!=team)
            	continue;
           
            map[xx][yy] = 'c';
            tmp += 1;
            
            dfs(xx, yy, team);
        }
	}
}
