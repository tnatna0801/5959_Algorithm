import java.util.*;
import java.io.*;

public class BOJ16113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int size = N/5+2; // 1 검사를 더 편리하게 하기 위해 앞뒤 1열씩 더 추가
        char[][] map = new char[5][size];
        String str = br.readLine();

        // 문자열 형태로 2차원 배열에 저장
        int x = 0;
        int y = 1;
        for(char c : str.toCharArray()) {
            map[x][y++] = c;
            if(y == size-1) {
                x += 1;
                y = 1;
            }
        }

        for(int i=0; i<5; i++) {
            map[i][0] = '.';
            map[i][size-1] = '.';
        }

        Map<Integer, Integer> number = new HashMap<>();
        number.put(525, 0);  // 0 : 5 2 5
        number.put(50, 1);   // 1 : 0 5 0
        number.put(434, 25); // 2, 5 : 4 3 4 (구분할 것)
        number.put(335, 3);  // 3 : 3 3 5
        number.put(315, 4);  // 4 : 3 1 5
        number.put(534, 6);  // 6 : 5 3 4
        number.put(115, 7);  // 7 : 1 1 5
        number.put(535, 8);  // 8 : 5 3 5
        number.put(435, 9);  // 9 : 4 3 5

        // 슬라이딩 윈도우로 3개의 열을 검사한다
        List<Integer> list = new LinkedList<>();

        for(int i=0; i<size; i++) {

            int count = 0;
            for(int j=0; j<5; j++)
                if(map[j][i] == '#')
                    count += 1;

            list.add(count);

            if(list.size() == 3) {
                Integer value = number.get(list.get(0)*100+list.get(1)*10+list.get(2));

                // 숫자가 확인되지 않을 경우, 1만큼 슬라이딩 한다
                if(value == null) {
                    list.remove(0);
                }
                // 숫자가 확인될 경우, 출력하고 3만큼 슬라이딩 한다
                else {
                    // 값이 25이면 구분 과정을 추가한다
                    if(value == 25)
                        if (map[1][i] == '#')
                            System.out.print(value / 10);
                        else
                            System.out.print(value % 10);
                    else
                        System.out.print(value);

                    list.clear();

                    // 값이 1이면 뒤따라올 수 있는 1에 대비해 다시 추가한다
                    if(value == 1)
                        list.add(0);
                }
            }
        }
    }
}
