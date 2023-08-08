class Solution {
    public int[] solution(int n) {
        
        int size = (1+n) * n/2;
        int[] answer = new int [size];
        
        // 값
        int num = 0;
        
        // 위치 값 조정
        int dx = 0;

        // 어떤 변을 그리는지 알 수 있도록 하는 변수
        int count = 0;

        // 배열 위치 조정할 수 있도록 하는 변수
        int location = 0;
        
        for(int i=n; i>0; i--) {
            int val = (count++)%3;

            // ↙
            if(val == 0) {
                for(int j=0; j<i; j++) {
                    location += (dx++);
                    answer[location] = ++num; 
                }
            } // →
            else if(val == 1) {
                for(int j=0; j<i; j++) {
                    ++location;
                    answer[location] = ++num;
                }
            } // ↖
            else {
                for(int j=0; j<i; j++) {
                    location -= (dx--);
                    answer[location] = ++num;
                }
            }
        }      
        return answer;
    }
}
