import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 절댓값의 크기에 따른 내부 정렬을 위해 compare 메소드 재정의
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int tmp = Math.abs(o1) - Math.abs(o2);
                if (tmp == 0) // 절댓값이 같은 경우, 더 작은 값이 우선 될 수 있도록 함
                    return o1 - o2;
                else
                    return tmp; // 절댓값이 작은 값이 우선됨
            }
        });

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if (x!=0){ // 정수 x가 0이 아닌 경우, 큐에 숫자 저장
                queue.add(x);
            }
            else { // 정수 x가 0인 경우, 큐에 값이 있을 경우 값을 빼냄
                System.out.println(queue.isEmpty()? 0: queue.poll());
            }
        }

    }
}
