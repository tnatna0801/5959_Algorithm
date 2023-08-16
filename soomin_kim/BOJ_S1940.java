import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] water = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            water[i][0] = Integer.parseInt(st.nextToken());
            water[i][1] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(water, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int range = 0; // 덮을 수 있는 범위
        int count = 0; // 널판지 수
        for (int i = 0; i < n; i++) {

            if (water[i][0] > range) {// range를 start위치로 설정한당
                range = water[i][0];
            }

            while(water[i][1] >  range){ // 물 웅덩이의 끝 위치까지 널판지를 덮는당...
                range += l; // 널판지 길이만큼 범위를 늘린당
                count++;
            }

        }

        System.out.println(count);
    }
}