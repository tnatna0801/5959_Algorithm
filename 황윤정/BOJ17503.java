import java.io.*;
import java.util.*;

public class BOJ17503 {
    static int N, M, K, result=-1;
    static ArrayList<Beer> beers; // 맥주 선호도, 도수 레벨 저장
    static PriorityQueue<Integer> likes; // 선호도 저장(최소힙)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        likes = new PriorityQueue<>();
        beers = new ArrayList<>();
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            beers.add(new Beer(like, level));
        }

        // 맥주 정렬(1. 도수 낮은순, 2. 선호도 높은순)
        Collections.sort(beers, new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                if(o1.level == o2.level) { // 도수가 같으면
                    return o2.like - o1.like; // 선호도가 높은 순으로 정렬
                }
                else {
                    return o1.level - o2.level; // 도수가 낮은 순으로 정렬
                }
            }
        });

        int likeSum=0;
        for(Beer beer : beers) {
            likes.add(beer.like); // 도수가 낮은 맥주부터 선호도를 우선순위큐에 넣음
            likeSum += beer.like; // 선호도 합 구하기

            if(likes.size() > N) { // 우선순위큐의 사이즈가 N 초과하면
                likeSum -= likes.poll(); // 가장 선호도가 낮은 맥주 빼기
            }
            // 우선순위 큐의 사이즈가 N보다 같고 누적된 선호도 합이 M 이상이면
            if(likes.size() == N && likeSum >= M) {
                result = beer.level; // 맥주 도수 갱신
                break; // 바로 종료
            }
        }
        System.out.println(result);
    }
}

class Beer {
    int like;
    int level;
    public Beer(int like, int level) {
        this.like = like;
        this.level = level;
    }
}
