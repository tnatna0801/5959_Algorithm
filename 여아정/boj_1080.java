package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1080 {
	static int n, m, cnt;
	static int[][] a, b;
	static boolean result = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String[][] in = new String[n][m];
		a = new int[n][m];//A 배열
		b = new int[n][m];//B 배열
		cnt = 0;//결과 출력할 카운트 배열

		for (int i = 0; i < n; i++) {
			in[i] = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(in[i][j]);
			}
		}

		for (int i = 0; i < n; i++) {
			in[i] = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				b[i][j] = Integer.parseInt(in[i][j]);
			}
		}
		//a와 b 값 넣기

		int size=0;
		if(m==3) size=m;
		else	size=1;
		
		for (int i = 0; i <= n - 3; i++) {
			for (int j = 0; j <= m - 3; j++) {//
				int notsame = 0;//b의 배열과 다른 경우 수 추가 하는 배열
				for (int k = i; k < i + 3; k++) {
					for (int p = j; p < j + 3; p++) {
						if (size<3 && a[i][j] != b[i][j]) {// 가로 m값이 3 이 아닐때는 a와 b의 탐색 가장 왼쪽 위 값이 같지 않을 경우
							notsame++;//같지 않음 체크
							break;
						}else if(size==3 && a[i][p]!=b[i][p]) {//가로 m 값이 3일 경우 탐색하려는 가장 윗 행 모두 확인
							notsame++;
							break;
						}
					}
					if (notsame >0) {
						for (int p = j; p < j + 3; p++) {//값 반전
							if (a[k][p] == 1)
								a[k][p] = 0;
							else
								a[k][p] = 1;
						}
						if (k == i + 2) {//반전 후 cnt추가
							cnt++;
						}
					}
				}
				same(a, b);//반전 후 b와 같은지 체크
				if (result == true) {//같다면 반복문 종료
					break;
				}
			}
			if (result == true) {
				break;
			}
		}
		same(a, b);
		
		if (result == false) {
			System.out.println("-1");
		} else {
			System.out.println(cnt);
		}

	}

	public static void same(int[][] a, int[][] b) {//배열 같은지 비교 체크
		int q = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == b[i][j]) {
					q++;
				}
			}
		}
		if (q == n * m) {//같으면 정답 boolean값 true해준다
			result = true;
		}
	}
}
