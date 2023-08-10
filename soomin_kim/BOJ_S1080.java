import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1080 {
    static int[][] arrayA;
    static int[][] arrayB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrayA = new int[n][m];
        arrayB = new int[n][m];
        // A 배열
        for(int i = 0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j<m; j++){
                arrayA[i][j] = Integer.parseInt(line[j]);
            }
        }
        // B 배열
        for(int i = 0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j<m; j++){
                arrayB[i][j] = Integer.parseInt(line[j]);
            }
        }

       int count = 0;
        //3*3 탐색 시작
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < m-2; j++) {
                if(arrayA[i][j] != arrayB[i][j]) { // 다르면 바꿔준다.
                    change(i, j);
                    count++;
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arrayA[i][j] == arrayB[i][j]) continue;
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
    
    //3*3 크기만큼 비트 뒤집기
    public static void change(int x, int y){
        for(int i = x; i<x+3; i++) for (int j = y; j < y + 3; j++) arrayA[i][j] = arrayA[i][j] ^ 1;
    }
}
