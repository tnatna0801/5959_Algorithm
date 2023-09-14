import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25186 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean flag = true; // 겹치지 않고 옷을 입을 수 있는지
        long total = 0; // 사진을 찍는 전체 인원 수
        long[] d = new long[N]; // 옷 종류마다의 개수 보관
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            total += d[i];
        }

        // 한 명이면 겹칠 일 없으므로 happy~^^
        if (total == 1) {
            System.out.println("Happy");
            return;
        }

        for(long i: d) {
            if (total < i*2) { // 각 옷 종류가 전체 인원 수의 반을 넘으면, 겹치게 됨
                flag = false;
                break;
            }
        }

        System.out.println(flag? "Happy" : "Unhappy");
    }
}
