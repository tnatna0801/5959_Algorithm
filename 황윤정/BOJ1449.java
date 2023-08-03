import java.io.*;
import java.util.*;

public class BOJ1449 {
	static int N, L;
	static int result;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		double tape = arr[0] - 0.5 + L; // 테이프가 붙여진 범위
		result++; // 처음에 1개 붙이고 시작
		for(int i=1; i<N; i++) {
			if(arr[i] > tape) { // 물 새는 곳이 테이프가 붙여진 곳을 넘으면
				result++; // 테이프 더 붙이기
				tape = arr[i] - 0.5 + L; // 테이프 범위도 늘리기
			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}
