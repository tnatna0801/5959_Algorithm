
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17503 {

    static class Beer {
        int prf; // 선호도
        int lv; // 도수 레벨

        public Beer(int prf, int lv) {
            this.prf = prf;
            this.lv = lv;
        }
    }

    public static void main(String[] args) throws IOException {

        int N, M, K;
        PriorityQueue<Beer> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.lv == o2.lv) { // 도수가 같으면 선호도가 높은 것부터
                return o2.prf - o1.prf;
            }
            return o1.lv - o2.lv; // 도수가 작은 것부터
        });

        PriorityQueue<Beer> drink = new PriorityQueue<>((o1, o2) -> {
            if (o1.prf == o2.prf) { // 선호도가 같으면 도수가 높은 대로
                return o2.lv - o1.lv;
            }
            return o1.prf - o2.prf; // 선호도가 작은 것부터
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) { // pq에 맥주 종류를 넣어준다
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            pq.add(new Beer(p, l));
        }


        long now_prf = 0; // 현재 선호도

        while (!pq.isEmpty()) {
            Beer now = pq.poll(); // pq의 우선순위 대로 poll

            now_prf += now.prf;
            drink.add(now);

            if (drink.size() >= N) { // N병이 됐을 때
                if (now_prf >= M) { // 선호도 만족함
                    break;
                }
                // 만족못함
                // 젤 쓸모없는 거(현재 가지고 있는 것 중에 우선순위 제일 낮은 거) 삭제
                Beer del = drink.poll();
                now_prf -= del.prf;
            }
        }

        if (now_prf < M) { // 선호도를 만족시키는 경우가 없음
            System.out.println(-1);
        } else { // drink중에 레벨의 최댓값 출력
            int max=0;
            for(int i=0;i<N;i++){
                max=Math.max(max, drink.poll().lv);
            }
            System.out.println(max);
        }
    }
}
