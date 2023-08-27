import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S11060 {
    static int n;
    static int[] miro;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        miro = new int[n];
        for (int i = 0; i < n; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(0));
    }


    public static int bfs(int index) {
        //int min = 1001;
        boolean[] visited = new boolean[n];
        int depth = 0; //횟수
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{index, depth});
        visited[index] = true;
        while (!q.isEmpty()) {

            int[] current = q.poll();
            int currentIndex = current[0];
            int currentJump = miro[current[0]];
            depth = current[1];
            //visited[currentIndex] = true;

            if (currentIndex == n - 1) { //배열의 끝까지 점프했다면 횟수 비교!
                return depth;
            }

            if (currentJump == 0) { // 아무곳으로도 못 감
                continue;
            }

            for (int i = 1; i <= currentJump; i++) {
                int nextIndex = currentIndex + i;
                if (nextIndex >= n || visited[nextIndex]) continue;
                visited[nextIndex] = true;
                q.add(new int[]{nextIndex, depth + 1});
            }
        }
        return -1;
    }
}


