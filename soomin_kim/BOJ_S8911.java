import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S8911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        // 좌표기준, 왼쪽으로 90도 돈 다고 가정한다. 오른쪽으로 90도 돌 때는 배열을 역순으로 돌면 된다.
        int[] dx = {0, -1, 0, 1}; // 위쪽, 왼쪽, 아래쪽, 오른쪽
        int[] dy = {1, 0, -1, 0}; //

        while (t-- > 0) {

            int currentDirection = 0; // 현재 방향! L or R

            int[] currentPos = new int[2]; // 현재 좌표 저장
            int[] maxPos = {0, 0}; // max x,y
            int[] minPos = {0, 0}; // min x,y

            st = new StringTokenizer(br.readLine());
            String[] order = st.nextToken().split("");

            for (int i = 0; i < order.length; i++) {
                if (order[i].equals("F")) { // 앞으로
                    currentPos[0] += dx[currentDirection];
                    currentPos[1] += dy[currentDirection];
                } else if (order[i].equals("B")) { // 뒤로
                    currentPos[0] -= dx[currentDirection];
                    currentPos[1] -= dy[currentDirection];
                } else if (order[i].equals("L")) { // 왼쪽으로 90도
                    if(currentDirection == 3) currentDirection = 0; // 방향 범위 0~3을 넘어가면 처리
                    else currentDirection++;
                } else if (order[i].equals("R")) {
                    if(currentDirection == 0) currentDirection = 3; // 방향 범위 0~3을 넘어가면 처리
                    else currentDirection--;
                }

                // max x,y 구하기
                findMinMax(currentPos, maxPos, minPos);
            }

            //넓이 구하기
            int row = maxPos[0] - minPos[0];
            int col = maxPos[1] - minPos[1];

            sb.append(row * col).append("\n");
        }
        System.out.print(sb);
    }

    private static void findMinMax(int[] currentPos, int[] maxPos, int[] minPos) {
        maxPos[1] = Math.max(currentPos[1], maxPos[1]);
        maxPos[0] = Math.max(currentPos[0], maxPos[0]);

        // min x,y 구하기
        minPos[1] = Math.min(currentPos[1], minPos[1]);
        minPos[0] = Math.min(currentPos[0], minPos[0]);
    }

}