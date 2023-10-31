import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1504 {

    // 간선 정보
    static class Node implements Comparable<Node> {
        int end;
        long weight;

        Node(int end, long weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (weight - o.weight);
        }
    }
    static List<Node>[] list;
    static int INF = 200000000; // 간선의 최대 개수 * 가중치의 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 리스트 초기화
        list = new ArrayList[N+1];
        for (int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        // 간선 정보 넣기
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 정점1
            int b = Integer.parseInt(st.nextToken()); // 정점2
            int c = Integer.parseInt(st.nextToken()); // 정점 1, 2 사이의 가중치

            // 양방향이므로 이렇게 넣었습니다.
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        // 필수 정점 입력
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 필수 정점을 지나쳐오게 하기 2가지 경우가 있지유
        // 1 => v1 => v2 => N
        long result1 = 0;
        result1 = dijstra(1, v1, N) + dijstra(v1, v2, N) + dijstra(v2, N, N);

        // 1 => v2 => v1 => N
        long result2 = 0;
        result2 = dijstra(1, v2, N) + dijstra(v2, v1, N) + dijstra(v1, N, N);

        // 
        if(result1 >= INF && result2 >= INF) System.out.println(-1);
        else System.out.println(Math.min(result1, result2));

    }

    private static long dijstra(int start, int end, int N) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1]; // 방문 체크
        long[] dist = new long[N+1]; // 길이 저장 배열
        Arrays.fill(dist, INF); // 길이 초기화

        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node current = q.poll();
            int to = current.end;

            if(visited[to]) continue;
            visited[to] = true;

            for(Node node : list[to]){ // to에서 다른 정점까지의 최소길이 구하기
                if(!visited[node.end] && dist[node.end] > dist[to] + node.weight){ // 방문체크 및 최소 길이인지 확인
                    dist[node.end] = dist[to] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end]; // 목적지까지 경로 길이를 출력
    }
}
