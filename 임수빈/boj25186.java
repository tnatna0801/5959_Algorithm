import java.io.*;
import java.util.*;

public class boj25186 {

    static int n;
    static long total = 0; // int인지 long인지 타입 생각 잘 하자 ㅠ
    static int d[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 옷 종류의 수
        d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            d[i] = Integer.parseInt(st.nextToken()); // 종류별 옷 개수
            total += d[i]; // 총 인원 수
        }

        System.out.println(isHappy());
    }

    static String isHappy() {
        // 1명일 때
        if (total == 1) {
            return "Happy";
        }

        // 각 종류별 옷의 개수가 총 인원의 절반보다 크면 행복할 수 없다.
        total /= 2;
        for (int i: d) {
            if (i > total) {
                return "Unhappy";
            }
        }
        return "Happy";
    }
}
