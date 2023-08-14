import java.io.*;
import java.util.*;

public class BOJ1080 {
	static int N, M, result;
	static int[][] A, B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		B = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<M; j++) {
				A[i][j] = line.charAt(j) - '0';
			}
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<M; j++) {
				B[i][j] = line.charAt(j) - '0';
			}
		}
		
		// N,M이 부분행렬 사이즈보다 작은 경우
		if(N < 3 || M < 3) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(A[i][j] != B[i][j]) {
						// A,B 다른데 변환 연산 사용 불가
						System.out.println(-1);
						return;
					}
				}
			}
			// 행렬이 모두 일치하면 안바꿔도 됨
			System.out.println(0);
			return;
		}
		
		// N,M이 부분행렬 사이즈 이상인 경우
		// 3*3 행렬이 들어갈 수 있는 범위내에서만 값 확인
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M-2; j++) {
				if(A[i][j] != B[i][j]) {
					// 행렬의 값이 다르다면 
					switchValue(i, j); // 바꾸자
					result++;
				}
			}
		}
		// 변환 연산 후 행렬이 같은지 확인(다르면 못 바꾸는거니까 -1)
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] != B[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(result);
	}
	
	static void switchValue(int r, int c) {
		// 3*3 부분행렬의 원소를 모두 뒤집기
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(A[i][j] == 1) {
					A[i][j] = 0;
				}
				else {
					A[i][j] = 1;
				}
			}
		}
	}
}
