import java.io.*;

public class BOJ5525 {
	static int N, M, result;
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		
		int cnt=0; // IOI 덩어리 갯수
		for(int i=1; i<M-1; i++) {
			// "IOI"면
			if(input[i-1] == 'I' && input[i] == 'O' && input[i+1] == 'I') {
				cnt++; // IOI덩어리 갯수 증가
				if(cnt == N) { // IOI덩어리를 N개만큼 찾으면 
					result++; // 결과 변수 증가
					cnt -= 1; // 포함된 덩어리갯수 1개 감소
				}
				i++; // 2칸 뛰어넘게 미리 i 1 증가
			}
			else { // "IOI" 아니면
				cnt = 0; // IOI 덩어리 갯수 초기화
			}
		}
		System.out.println(result);
	}
}
