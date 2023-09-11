import java.io.*;
import java.util.*;

public class BOJ1446 {
    static int N, D; // 지름길 개수, 고속도로의 길이
    static ArrayList<Road> shortcut; // 지름길 정보 저장
    static int[] dist; // 해당 점까지 오는데 필요한 최소 거리
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortcut = new ArrayList<>();
        dist = new int[D+1];
        for(int i=0; i<N; i++) { // 지름길 입력받기
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작 위치
            int d = Integer.parseInt(st.nextToken()); // 도착 위치
            int l = Integer.parseInt(st.nextToken()); // 길이
            if(d > D || l >= d-s) // 지름길이 더 멀거나, 목적지가 D보다 큰 경우(역주행 불가)
                continue; // 거르기
            shortcut.add(new Road(s,d,l)); // 지름길 리스트 추가
        }
        Collections.sort(shortcut, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return o1.start - o2.start; // 시작 위치가 빠른순으로 지름길 리스트 정렬
            }
        });
        Arrays.fill(dist, 10001); // 거리 배열 초기화
        dist[0] = 0;
        int idx=0; // 지름길 리스트 접근
        for(int i=0; i<=D; i++) {
            if(i > 0 && dist[i] > dist[i-1]+1) {
                dist[i] = dist[i-1]+1; // 직전 거리+1 하는 것보다 현재 거리 값이 크면 갱신
            }
            // 지름길 리스트 인덱스 체크 && 현재 위치 i에서 지름길을 이용할 수 있다면
            while(idx < shortcut.size() && shortcut.get(idx).start == i) {
                Road shortRoad = shortcut.get(idx); // 지름길 후보
                // 이미 저장된 지름길 목적지까지의 거리와 지름길을 이용하는 거리 중 작은 값으로 거리 배열에 저장
                dist[shortRoad.end] = Math.min(dist[shortRoad.end],
                        dist[shortRoad.start] + shortRoad.len);
                idx++; // 지름길 리스트 접근 인덱스 증가
            }
        }
        System.out.println(dist[D]); // 목적지까지 가는데 필요한 최소 거리 출력
    }
}

class Road {
    int start; // 지름길 시작 위치
    int end; // 지름길 도착 위치
    int len; // 지름길 길이

    public Road(int start, int end, int len) {
        this.start = start;
        this.end = end;
        this.len = len;
    }
}
