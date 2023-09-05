import java.io.*;
import java.util.*;

public class BOJ11501 {
	static int T, N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			long max=Integer.MIN_VALUE; // 주가 최댓값
			long profit=0; // 최대 이익
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 뒤에서부터 최댓값 찾기
			for(int i=N-1; i>=0; i--) {
				if(arr[i] > max) { // 최댓값 찾으면
					max = arr[i]; // 갱신
				}
				else { // 최댓값보다 작거나 같은 가격
					profit += max-arr[i]; // 최댓값에서 현재 매입가 빼서 이익구하기
				}
			}
			sb.append(profit+"\n");
		}
		System.out.println(sb.toString());
	}
}
