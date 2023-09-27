import java.io.*;
import java.util.*;

public class BOJ1743 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxSize = 0;
        int N = sc.nextInt(); // 통로 세로 길이
        int M = sc.nextInt(); // 통로 가로 길이
        int K = sc.nextInt(); // 음식물 개수
        int[][] map = new int[N][M]; // 전체 방문 배열 (방문하지 않은 음식물 1) (방문함 2) (아무 것도 아님 0)
        int[][] spot = new int[K][2]; // 좌표 배열

        for(int i=0; i<K; i++) {
            spot[i][0] = sc.nextInt()-1;
            spot[i][1] = sc.nextInt()-1;

            map[spot[i][0]][spot[i][1]] = 1;
        }

        // 가장 큰 음식물의 크기 출력
        for(int i=0; i<K; i++) {
          // 이미 방문되었던 음식물은 재탐색하지 않는다
            if(map[spot[i][0]][spot[i][1]] != 1) continue;

            maxSize = Math.max(maxSize, bfs(map, spot, spot[i][0], spot[i][1], N, M));
        }

        System.out.println(maxSize);
    }

  // 4방향 BFS로 이어져 있는 음식물의 개수를 카운팅하고 리턴한다
    static int bfs(int[][] map, int[][] spot, int x, int y, int N, int M) {
        int dx[] = {-1,1,0,0/*, 1,1,-1,-1*/};
        int dy[] = {0,0,-1,1/*, -1,1,-1,1*/};
        int count = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int info[] = q.poll();
            int xx = info[0];
            int yy = info[1];

            if(map[xx][yy] != 1) continue;
            map[xx][yy] = 2;
            count += 1;

            for(int i=0; i<4/*8*/; i++) {
                int xxx = xx+dx[i];
                int yyy = yy+dy[i];

                if(xxx<0 || xxx>=N || yyy<0 || yyy>=M || map[xxx][yyy] != 1) continue;

                q.add(new int[]{xxx,yyy});
            }
        }

        return count;
    }
}
