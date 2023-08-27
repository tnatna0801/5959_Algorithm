package cocodingding;

public class pg_12913_땅따먹기 {

	static int idx, max,n, sum;
    static int[][]temp;
    
    int solution(int[][] land) { 
        int n=land.length;//land 길이
        
        for(int i=1;i<n;i++){
        	//현재 전의 행에서 최대값을 현재 값에 추가해준다
            land[i][0]+=Math.max(land[i-1][1], Math.max(land[i-1][2],land[i-1][3]));
            land[i][1]+=Math.max(land[i-1][0], Math.max(land[i-1][2],land[i-1][3]));
            land[i][2]+=Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][3]));
            land[i][3]+=Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][2]));
        }
        
        int max=Math.max(land[n-1][0],Math.max(land[n-1][1],Math.max(land[n-1][2],land[n-1][3])));
        //최대값 구하기
        return max;  
    }
}