import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8911 {

    // 방향 배열 (<- 반시계방향(L)  / -> 시계방향(R))
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] area; // area[0] max 좌표(x, y) / area[1] min 좌표 (x, y)
    static int[] currentPos; // 현재 거북이의 위치

    static void findMinMax() {
        area[0][0] = Math.max(area[0][0], currentPos[0]);
        area[0][1] = Math.max(area[0][1], currentPos[1]);
        area[1][0] = Math.min(area[1][0], currentPos[0]);
        area[1][1] = Math.min(area[1][1], currentPos[1]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int direction; // 현재 거북이가 보는 방향
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {

            char[] orders = br.readLine().toCharArray();
            direction = 0;
            area = new int[2][2];
            currentPos = new int[2];
            for(char order : orders) {
                if (order == 'L') { // 왼쪽으로 회전.
                    direction = (direction - 1) < 0 ? 3 : direction-1;
                } else if (order == 'R') { // 오른쪽으로 회전.
                    direction = (direction + 1) > 3 ? 0 : direction+1;
                } else if (order == 'F') { // 앞으로 이동
                    currentPos[0] += dx[direction];
                    currentPos[1] += dy[direction];
                } else { // 뒤로 이동
                    currentPos[0] -= dx[direction];
                    currentPos[1] -= dy[direction];
                }
                findMinMax();
            }
            System.out.println((area[0][0]-area[1][0])*(area[0][1]-area[1][1]));

        }

    }
}
