import java.io.*;
import java.util.*;

public class BOJ1189 {
    static int R,C,K,result; // 행,열,거리,결과
    static char[][] arr; // 지도 정보
    static boolean[][] visited; // 방문 배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        visited[R-1][0] = true; // 시작점 방문처리
        dfs(1, R-1, 0);
        System.out.println(result); // 결과 출력
    }

    public static void dfs(int dist, int r, int c) {
        if(dist == K) { // 이동한 거리가 K이고
            if(r == 0 && c == C-1) { // 집까지 도착한 경우
                result++; // 결과 변수 증가
            }
            return;
        }
        for(int i=0; i<4; i++) {
            if(r+dr[i] < 0 || r+dr[i] >= R || c+dc[i] < 0 || c+dc[i] >= C) {
                continue; // 4방향 이동 시 배열 범위 체크
            }
            if(!visited[r+dr[i]][c+dc[i]] && arr[r+dr[i]][c+dc[i]] == '.') {
                // 다음으로 이동할 곳이 아직 방문하지 않았고 갈 수 있는 곳일 때
                visited[r+dr[i]][c+dc[i]] = true; // 지나간 곳은 방문하지 않음
                dfs(dist+1, r+dr[i], c+dc[i]); // 이동거리 증가시키고 이동
                visited[r+dr[i]][c+dc[i]] = false; // 다른길도 탐색하기 위해 방문해제
            }
        }
    }
}
