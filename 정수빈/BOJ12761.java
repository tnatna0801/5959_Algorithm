import java.util.*;

public class BOJ12761 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        if(N != M) {
            // bfs
            int result = bfs(A, B, N, M);

            System.out.println(result);
        }
        else
            System.out.println(0);
    }

    static int bfs(int A, int B, int N, int M) {
        int maxSize = 100000;
        Queue<int[]> q = new ArrayDeque<>();
        boolean check[] = new boolean[maxSize+1];
        int[] d1 = {-1, 1, A, B, -1 * A, -1 * B};
        int[] d2 = {A, B};

        // 위치, 이동 횟수
        q.add(new int[]{N, 0});
        check[N] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int location = info[0];
            int move = info[1];

            for (int i = 0; i < 6; i++) {
                int newlct = location + d1[i];

                // 새로 계산한 location 값이 범위를 벗어나지 않고 방문하지 않았을 때
                if (0 > newlct || newlct > maxSize || check[newlct]) continue;
                if (newlct == M) return (move + 1); // M에 도달하면 그 경우는 더 이상 탐색하지 않는다

                check[newlct] = true;
                // System.out.println(newlct + " : " + (move + 1));
                q.add(new int[]{newlct, (move + 1)});
            }
            for (int i = 0; i < 2; i++) {
                int newlct = location * d2[i];

                if (0 > newlct || newlct > maxSize || check[newlct]) continue;
                if (newlct == M) return (move + 1);

                check[newlct] = true;
                // System.out.println(newlct + " : " + (move + 1));
                q.add(new int[]{newlct, (move + 1)});
            }
        }

        return -1;
    }
}
