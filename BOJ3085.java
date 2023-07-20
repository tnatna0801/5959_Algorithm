import java.util.*;
import java.io.*;

class BOJ3085 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] c;
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        c = new char[N][N];
       
        for(int i=0; i<N; i++)
        	c[i] = br.readLine().toCharArray();

        for(int i=0; i<N; i++) {
        	for(int j=0; j<N-1; j++) {
        		for(int k=1; k<3; k++) {
        			int x = i+dx[k];
        			int y = j+dy[k];
        			
        			if(x < 0 || x >= N) continue;
        			
        			if(c[i][j] == c[x][y]) {
        				max = Math.max(max, searchSeq(i, j));
        			}
        			
        			else {
        				changeValue(i, j, x, y);

        				max = Math.max(max, searchSeq(i, j));
        				max = Math.max(max, searchSeq(x, y));

        				changeValue(i, j, x, y);
        			}
        		}
        	}
        }
        
        System.out.println(max-1);
    }
    public static void changeValue(int i, int j, int x, int y) {    	
    	char temp = c[i][j];
    	c[i][j] = c[x][y];
    	c[x][y] = temp;
    }
    
    public static int searchSeq(int x, int y) {    	
    	int[] sum = new int[2];
    	
    	for(int i=0; i<4; i++) {
    		int dxx = dx[i];
    		int dyy = dy[i];
			int xx = x+dxx;
     		int yy = y+dyy;
     		
     		while(xx >= 0 && xx < c[0].length && yy >= 0 && yy < c[0].length && c[x][y] == c[xx][yy]) {
     			xx += dxx;
         		yy += dyy;
     		}
     		
     		sum[(i+2)/2-1] += Math.abs(xx-x+yy-y);
    	}
    	
    	return Math.max(sum[0], sum[1]);
    }
}