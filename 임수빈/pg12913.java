import java.util.*;

class Solution {
    int solution(int[][] land) {
    	// 땅의 크기
        int size = land.length;
        // 얻을 수 있는 점수의 최댓값을 저장할 배열
        int[][] result = new int[size][4];
        
        // 첫 행의 점수 -> 땅의 첫 행의 값
        result[0] = land[0];
        
        // 두 번째 행부터 실행
        for (int i=1; i<size; i++) {
        	// 각 열마다
            for (int j=0; j<4; j++) {
            	// 전 행에서 가능한 최댓값에 현재 값 더하기
                for (int k=0; k<4; k++) {
                    if (j == k) { // 같은 열을 연속해서 밟을 수 없다.
                        continue;
                    } 
                    
                    if (result[i][j] < result[i-1][k] + land[i][j]) { // 최댓값 갱신
                        result[i][j] = result[i-1][k] + land[i][j];
                    }
                }
            }
        }

        // 마지막 행의 최댓값 리턴
        return Arrays.stream(result[size-1]).max().getAsInt();
    }
}