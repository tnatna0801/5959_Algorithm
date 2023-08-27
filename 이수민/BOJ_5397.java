import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;
        int T = Integer.parseInt(br.readLine());
        LinkedList<Character> list = null;
        ListIterator<Character> iterator = null; // 양방향으로 조회하기 위해 ListIterator 선언

        for(int t=0; t<T; t++){
            list = new LinkedList<Character>();
            iterator = list.listIterator();
            sb = new StringBuilder();
            char[] input = br.readLine().toCharArray();
            for(char c : input){
                if (c == '<'){
                    // 왼쪽에 요소가 있을 경우, 왼쪽으로 이동
                    if (iterator.hasPrevious())
                        iterator.previous();
                }
                else if (c == '>'){
                    // 오른쪽에 요소가 있을 경우, 오른쪽으로 이동
                    if(iterator.hasNext())
                        iterator.next();
                }
                else if (c == '-'){
                    // 요소가 있을 경우, 이동하여 해당 요소 삭제
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                }
                else{
                    // 요소 추가
                    iterator.add(c);
                }
            }

            for(char c : list){
                // 남은 리스트의 요소를 문자열로 만들기
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
