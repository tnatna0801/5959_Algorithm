import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]), l = Integer.parseInt(in[1]);
		int[] start = new int[n], end = new int[n];
		for(int i=0;i<n;i++) {
			in = br.readLine().split(" ");
			start[i]=Integer.parseInt(in[0]);
			end[i]=Integer.parseInt(in[1]);
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int cnt=0;
		int idx=start[0];
		for(int i=0;i<n;i++) {
			if(start[i]>idx)
				idx=start[i];
			while(idx<=end[i]-1) {
				idx+=l;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
