import java.io.*;
import java.util.*;

public class boj1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] places = new int[n];
        for (int i=0; i<n; i++) {
            places[i] = Integer.parseInt(st.nextToken());
        }

        // 물이 새는 위치 정렬
        Arrays.sort(places);

        // 테이프의 시작 지점
        int start = places[0];
        int answer = 1;

        for (int i=1; i<n; i++) {
            // 물이 새는 위치가 테이프의 범위를 벗어나면 테이프 추가
            if (!((places[i] >= start) && (places[i] < start + l))) {
                start = places[i];
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}

