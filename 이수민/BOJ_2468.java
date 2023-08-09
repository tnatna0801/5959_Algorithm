import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int n;
    static int[][] map; // 지역

    // 주변 지역을 살피기 위한 좌표 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        Set<Integer> height = new HashSet<>(); // 중복없이 지역의 높이를 담는다.
        height.add(0); // 물 높이가 0인 경우
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                height.add(a);
            }
        }

        int max = 0;
        Iterator<Integer> iterator = height.iterator();
        while(iterator.hasNext()) { // 지역의 높이를 물의 높이로 가정하여 안전한 영역을 구한다.
            max = Math.max(max, findArea(iterator.next()));
        }

        System.out.println(max);

    }
    public static int findArea(int height) {
        int area = 0;
        boolean[][] isVisited = new boolean[n][n]; // 방문 확인을 위한 배열

        Queue<int[]> queue = new ArrayDeque<int[]>(); // 안전한 영역의 범위 확인(bfs)을 위한 큐

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 지점마다 접근하여, 이 지점이 안전한 영역이고 아직 방문한 적이 없다면 큐에 넣고 새로운 영역이 시작됨을 설정함
                if(map[i][j] > height && !isVisited[i][j]) {
                    queue.offer(new int[]{i, j});
                    area++;
                }

                // bfs - 현재 안전한 영역의 범위를 확인
                while(!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    isVisited[pos[0]][pos[1]] = true;
                    for (int k=0; k<4; k++) {
                        int tmpx = pos[0] + dx[k];
                        int tmpy = pos[1] + dy[k];
                        // 이동할 영역이 배열의 범위 내이고, 안전한 영역이고 아직 방문한 적이 없다면 현재 영역에 포함할 수 있다.
                        if (tmpx>=0 && tmpx<n && tmpy>=0 && tmpy<n && map[tmpx][tmpy]>height && !isVisited[tmpx][tmpy]) {
                            queue.offer(new int[]{tmpx, tmpy});
                            isVisited[tmpx][tmpy] = true;
                        }
                    }
                }
            }
        }

        return area; // 현재 물 높이(height)에 대한 안전한 영역의 개수를 반환
    }
}
