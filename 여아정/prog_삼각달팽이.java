package cocodingding;

public class prog_삼각달팽이 {
    public int[] solution(int n) {
        
        int[][]turn={{1,0},{0,1},{-1,-1}};
        int[][]input=new int[n][n];//입력 넣을 배열
        int all=n*(n+1)/2;
        int[] answer = new int[all];
        
        int x=0;
        int y=0;//좌표 초기화
        int now=0;//방향 idx
        
        int cnt=1;//1로 초기화
        while(cnt<=all){
            input[x][y]=cnt;
            if(x+turn[now][0]<0 || x+turn[now][0]>=n
              || y+turn[now][1]<0 || y+turn[now][1]>=n || input[x+turn[now][0]][y+turn[now][1]]!=0){
                if(now>=turn.length-1){//turn 마지막일 경우 0번으로 다시 돌아감
                    now=0;
                }else{
                    now++;
                }
            }
            x+=turn[now][0];//좌표 변경
            y+=turn[now][1];
            cnt++;
        }
        
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(input[i][j]!=0){
                    answer[idx]=input[i][j];//answer 배열에 넣어줌
                    idx++;
                }
            }
        }
        
        return answer;
    }
}