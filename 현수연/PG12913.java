public class Solution {
	static int solution(int[][] land) {
		for(int i=1;i<land.length;i++) {
			for(int j=0;j<4;j++) {
				int max=0;
				for(int k=0;k<4;k++) {
					if(j==k) continue;
					max=Math.max(max, land[i-1][k]);
				}
				land[i][j]=land[i][j]+max;
			}
		}
		int answer=Math.max(land[land.length-1][0],Math.max(land[land.length-1][1],
						Math.max(land[land.length-1][2], land[land.length-1][3])));
		return answer;
	}
}
