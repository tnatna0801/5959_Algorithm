package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_1213 {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		String[] change=str.split("");
		
		int[] alpha=new int[26];//알파벳 별 배열 생성
		for(int i=0;i<change.length;i++) {
			alpha[change[i].charAt(0)-'A']++;//알파뱃 별 갯수 체크
		}
		
		
		//총 3부분으로 나눠서 완성
		//앞부분 +중간부분+마지막 부분
		
		int one=0;
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i]%2!=0) {//알파뱃 홀수인 경우가 2개 이상인지 체크
				one++;
			}
		}
		
		String result="";
		
		if(one>1) {
			System.out.println("I'm Sorry Hansoo");//홀수 개인 알파벳이 2개 이상이면 팰린드롬을 만들 수 없음
		}else {
			StringBuilder sb=new StringBuilder();//stringbuilder 이용
			for(int i=0;i<alpha.length;i++) {
				for(int j=0;j<alpha[i]/2;j++) {//앞부분의 경우 짝수개인 알파뱃을 반만 들고옴
					sb.append((char)(i+'A'));
				}
			}
			
			result+=sb.toString();//앞부분 추가
			String end=sb.reverse().toString();//뒷 부분은 앞부분의 뒤집은 배열 사용
			
			sb=new StringBuilder();//새로운 stringbuildler 생성
			for(int i=0;i<alpha.length;i++) {
				if(alpha[i]%2==1) {//이번엔 홀수 개인 알파벳을 추가함
					sb.append((char)(i+'A'));
				}
			}
			
			result+=sb.toString()+end;//앞 부분 붙인 result에 나머지 중간 부분과 끝 부분을 연결해 준다
			System.out.println(result);//결과 출력
			
		}
		
	}

}
