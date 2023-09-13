class Solution {
	static int number = 1, row = 0, col = 0, cnt;
	static int[][] map;

	public static int[] solution(int n) {
    	
    	map=new int[n][n];
    	cnt=n;
    	while(n>=0) {
    		// 아래로
    		down();
    		cnt--;
    		if(n<=0) break;
        
    		// 오른쪽으로
    		right();
    		cnt--;
    		if(cnt<=0) break;
        
    		// 위로
    		up();
    		cnt--;
    		if(cnt<=0) break;
    	}
    	// 전체 원소 갯수 세기
    	cnt=0;
    	for(int i=1;i<=n;i++) {
    		cnt+=i;
    	}
    	// 정답 입력하기
    	int[] answer = new int[cnt];
    	cnt=0;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<i+1;j++) {
    			answer[cnt++]=map[i][j];
    		}
    	}
        return answer;
    }

	public static void down() {
		for (int i = 0; i < cnt; i++) {
			map[row + i][col] = number++;
		}
		row = row + cnt - 1;
		col +=1;
	}

	public static void right() {
		for (int i = 0; i < cnt; i++) {
			map[row][col + i] = number++;
		}
		row -=1;
		col = col+cnt-2;
	}

	public static void up() {
		for (int i = 0; i < cnt; i++) {
			map[row - i][col - i] = number++;
		}
		row = row - cnt + 2;
		col = col - cnt + 1;
	}
}
