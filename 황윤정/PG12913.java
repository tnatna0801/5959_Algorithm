class PG12913 {
    int solution(int[][] land) {
        int N = land.length;
        int max;
        // 1. 1~N행까지 바로 위 행 값들과 더하면서 최대 합 찾기
        for(int i=1; i<N; i++) {
            for(int j=0; j<4; j++) {
                max = 0;
                for(int k=0; k<4; k++) { // 바로 위 행이랑 비교
                    if(k==j) // 같은 열 이동 불가
                        continue;
                    max = Math.max(max,land[i][j]+land[i-1][k]);
                }
                // 2. 최대 합으로 배열 자리 갱신
                land[i][j] = max;
            }
        }
        // 3. 마지막 행에서 최댓값 찾아서 리턴
        max = 0;
        for(int i=0; i<4; i++) {
            max = Math.max(max, land[N-1][i]);
        }    
        return max;
    }
}