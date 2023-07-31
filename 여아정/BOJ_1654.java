package study_5959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class boj_1654 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s=new StringTokenizer(bf.readLine()," ");
		
		int k=Integer.parseInt(s.nextToken());
		int n=Integer.parseInt(s.nextToken());
		
		int[] line=new int[k];
		long max=0;
		
		for(int i=0;i<k;i++) {
			line[i]=Integer.parseInt(bf.readLine());
			max=Math.max(max, line[i]);
		}

		max++;
		long min=0;
		long mid=0;
		
		while(min<max) {
			mid=(max+min)/2;
			
			long cnt=0;
			for(int i=0;i<k;i++) {
				cnt+=(line[i]/mid);
			}
			if(cnt<n) {
				max=mid;
			}else {
				min=mid+1;
			}
		}
		System.out.println(min-1);
		
		
	}

}
