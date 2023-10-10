import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1743번
 * 음식물 피하기
 */
public class BOJ1743 {

    static int N,M,K;
    static int[][] map;
    static int result, cnt;
    static int[] dx={-1,1,0,0}; // 행 - 상하좌우
    static int[] dy={0,0,-1,1}; // 열
    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            map[r-1][c-1]=1; // 음식물 쓰레기가 있다
        }
        // 음식물 쓰레기 탐색
        result=0;
        cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1){
                    bfs(i,j);
                    result=Math.max(result,cnt);
                    cnt=0;
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs(int r,int c){
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(r,c));
        map[r][c]=0;
        cnt++;
        while(!q.isEmpty()){
            Point now=q.poll();
            for(int i=0;i<4;i++){
                int next_x= now.x+dx[i];
                int next_y= now.y+dy[i];
                if(next_x<0||next_x>=N||next_y<0||next_y>=M)
                    continue;
                if(map[next_x][next_y]==1){
                    cnt++;
                    map[next_x][next_y]=0;
                    q.offer(new Point(next_x,next_y));
                }
            }
        }
    }
}
