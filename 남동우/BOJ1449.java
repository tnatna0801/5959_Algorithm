import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        List<Node> nodeList = new ArrayList<>(); // 그냥 우선순위 큐만 담아도 되는데, 빠르게 푼다고 Node 를 새로 정의해서 풀었습니다. Node 를 담아주는 리스트입니다.
        List<Integer> numberList = makeList(br,n);  // 리스트를 입력받고, 정렬해서 돌려주는 method 입니다.

        for(Integer element : numberList){ // 정렬 이후 for 문입니다.
            Node node = nodeList.stream().filter(x -> Math.abs(x.queue.peek() - element) < l).findFirst().orElse(null); // stream 을 받아서, nodeList 내에서 현재 비교하고 있는 숫자와, 우선순위 큐 내의 가장 작은 값의 차이가
            // l 보다 작은지 아닌지 확인하고, 맞다면 해당 객체를 불러줍니다. 아니라면, null 을 불러 주는 stream 코드입니다.
            if(node == null){
                nodeList.add(new Node(element)); // 위의 조건에 해당하는 숫자가 없는 경우, 새로 nodeList 에 element 가 제일 위에 있는 우선순위 큐 객체를 만들어 리스트에 추가하는 코드입니다.
            }else{
                node.queue.add(element); // 위의 node 에 해당하는 객체가 있으면, 해당 객체의 우선순위 큐에 element 를 넣고 지나갑니다.
            }
        }
        System.out.println(nodeList.size()); // 위의 for 문의 nodeList 가 몇 개 생겼는지 출력합니다. 
    }
    static List<Integer> makeList(BufferedReader br, int n) throws IOException{ // 입력을 받아주는 코드입니다.
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken())); // 평범한 입력 코드입니다.
        }
        return list.stream().sorted().collect(Collectors.toList()); // 위의 list 를 정렬해서, 다시 List 로 받아주는 stream 코드입니다.
    }
    static class Node{
        int data; // 처음에는 필요하다고 생각해서 이렇게 data도 받아주었습니다. 나중에 보니까 필요없다는 것을 깨닫기도 했습니다.
        PriorityQueue<Integer> queue;

        public Node(int data){
            this.data = data;
            this.queue = new PriorityQueue<>();
            this.queue.add(data); // 객체 생성 시 무조건 새로운 우선순위 큐를 만들어 주고, 그 큐에 데이터를 넣어주는 모습입니다.
        }
    }
}
