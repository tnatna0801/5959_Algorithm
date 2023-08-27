import java.util.*;
import java.io.*;

public class BOJ1080 {
    static int N, M;
    static char[][] ques;
    static char[][] answ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        ques = new char[N][M];
        answ = new char[N][M];
        
        for(int i=0; i<N; i++)
            ques[i] = sc.next().toCharArray();

        for(int i=0; i<N; i++)
            answ[i] = sc.next().toCharArray();

        int count = 0;

        // 왼쪽 상단부터 다른 부분이 있으면 교체
        for(int i=0; i<=N-3; i++) {
            for(int j=0; j<=M-3; j++) {
                if(ques[i][j] != answ[i][j]) {
                    change(i, j);
                    count += 1;
                }
            }
        }

    // 배열에서 다른 부분이 있는지 확인
    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            if(ques[i][j] != answ[i][j]) {
                System.out.println(-1);
                return;
            }
        }
    }
    System.out.println(count);
 
    }

  // 3 x 3 교체
	static void change(int x, int y) {
	    for(int i=0; i<3; i++) {
	        for(int j=0; j<3; j++) {
	        	if(ques[x+i][y+j] == '0') {
	        		ques[x+i][y+j] = '1';
	        	}
	        	else {
	        		ques[x+i][y+j] = '0';
	        	}
	        }
	    }
	}
}
