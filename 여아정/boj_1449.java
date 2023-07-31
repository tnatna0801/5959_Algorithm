package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1449 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		
		int[] input=new int[n];
		st=new StringTokenizer(bf.readLine()," ");
		int[]pi=new int[1001];//pi 배열 생성
		
		for(int i=0;i<n;i++) {
			pi[Integer.parseInt(st.nextToken())]=1;//배열 구멍난 부분 체크
		}
		
		int result=0;
		for(int i=1;i<pi.length;) {//파이for 
			if(pi[i]==1) {//구멍난 부분에 있을때
				i+=s;//테이프 길이만큼 i 이동
				result++;
			}else {
				i++;//구멍난 부분아니면 i추가
			}
		}
		System.out.println(result);//테이프 횟수 결과 출력
	}
	
}
