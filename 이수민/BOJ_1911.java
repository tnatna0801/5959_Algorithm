import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 웅덩이 정보를 저장하기 위한 클래스
class Puddle implements Comparable<Puddle> {
    int start;
    int end;
    Puddle(int start, int end){
        this.start = start;
        this.end = end;
    }

    // 웅덩이 시작지점을 기준으로 정렬
    @Override
    public int compareTo(Puddle p) {
        return this.start - p.start;
    }
}
public class BOJ_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Puddle[] puddles = new Puddle[n]; // 웅덩이들
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            puddles[i] = new Puddle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 웅덩이 시작지점을 기준으로 정렬
        Arrays.sort(puddles);

        int pos = 0; // 현재 보고 있는 위치
        int board = 0; // 사용한 널빤지 수

        // 웅덩이들 널빤지로 덮기
        for(Puddle p : puddles){
            // 널빤지 시작점 정하기
            pos = pos < p.start ? p.start : pos;

            // 웅덩이가 끝나는 지점 전까지 계속 널빤지를 추가하여 덮는다.
            while(pos < p.end){
                pos += l;
                board++;
            }
        }

        System.out.println(board);

    }
}
