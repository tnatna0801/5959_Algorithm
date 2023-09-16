import java.io.*;
import java.util.*;

public class boj16113 {

    static int size;
    static String input;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        size =  Integer.parseInt(br.readLine()) / 5;
        input = br.readLine();

        // 숫자 패턴 저장
        makeMap();

        int idx = 0;
        while (idx < size) {
            // 숫자가 아닌 곳
            if (input.charAt(idx) == '.') {
                idx++;
                continue;
            }

            // 마지막 인덱스인 경우
            if (idx == size-1) {
                sb.append(1); // 칠해져 있고, 그 다음 인덱스가 없으므로 1
                break;
            }

            if (input.charAt(idx+1) == '.') {
                // 4인 경우
                if (input.charAt(3*size+idx) == '.') {
                    sb.append(4);
                    idx += 4;
                    continue;
                }

                // 1인 경우
                sb.append(1);
                idx += 2;
                continue;
            }

            // 나머지 숫자인 경우
            sb.append(findNumber(idx));
            idx += 4;
        }

        System.out.println(sb);
    }

    static void makeMap() {
        map.put("####.##.##.####", 0);
        map.put("###..#####..###", 2);
        map.put("###..####..####", 3);
        map.put("####..###..####", 5);
        map.put("####..####.####", 6);
        map.put("###..#..#..#..#", 7);
        map.put("####.#####.####", 8);
        map.put("####.####..####", 9);
    }

    static int findNumber(int start) {
        // 숫자 하나 만들기
        StringBuilder number = new StringBuilder();
        for (int i=0; i<5; i++) {
            for (int j=0; j<3; j++) {
                number.append(input.charAt(i*size + j+start));
            }
        }

        // 해당 숫자 반환
        return map.get(number.toString());
    }
}
