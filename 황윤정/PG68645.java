class PG68645 {
    public int[] solution(int n) {
        int[] answer;
        int[][] snail = new int[n][n];
        
        int num = 1; // 배열에 저장될 숫자
        int cnt = n; // 한번에 채울 숫자들의 개수
        int i=0, j=0; // 삼각 달팽이 접근 인덱스
        while(cnt > 0) {
            // 위->아래
            for(int c=0; c<cnt; c++) {
                snail[i++][j] = num++;
            }
            // 시작점 셋팅 (왼->오 채우기)
            i--;
            j++;
            cnt--;
            
            if(cnt == 0) // 더 이상 채울 숫자가 남아있지 않다면
                break;
            
            // 왼->오
            for(int c=0; c<cnt; c++) {
                snail[i][j++] = num++;
            }
            // 시작점 셋팅 (아래->위 채우기)
            i--;
            j-=2;
            cnt--;
            if(cnt == 0)
                break;
            
            // 아래->위
            for(int c=0; c<cnt; c++) {
                snail[i--][j--] = num++;
            }
            // 시작점 셋팅 (위->아래 채우기)
            i+=2;
            j++;
            cnt--;
            if(cnt == 0)
                break;
        }
        
        answer = new int[num-1]; // 저장된 숫자의 개수만큼 답 배열 생성
        int len = 0;
        for(int y=0; y<n; y++) {
            for(int x=0; x<=y; x++) {
                answer[len++] = snail[y][x];
            }
        }
        return answer;
    }
}