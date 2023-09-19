import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_16113 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine())/5;
        char[][] signals = new char[5][n];

        // 입력
        String s = br.readLine();
        int tmp=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<n; j++){
                signals[i][j] = s.charAt(tmp++);
            }
        }

        // 맵에 숫자별 패턴 저장
        HashMap<String, Integer> pattern = new HashMap<>();
        pattern.put("####.##.##.####", 0);
        pattern.put("###..#####..###", 2);
        pattern.put("###..####..####", 3);
        pattern.put("#.##.####..#..#", 4);
        pattern.put("####..###..####", 5);
        pattern.put("####..####.####", 6);
        pattern.put("###..#..#..#..#", 7);
        pattern.put("####.#####.####", 8);
        pattern.put("####.####..####", 9);

        int idx=0; // 첫번째 행의 인덱스

        while(true){
             if (idx >= n) break; // 마지막 인덱스면 종료.

             // 현재 숫자패턴 시작이 아니면 다음 열로 가기
             if (signals[0][idx] == '.') {
                 idx++;
                 continue;
             }

             if (idx+3 > n){
                 // 마지막 숫자패턴이 5*3짜리의 숫자패턴을 만들지 못하므로, 지금 패턴은 무조건 1.
                 sb.append(1);
                 break;
             }

             // 패턴을 cur 문자열에 저장
             String cur = "";
             for(int i=0;i<5;i++){
                 for(int j=idx; j<idx+3; j++){
                     cur += signals[i][j];
                 }
             }

             // 검색 결과, 현재 문자가 없다면 1일 것.
             if (pattern.get(cur) == null) {
                 sb.append(1);
                 idx += 2; // 1은 5*3짜리 숫자 패턴이 아니므로 2만큼 이동
             }
             else {
                 sb.append(pattern.get(cur));
                 idx += 4; // 다음 패턴이 있을 곳으로 이동
             }
        }

        System.out.println(sb);

    }
}
