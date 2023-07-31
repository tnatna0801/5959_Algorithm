import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S2784 {

    static boolean[] visited = new boolean[6]; // 방문 확인
    static String[] puzzle = new String[6]; // 가로 3 세로 3 퍼즐
    static String[] words = new String[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        words = new String[6];
        for (int i = 0; i<6; i++){
            words[i] = br.readLine();
        }

        if(select(0) == 0){
            System.out.println(0);
        }
        else {
            for(int i = 0; i<3; i++){
                System.out.println(puzzle[i]);
            }
        }

    }

    public static int select(int count) {
        String col, row;
        //가로세로 퍼즐의 6개 단어가 각각 입력으로 주어진 6개의 단어와 동일하게 나타나는 지 확인
        if(count == 6) {
            for (int i = 0; i < 3; i++) {
                col = puzzle[i+3];
                row = puzzle[i];
                    if (row.equals(col)) { //일치하지 않으면
                        return 0;
                    }
                }
            return 1; // 이거 빼먹어서 Nullpoint 오류 10번은 본 듯
        }

        // 뽑기
        for(int i = 0; i < 6; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            puzzle[count] = words[i];
            select(count+1);
            visited[i] = false;
        }

        return 1;
    }
}
