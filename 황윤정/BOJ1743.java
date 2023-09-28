import java.io.*;
import java.util.*;

public class BOJ1743 {
    static int N,M,K,result; // 세로길이, 가로길이, 쓰레기 개수, 가장 큰 음식물 크기
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<int[]> trash = new ArrayList<>(); // 음식물 쓰레기 위치 저장
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r][c] = 1; // 음식물 있는 자리 표시
            trash.add(new int[] {r,c});
        }

        for(int i=0; i<K; i++) {
            int[] now = trash.get(i); // 음식물 쓰레기 좌표 1개씩
            if(!visited[now[0]][now[1]]) { // 아직 개수를 세지 않은 곳이라면
                result = Math.max(result,bfs(now)); // 가장 큰 쓰레기 크기 구하기
            }
        }
        System.out.println(result);
    }

    static int bfs(int[] start) {
        int[] dr = {-1,0,1,0}; // 4방향 접근
        int[] dc = {0,1,0,-1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;
        int cnt=0; // 근처의 음식물 수
        while(!q.isEmpty()) {
            int[] now = q.poll();
            cnt++;
            for(int i=0; i<4; i++) {
                int nextr = now[0]+dr[i];
                int nextc = now[1]+dc[i];
                if(nextr <= 0 || nextr > N || nextc <= 0 || nextc > M) {
                    continue; // 범위 체크
                }
                if(!visited[nextr][nextc] && arr[nextr][nextc] == 1) {
                    // 다음 방향이 아직 방문 안했고 음식물이 있는 경우
                    q.add(new int[] {nextr, nextc}); // 다음 음식물
                    visited[nextr][nextc] = true;
                }
            }
        }
        return cnt;
    }
}
