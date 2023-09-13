import java.io.*;
import java.util.*;

public class BOJ2468 {
    
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static boolean[][] check;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
    public static void main(String[] args) throws Exception {
	
    	// 행 열 개수
        N = Integer.parseInt(br.readLine());
        
        // 개수대로 배열 생성
        map = new int[N][N];
        
        // 최대 최소 구하기 위한 배열
        int[] val = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        
    	 for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		val[0] = Math.min(val[0], map[i][j]);
    			val[1] = Math.max(val[1], map[i][j]);
        	}
        }
    	
        // 최댓값 저장할 변수
        int max_count = 0;

      // 최소-1 ~ 최대-1 (모두 잠기지 않을 경우 고려, 모두 잠길 경우 안 고려)
        for(int k=val[0]-1; k<val[1]; k++) {
        	// 최댓값 구할 변수
        	int count = 0;
        	check = new boolean[N][N];
        	
	        for(int i=0; i<N; i++) {
	        	for(int j=0; j<N; j++) {
        			// k보다 크고, 체크 되지 않은 경우
	        		if(map[i][j] > k && !check[i][j]) {
	        			// 한 번의 호출로 이어진 하나의 영역 검사
	        			check[i][j] = true;
	        			search(i, j, k);
	        			count += 1;
	        		}
        		}
        	}
	        
	        // static 카운트 변수 vs 현재 최댓값 비교해 저장
			max_count = Math.max(max_count, count);
        }
        
        System.out.println(max_count);
    }
    
    
    // 4 방향 검사
    static void search(int x, int y, int k) {
    	for(int i=0; i<4; i++) {
    		int xx = x+dx[i];
    		int yy = y+dy[i];
    		
    		if(xx < 0 || xx >= N || yy < 0 || yy >= N || map[xx][yy] <= k || check[xx][yy])
    			continue;
    		
    		check[xx][yy] = true;
    		
    		// 사방을 갈 수 없을 때까지 재귀
    		search(xx, yy, k);
    	}
    }
}
