import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Stack<Integer> stack1 = new Stack<>(); // 1번줄
        Stack<Integer> stack2 = new Stack<>(); // 2번줄
        Stack<Integer> stack3 = new Stack<>(); // 3번줄
        Stack<Integer> stack4 = new Stack<>(); // 4번줄
        Stack<Integer> stack5 = new Stack<>(); // 5번줄
        Stack<Integer> stack6 = new Stack<>(); // 6번줄

        int count = 0; // 손가락을 움직인 횟수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken()); // 몇 번줄
            int num = Integer.parseInt(st.nextToken()); // 프렛

            switch(line) {
                case 1: // 1번 줄일 때
                    if(!stack1.isEmpty()) { // stack이 비어있지 않은지 확인
                        while (!stack1.isEmpty()) {  // stack이 비어있지 않은지 확인
                            //stack의 top에 현재 프젤 위치보다 큰 값이 들어있으면 손가락을 떼야하므로 반복문으로 pop해서 찾는다?
                            if (stack1.peek() <= num) // 현재 stack의 top에 있는 값과 들어온 프렛 값을 비교한다.
                                break; // 더 작거나 같으면 pop을 종료한다.
                            stack1.pop();
                            count++; // 손가락을 뗐으므로 증가
                        }
                        if(!stack1.isEmpty() && stack1.peek() == num) break; // stack에 이미 같은 줄이 있다면 아무 처리 하지 않는다.
                        stack1.add(num); // 새로 들어온 프렛 값을 
                        count++; // 손가락을 눌렀으므로 증가
                    }
                    else { // stack이 비었다면 그냥 추가
                        stack1.add(num); 
                        count++; // 눌렀으므로 증가
                    }
                    break;
                case 2:
                    if(!stack2.isEmpty()) {
                        while (!stack2.isEmpty()) {
                            if (stack2.peek() <= num)
                                break;
                            stack2.pop();
                            count++;
                        }
                        if(!stack2.isEmpty() && stack2.peek() == num) break;
                        stack2.add(num);
                        count++;
                    }
                    else {
                        stack2.add(num);
                        count++;
                    }
                    break;
                case 3:
                    if(!stack3.isEmpty()) {
                        while (!stack3.isEmpty()) {
                            if (stack3.peek() <= num)
                                break;
                            stack3.pop();
                            count++;
                        }
                        if(!stack3.isEmpty() && stack3.peek() == num) break;
                        stack3.add(num);
                        count++;
                    }
                    else {
                        stack3.add(num);
                        count++;
                    }
                    break;
                case 4:
                    if(!stack4.isEmpty()) {
                        while (!stack4.isEmpty()) {
                            if (stack4.peek() <= num)
                                break;
                            stack4.pop();
                            count++;
                        }
                        if(!stack4.isEmpty() && stack4.peek() == num) break;
                        stack4.add(num);
                        count++;
                    }
                    else {
                        stack4.add(num);
                        count++;
                    }
                    break;
                case 5:
                    if(!stack5.isEmpty()) {
                        while (!stack5.isEmpty()) {
                            if (stack5.peek() <= num)
                                break;
                            stack5.pop();
                            count++;
                        }
                        if(!stack5.isEmpty() && stack5.peek() == num) break;
                        stack5.add(num);
                        count++;
                    }
                    else {
                        stack5.add(num);
                        count++;
                    }
                    break;
                case 6:
                    if(!stack6.isEmpty()) {
                        while (!stack6.isEmpty()) {
                            if (stack6.peek() <= num)
                                break;
                            stack6.pop();
                            count++;
                        }
                        if(!stack6.isEmpty() && stack6.peek() == num) break;
                        stack6.add(num);
                        count++;
                    }
                    else {
                        stack6.add(num);
                        count++;
                    }
                    break;
            }

        }
        System.out.println(count);
    }
}