import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class ShortCut{
    int to;
    int distance;

    ShortCut(int to, int distance){
        this.to = to;
        this.distance = distance;
    }
}

public class BOJ_1446 {

    static int N, D;
    static int[] road;
    static ArrayList<ShortCut>[] shortcuts;

    public static void findShortCut() {
        for(int i=0; i<=D; i++) {
            if (i > 0) // 현재 지름길의 최솟값을 갱신
                road[i] = Math.min(road[i], road[i-1] + 1);

            // 현재 위치에서 시작되는 지름길이 없으면 바로 다음 위치 검사
            if (shortcuts[i] == null) continue;

            // 현재 위치에서 시작되는 지름길들을 순회하며 가장 짧은 길을 찾는다.
            for(ShortCut shortCut : shortcuts[i]){
                int to = shortCut.to;
                int dist = shortCut.distance;

                road[to] = Math.min(road[to], road[i]+dist);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // dp 배열의 기본값 설정
        road = new int[D+1];
        for(int i=0; i<=D; i++) road[i] = i;
        shortcuts = new ArrayList[D+1]; // 지름길 정보를 저장하는 ArrayList 배열

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // 지름길이 될 수 없는 정보이면 저장하지 않는다.
            if (from > D || to > D || to-from<=dist) continue;

            if (shortcuts[from] == null)
                shortcuts[from] = new ArrayList<>();
            shortcuts[from].add(new ShortCut(to, dist));

        }

        findShortCut();
        System.out.println(road[D]);
    }
}
