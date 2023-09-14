package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16401 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());//조카 수
		N = Integer.parseInt(st.nextToken());//과자개수
		int[] len = new int[N];
		int max = 0;

		st = new StringTokenizer(br.readLine());
		int now;
		for (int i = 0; i < N; i++) {
			now = Integer.parseInt(st.nextToken());
			len[i] = now;
			max = Math.max(max, now);
		}

		System.out.println(bisearch(len, 1, max));//이분탐색

	}

	private static int bisearch(int[] len, int low, int high) {
		int mid = 0;
		int cnt;
		while (low <= high) {
			mid = (low + high) / 2;
			cnt = 0;
			for (int i = 0; i < len.length; i++) {
				cnt += len[i] / mid;//주어진 길이가 현재 mid값보다 클 경우 mid를 나눳을때 나올 수 있는 개수만큼 카운트 해준다
			}
			if (cnt >= M)
				low = mid + 1;
			else
				high = mid - 1;
		}
		mid = (low + high) / 2;
		return mid;

	}

}
