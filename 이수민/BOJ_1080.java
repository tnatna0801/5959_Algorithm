import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1080 {
    static char[][] a, b;

    // 행렬 뒤집기
    static void reverseMatrix(int i, int j){
        for(int x=i; x<i+3; x++){
            for(int y=j; y<j+3; y++){
                a[x][y] = a[x][y] == '0' ? '1' : '0';
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        a = new char[n][m];// 행렬 A
        b = new char[n][m];// 행렬 B

        for(int i=0; i<n; i++){
            a[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<n; i++){
            b[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                if (a[i][j] != b[i][j]){ // 지금 A행렬의 원소가 B행렬의 원소와 다를 때,
                    reverseMatrix(i, j);
                    cnt++; // 행렬을 뒤집어야 하는 경우를 카운트
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (a[i][j] != b[i][j]){ // A와 B가 다르다면 A를 B로 바꿀 수 없는 경우
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);

    }
}
