import java.io.*;
import java.util.*;

public class BOJ1911 {
	static int N, L, result, max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> water = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			water.add(new int[] {start, end});
		}
		// 물 웅덩이들 시작점이 빠른 순서로 정렬
		Collections.sort(water, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int ptr = 0; // 널빤지 붙일 위치 표시
		for(int i=0; i<N; i++) {
			int[] now = water.get(i);
			// ptr 위치보다 웅덩이 시작점이 크면 거기로 옮겨서 널빤지 붙이기
			// 시작점과 ptr이 같거나 크면 바로 널빤지 붙이기
			if(ptr < now[0]) {
				ptr = now[0];
			}
			// 웅덩이를 완전히 덮도록 널빤지 붙이고 개수 증가
			while(ptr < now[1]) {
				ptr += L;
				result++;
			}
		}
		System.out.println(result);
	}
}
