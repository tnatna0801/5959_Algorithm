class Solution {
    int solution(int[][] land) {
        
        int N=land.length;
        int[][] max=new int[N+1][4];
        
        for(int i=1;i<=N;i++) { // 행
            for(int j=0;j<4;j++) { // 열
                for(int k=0;k<4;k++){ // 이전 행에서 열
                    if(j!=k){ // 현재행의 열!=이전행의 열
                        max[i][j]=Math.max(max[i][j],land[i-1][j]+max[i-1][k]); // 최대값 갱신
                    } 
                }
            }
        }
        // 마지막 줄에서 정답찾기
        int answer = 0;
        for(int i=0;i<4;i++){
            answer=Math.max(answer,max[N][i]);
        }
        return answer;
    }
}
