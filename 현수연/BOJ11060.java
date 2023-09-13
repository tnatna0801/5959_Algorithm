import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] miro = new int[n];
		int[] jump = new int[n];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			miro[i] = Integer.parseInt(str[i]);
			jump[i] = 1000;
		}
		jump[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <=miro[i]; j++) {
				if(i+j>n-1) break;
				jump[i+j]=Math.min(jump[i+j], jump[i]+1);
			}
		}
		if (jump[n - 1] == 1000)
			jump[n - 1] = -1;
		System.out.println(jump[n - 1]);
	}
}