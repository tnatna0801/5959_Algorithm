import java.io.*;
import java.util.*;

class Beer implements Comparable<Beer> {
    int preference; // 선호도
    int level; // 도수 레벨

    public Beer(int preference, int level) {
        this.preference = preference;
        this.level = level;
    }

    @Override
    public int compareTo(Beer o) {
    	// 도수 레벨 기준 오름차순으로 정렬
        int c = this.level - o.level;
        // 도수 레벨이 같다면 선호도 기준 내림차순으로 정렬
        if (c == 0) {
            return o.preference - this.preference;
        }
        return c;
    }
}

public class boj17503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Beer[] beers = new Beer[k];
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i] = new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(beers);

        // 우선순위 큐
        PriorityQueue<Beer> queue = new PriorityQueue<>(new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
            	// 선호도 기준 오름차순 정렬
                return o1.preference - o2.preference;
            }
        });

        int sum = 0; // 선호도의 합
        int answer = -1;

        for (int i=0; i<k; i++) {
        	// 맥주를 마신다.
            queue.add(beers[i]);
            sum += beers[i].preference;

            // n보다 많은 맥주를 마셨을 경우 빼준다.
            if (queue.size() > n) {
                sum -= queue.poll().preference;
            }

            // n만큼 맥주를 마셨고 선호도의 합이 m 이상일 경우 정답
            if (queue.size() == n && sum >= m) {
            	// Beer을 도수 레벨 기준으로 오름차순 정렬해놨기 때문에 현재 값이 최솟값이다.
                answer = beers[i].level;
                break;
            }
        }

        System.out.println(answer);
    }
}
