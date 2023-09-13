import java.io.*;
import java.util.*;

public class boj11501 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] numbers = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			long answer = 0;
			int temp = numbers[n-1]; // 마지막 날 주가
			for (int i=n-1; i>=0; i--) {
				if (temp > numbers[i]) { // 기준 주가가 더 크면 이익 더하기
					answer += temp - numbers[i];
				} else { // 기준 주가가 더 작으면 기준 주가 갱신
					temp = numbers[i];
				}
			}
			sb.append(answer + "\n");
		}
		
		System.out.print(sb);
	}

}
