package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_2075 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] map=new int[n][n];
		PriorityQueue<Integer>q=new PriorityQueue<Integer>(Collections.reverseOrder());//큰 수 우선 우선순위큐 생성
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				q.add(map[i][j]);//값을 넣어 준다
			}
		}
		
		for(int i=0;i<n;i++) {//우선순위가 되는 값을 뽑는다
			if(i==n-1) {
				System.out.println(q.poll());//N번째 일때 값을 출력한다
			}else {
				q.poll();
			}
		}
		
		
		
	}
}
