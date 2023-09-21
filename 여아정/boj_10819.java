package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10819 {
	static int N, input[], max, line[];
	static boolean chk[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		input=new int[N];
		chk=new boolean[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		max=Integer.MIN_VALUE;
		line=new int[N];
		dfs(line, 0);
		
		System.out.println(max);
	
	}
	
	private static void dfs(int[] line, int cnt){//계산해줄 순서를 구할 dfs(순열)
		if(cnt==N) {
			int sum=resultSum(line);//구한 순서를 용하여 합 구하기
			max=Math.max(max, sum);//최대값을 구하기 위해 매번 값을 갱신해준다.
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(chk[i])continue;
			chk[i]=true;
			line[cnt]=i;
			dfs(line,cnt+1);
			chk[i]=false;
		}
	}
	
	private static int resultSum(int[] arr) {//합구하기
		int sum=0;
		for(int i=0;i<N-1;i++) {
			int temp=Math.abs(input[arr[i]]-input[arr[i+1]]);//절대값으로 나타내는 내부 메서드를 사용하여  값 구하기
			sum+=temp;//더해주기~!
		}
		return sum;
	}

}
