import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1911 {

	static class Puddle {
		int start;
		int end;

		public Puddle(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Puddle[] puddles = new Puddle[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			puddles[i] = new Puddle(s, e);
		}
		
		// 웅덩이 시작 좌표 순서대로 정렬
		Arrays.sort(puddles, (o1, o2) -> o1.start - o2.start);
		
		int idx=puddles[0].start;
		int result=0;
		
		for(int i=0;i<N;i++) {
			if(puddles[i].start>=idx) {
				idx=puddles[i].start+L;
				result++;
			}
			while(puddles[i].end>idx) {
				idx+=L;
				result++;
			}
		}
		System.out.println(result);
	}

}
