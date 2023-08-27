import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] sol = new int[land.length][4];
        
        for(int i=0; i<4; i++)
            sol[0][i] = land[0][i];
        
        for(int k=1; k<land.length; k++) {
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    if(i==j)
                        continue;
    
                    sol[k][i] = Math.max(sol[k][i], sol[k-1][j]+land[k][i]);
                }
            }
        }
        
        Arrays.sort(sol[land.length-1]);
        
        return sol[land.length-1][3];
    }
}
