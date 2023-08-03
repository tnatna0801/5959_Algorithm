import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_S2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //역순으로 정렬하는 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        //입력
        for(int i = 0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<N; j++) {
                queue.add(Integer.parseInt(line[j]));
            }
        }

        //poll()로 우선순위의 원소 출력 및 제거
        for(int i = 1; i<N; i++){
            queue.poll();
        }

        //출력
        System.out.println(queue.poll());
    }
}
