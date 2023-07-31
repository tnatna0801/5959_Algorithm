import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
        int l = Integer.parseInt(st.nextToken()); // 테이프의 길이

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 물이 새는 곳의 위치들을 저장할 큐
        while(st.hasMoreTokens()){
            queue.add(Integer.parseInt(st.nextToken())); // 물이 새는 곳의 위치가 가까운 곳부터 순서대로 저장됨
        }

        int cnt = 1; // 필요한 테이프의 개수
        int cur = queue.poll(); // 현재 물이 새는 위치
        while(!queue.isEmpty()){
            if (cur+l > queue.peek()){ // 다음 물이 새는 위치가 현재 물이 새는 위치와 테이프의 길이의 합보다 작다면, 현재 테이프로 같이 막을 수 있다.
                queue.poll();
            } else { // 아니라면 이 위치에서 부터 새로운 테이프를 사용한다.
                cur = queue.poll();
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
