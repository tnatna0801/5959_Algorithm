import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		int[] cnt = new int[input.length];
		
		StringBuilder sb = new StringBuilder();
		StringBuilder ioi = new StringBuilder("IOI");
		
		for (int i = 0; i < M; i++) {
			sb.append(input[i]);
			if (input[i] == 'I') {
				if (sb.toString().equals(ioi.toString())) {
					cnt[i] = cnt[i-2]+1;
					sb.delete(0,sb.length()-1);
				} else {
					sb.delete(0,sb.length()-1);
				}
			}
		}
		
		int result=0;
		for (int i = 2; i < M; i++) {
			if(cnt[i]>=N) result++;
		}
		System.out.println(result);
	}
}
