import java.util.*;

public class BOJ1713 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer, Integer> stud = new HashMap<>();
        ArrayList<Integer> order = new ArrayList<>();

        for(int i=0; i<M; i++) {
            int n = sc.nextInt();
            int min = 0;

            // 최솟값을 미리 구해 놓는다
            if(!stud.isEmpty())
                min = Collections.min(stud.values());

            // 없으면 해당 숫자의 순서 부여한다
            if(!order.contains(n))
                order.add(n);
            // 없으면 0 값으로 추가하고, 있으면 1 증가시킨다
            stud.put(n, stud.getOrDefault(n, -1)+1);

            // 사진 개수 넘으면, 가장 추천 적으면서 오래된 사진 삭제한다
            if(order.size() > N) {
                for(int j=0; j< order.size(); j++) {
                    if(min == stud.get(order.get(j))) {
                        stud.remove(order.get(j));
                        order.remove(j);
                        break;
                    }
                }
            }
        }

        Collections.sort(order);
        for(int n : order)
            System.out.print(n + " ");
    }
}
