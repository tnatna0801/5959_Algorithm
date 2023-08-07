import java.util.Arrays;

public class PG_68645 {
    // 프로그래머스 삼각 달팽이

    public static int[] solution(int n) {
        int max = 0;
        int[][] array = new int[n][];
        for(int i=0; i<n; i++){ 
            max += i+1; // 달팽이 생성 시 설정할 수 있는 최댓값
            array[i] = new int[i+1]; // 행마다 배열 칸 수 설정
        }

        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int direction = 0; // 방향
        int x=0, y=0; // 초기값
        int current = 1; // 값 시작
        array[x][y] = current;

        // 현재 값이 달팽이 전체 생성 시 최댓값보다 작은 경우에 실행
        while(current < max){
            // 임시 좌표
            int tmpx = x + dx[direction];
            int tmpy = y + dy[direction];
            
            // 임시 좌표가 조건에 부합하지 않는다면, 방향을 변경하여 빈 배열 공간을 찾는다.
            while(tmpx >= n || tmpx < 0 || tmpy < 0 || tmpy >= array[tmpx].length || array[tmpx][tmpy] != 0){
                direction = (direction+1)%3;
                tmpx = x + dx[direction];
                tmpy = y + dy[direction];
            }
            
            // 임시 좌표를 사용 가능하다면 현재 좌표로 설정
            x = tmpx;
            y = tmpy;

            // 현재 좌표에 값을 넣는다
            array[x][y] = ++current;
        }

        // 2차원 배열 -> 1차원 배열
        int[] result = new int[max];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                result[idx++] = array[i][j];
            }
        }
        return result;
    }
    
    // test 위한 main 메소드
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(4)));
//    }
}
