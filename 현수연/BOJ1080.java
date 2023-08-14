import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		int[][] A = new int[n][m];
		int[][] B = new int[n][m];
		for (int i = 0; i < n; i++) {
			in = br.readLine().split("");
			for (int j = 0; j < m; j++)
				A[i][j] = Integer.parseInt(in[j]);
		}
		for (int i = 0; i < n; i++) {
			in = br.readLine().split("");
			for (int j = 0; j < m; j++)
				B[i][j] = Integer.parseInt(in[j]);
		}
		int cnt=0;
		for (int i = 0; i < n-2; i++) {
			for (int j = 0; j < m-2; j++) {
				if(A[i][j]==B[i][j]) continue;
				for(int k=0;k<3;k++) {
					for(int l=0;l<3;l++) {
						if(A[i+k][j+l]==1)
							A[i+k][j+l]=0;
						else
							A[i+k][j+l]=1;
					}
				}
				cnt++;
			}
		}
		boolean isPossible = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(A[i][j]!=B[i][j]) {
					isPossible=false;
					break;
				}
			}
			if(!isPossible)
				break;
		}
		if(!isPossible)
			System.out.println(-1);
		else
			System.out.println(cnt);
	}
}
