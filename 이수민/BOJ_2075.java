import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder()); // 수를 내림차순으로 저장하는 우선순위 큐
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                queue.add(Integer.parseInt(st.nextToken())); // 수를 하나하나 큐에 넣음
            }
        }
        for (int i=1; i<n; i++) {
            queue.poll(); // n-1만큼 앞에 있는 수를 제거하고,
        }
        System.out.println(queue.peek()); // n번째 수를 출력한다.

    }
}
