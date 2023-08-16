import java.io.*;
import java.util.*;

public class boj1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 물웅덩이 개수
        int n = Integer.parseInt(st.nextToken());
        // 널빤지 길이
        int l = Integer.parseInt(st.nextToken());

        int[][] puddle = new int[n][2];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // 물웅덩이 시작 위치
            puddle[i][0] = Integer.parseInt(st.nextToken());
            // 물웅덩이 끝 위치
            puddle[i][1] = Integer.parseInt(st.nextToken());
        }

        // 물웅덩이 시작 위치를 기준으로 정렬
        Arrays.sort(puddle, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 널빤지를 덮기 시작할 위치
        int start = 0;
        // 널빤지 개수
        int answer = 0;

        for (int[] p: puddle) {
            // 널빤지를 덮을 위치가 물웅덩이 시작 위치보다 작으면 물웅덩이 시작 위치로 바꿔준다.
            start = (start < p[0])? p[0] : start;

            // 물웅덩이가 끝날 때까지 널빤지를 덮어준다.
            while (start < p[1]) {
                start += l;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
