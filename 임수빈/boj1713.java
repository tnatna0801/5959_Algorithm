import java.io.*;
import java.util.*;

public class boj1713 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 사진 개수
        int t = Integer.parseInt(br.readLine()); // 추천 횟수

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c = o1[1] - o2[1]; // 추천 횟수
                if (c == 0) {
                    return o1[2] - o2[2]; // 추천 시간
                }
                return c;
            }
        });

        int[][] students = new int[101][3]; // 학생 번호, 추천수, 넣은 시간

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<t; i++) {
            int s = Integer.parseInt(st.nextToken());

            // 현재 투표받은 학생이 사진 틀에 있는 경우
            if (queue.contains(students[s])) {
                // 꺼내기
                queue.remove(students[s]);
                // 추천수만 증가
                students[s][1]++;
                // 다시 삽입
                queue.add(students[s]);
                continue;
            }

            // 사진 틀이 모두 차 있는 경우
            if (queue.size() >= n) {
                // 꺼내기
                queue.poll();
            }

            // 새로 삽입
            students[s] = new int[]{s, 1, i};
            queue.add(students[s]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            answer.add(queue.poll()[0]); // 정답에 추가
        }

        Collections.sort(answer);
        while (!answer.isEmpty()) {
            sb.append(answer.remove(0) + " ");
        }

        System.out.println(sb);
    }
}
