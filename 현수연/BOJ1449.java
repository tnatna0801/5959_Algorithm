package java_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] pos = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			pos[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(pos);
		int idx=0;
		int cnt=1;
		for (int i = 1; i < n; i++) {
			if(pos[i]-pos[idx]<l)
				continue;
			idx=i;
			cnt++;
		}
		System.out.println(cnt);
	}
}
