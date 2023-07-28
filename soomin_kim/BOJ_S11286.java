import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_S11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //람다식으로 compare 메서드를 절대값 비교로 오버라이드
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {

            int absA = Math.abs(o1);
                int absB = Math.abs(o2);

                if(absA == absB) { // 절댓값이 같으면 더 작은 수를 반환
                    return o1 > o2?1:-1;
                }

                //absA가 더 크면 양수, 작으면 음수 반환
                return absA-absB;
        });

        for(int i = 0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x != 0) { //0이 아니면 heap에 추가
                absHeap.add(x);
            }
            else { //0이면 제일 작은 수 출력 및 제거
                if(absHeap.isEmpty()) System.out.println(0);
                else System.out.println(absHeap.poll());
            }
        }
    }
}
