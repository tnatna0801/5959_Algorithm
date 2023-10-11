package w1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {

	static int N, arr[][], cnt[];
	
	// 종이가 모두 같은 수로 이루어져 있는지 확인
	private static boolean check(int x, int y, int size) {
		int cur = arr[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if (arr[i][j] != cur) return false;
			}
		}
		
		// 모든 같은 수로 이루어진 경우
		cnt[cur+1]++;
		return true;
	}

	// 종이 나누기
	private static void divide(int x, int y, int size) {
		if (check(x, y, size)) return; // 이미 같은 수로 이루어진 경우.
		
		size /= 3;
		// 종이를 9개로 나누어 다시 나눠진 종이의 경우를 볼 수 있도록 한다.
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				divide(x+i*size, y+j*size, size);
			}
		}
			

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = new int[3]; // -1, 0, 1의 경우를 차례로 저장
		divide(0, 0, N);
		
		for(int i=0; i<3; i++)
			System.out.println(cnt[i]);
	}
}
