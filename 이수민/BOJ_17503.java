import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Beer implements Comparable<Beer>{
    int prefer;
    int level;

    Beer(int prefer, int level){
        this.prefer = prefer;
        this.level = level;
    }

    @Override
    public int compareTo(Beer o) {
        return this.level - o.level;
    }
}
public class BOJ_17503 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Beer[] beers = new Beer[K];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i] = new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(beers);

        // 지금까지 포함된 맥주의 선호도가 오름차순으로 저장됨
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int sum = 0;
        int maxLevel = -1;
        for(Beer beer : beers){
            queue.offer(beer.prefer); // 맥주의 선호도 추가
            sum += beer.prefer; // 합에도 현재 맥주의 선호도 더해줌

            if (queue.size() > N){
                sum -= queue.poll(); // 마실 수 있는 맥주의 수가 N을 넘어가면 가장 적은 선호도를 빼주고 queue에서 제거
            }

            // 마실 수 있는 맥주가 N개이고, 선호도가 M보다 크거나 같으면 조건을 만족하므로 탈출
            if (queue.size() == N && sum >= M){
                // beers가 도수 순으로 정렬되어 있었으므로 가장 최근 맥주의 도수가 가장 클 것
                maxLevel = beer.level;
                break;
            }

        }

        System.out.println(maxLevel);
    }
}
