import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] candy = new char[n][n];

        //입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                candy[i][j] = line.charAt(j);
            }
        }

        int count = 0;

        //인접한 두개 => 가로 세로만
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //하
                if (i + 1 < n) {
                        char tmp = candy[i][j];
                        candy[i][j] = candy[i + 1][j];
                        candy[i + 1][j] = tmp;

                        count = Math.max(count, explore(candy));

                        //복구
                        tmp = candy[i][j];
                        candy[i][j] = candy[i + 1][j];
                        candy[i + 1][j] = tmp;

                }
                //우
                if (j + 1 < n) {
                        char tmp = candy[i][j];
                        candy[i][j] = candy[i][j + 1];
                        candy[i][j + 1] = tmp;

                        count = Math.max(count, explore(candy));

                        //복구
                        tmp = candy[i][j];
                        candy[i][j] = candy[i][j+1];
                        candy[i][j+1] = tmp;
                }
            }
        }
        System.out.println(count);
    }

    private static int explore(char[][] candy) {
        int count = 1;
        for(int i=0; i<candy.length; i++){
            int same = 1;
            for(int j=1; j<candy.length; j++){
                //가로
                if(candy[i][j]==candy[i][j-1]) { //같은 색일 때
                    same+=1;
                }
                else {
                    same = 1;
                }
                count = Math.max(count, same);
            }
        }
        for(int i=0; i<candy.length; i++) {
            int same = 1;
            for (int j = 1; j < candy.length; j++) {
                //세로
                if (candy[j][i] == candy[j-1][i]) { //색이 같을 때
                    same+=1;
                }
                else { //색이 다를 때 
                    same = 1; 
                }
                count = Math.max(count, same);
            }
        }
        return count;
    }


}
