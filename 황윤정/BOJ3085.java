import java.io.*;
import java.util.*;	

public class BOJ3085 {
	static int N;
	static char[][] arr;
	static int result = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1. N 입력받고 배열 채우기
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			arr[i] = tmp.toCharArray();
		}
		// 2. 색깔 바꿔보고 연속개수 세기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				// 가로 방향 2개 바꾸기
				char tmp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = tmp;
				// 현재 위치부터 가로, 세로방향 탐색
				Find();
				// 바꾼 색깔 원상 복구
				arr[i][j+1] = arr[i][j];
				arr[i][j] = tmp;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				//세로 방향 2개 바꾸기
				char tmp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = tmp;
				// 현재 위치부터 가로, 세로방향 탐색
				Find();
				// 바꾼 색깔 원상 복구
				arr[j+1][i] = arr[j][i];
				arr[j][i] = tmp;
			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
	
	public static void Find() {
		// 가로 탐색
		int cnt;
		for(int i=0; i<N; i++) {
			cnt = 1;
			for(int j=0; j<N-1; j++) {
				// 같은 색깔 연속인 경우
				if(arr[i][j] == arr[i][j+1]) {
					cnt++;
				}
				// 연속이 안되므로 개수 초기화
				else {
					cnt = 1;
				}
				// 연속되는 최댓값 저장
				result = Math.max(cnt, result);
			}
		}
		// 세로 탐색
		for(int i=0; i<N; i++) {
			cnt = 1;
			for(int j=0; j<N-1; j++) {
				if(arr[j][i] == arr[j+1][i]) {
					cnt++;
				}
				else {
					cnt = 1;
				}
				result = Math.max(cnt, result);
			}
		}
	}
}