class Solution {
    public int[] solution(int n) {
    	int[][] snail = new int[n][n];
    	int cnt=1;
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n-i;j++) {
    			if(snail[j][i]==0)
    				snail[j][i]=cnt++;
    		}
    		for(int j=i+1;j<n-i;j++) {
    			if(snail[n-1-i][j]==0)
    			    snail[n-1-i][j]=cnt++;
    		}
    		for(int j=n-2-i;j>i+1;j--) {
    			if(snail[j][j-i]==0)
    				snail[j][j-i]=cnt++;
    		}
    	}
    	int[] answer = new int[n*(n+1)/2];
    	cnt=0;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<=i;j++)
    			answer[cnt++]=snail[i][j];
    	}
        return answer;
    }
}