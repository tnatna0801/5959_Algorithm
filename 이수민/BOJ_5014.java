import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {

    static int[] visited;
    static int F, S, G, U, D;

    public static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = 1; // 첫 시작을 1로 둬서 방문하지 않은 요소와 구분
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if (cur == G) return; // 현재 cur가 목표한 값이라면, 반복을 끝냄

            // 올라갈 수 있는 경우
            if (cur+U <= F && visited[cur+U] == 0){
                visited[cur+U] = visited[cur] + 1;
                queue.offer(cur+U);
            }

            // 내려갈 수 있는 경우
            if (cur-D > 0 && visited[cur-D] == 0){
                visited[cur-D] = visited[cur] + 1;
                queue.offer(cur-D);
            }

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F+1];

        if (S == G){
            System.out.println(0);
            return;
        }

        bfs(S);

        System.out.println(visited[G] == 0? "use the stairs" : visited[G]-1);

    }
}
