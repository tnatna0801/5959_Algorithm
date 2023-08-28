public class PG_12913 {
    int solution(int[][] land) {
        int answer = 0;

        int N = land.length;

        // 현재 보고 있는 각 열들은
        for(int i=1; i<N; i++){
            // 이전 행의 열은 현재 행의 열의 인덱스와 같지 않아야 하므로 최대값 과정에서 제외
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        // 마지막 행 중 최댓값이 이 문제의 답
        for (int i=0; i<4; i++){
            answer = Math.max(land[N-1][i], answer);
        }

        return answer;
    }
}
