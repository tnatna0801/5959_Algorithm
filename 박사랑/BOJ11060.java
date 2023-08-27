import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ11060 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] data=new int[N];
		int[] dp=new int[N];
		
		String[] input=br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			data[i]=Integer.parseInt(input[i]);
			dp[i]=Integer.MAX_VALUE;
		}

    // 첫 번째 칸이 0이면 종료
		if(N>=1 && data[0]==0) {
			System.out.println(-1);
			return;
		}
        
		dp[0]=0;
    
		for(int i=0;i<N-1;i++) {
			if(data[i]==0||dp[i]==Integer.MAX_VALUE) { // 다음칸으로 점프할 수 없음 || 오는 길이 없음
				continue;
			}
			for(int j=1;j<=data[i];j++) { // 점프할 수 있는 만큼 가보자
				if(i+j>=N) break; // 인덱스 벗어나면 종료
				dp[i+j]=Math.min(dp[i+j], dp[i]+1);
			}
		}
        
		if(dp[N-1]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(dp[N-1]);
		}
	}

}
