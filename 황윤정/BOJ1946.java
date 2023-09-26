import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1946 {
    static int T, N, result; // 테스트케이스 수, 지원자 수, 신입사원 수
    static Grade[] arr; // 지원자 성적 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            result = 1; // 1등은 무조건 채용
            N = Integer.parseInt(br.readLine());
            arr = new Grade[N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int docu = Integer.parseInt(st.nextToken());
                int inter = Integer.parseInt(st.nextToken());
                arr[i] = new Grade(docu, inter);
            }
            Arrays.sort(arr); // 서류심사 성적순으로 정렬
            int rank = arr[0].interview; // 현재 면접 성적 최고 순위
            for(int i=1; i<N; i++) {
                if(arr[i].interview < rank) { // 면접 성적 순위가 더 높으면
                    rank = arr[i].interview; // 면접 최고 순위 갱신
                    result++; // 선발 가능한 신입사원 수 증가
                }
            }
            sb.append(result+"\n");
        }
        System.out.println(sb.toString());
    }
}

class Grade implements Comparable<Grade>{
    int document; // 서류심사 성적
    int interview; // 면접 성적

    public Grade(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }

    @Override
    public int compareTo(Grade o) {
        return this.document - o.document; // 서류심사 오름차순 정렬
    }
}
