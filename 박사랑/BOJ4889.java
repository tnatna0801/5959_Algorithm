import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4889 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int tc=0;
		
		while(true) {
			String s=br.readLine();
			if(s.contains("-")) {
				break;
			}
			char[] ch=s.toCharArray();
			int open=0; // 여는 괄호
			int close=0; // 닫는 괄호
			int result=0; // 바꾸는 횟수
			
			for(int i=0;i<ch.length;i++) {
				if(ch[i]=='{') {
					open++;
				}else if(ch[i]=='}') {
					close++;
				}
				
				// 갯수 비교
				if(close>open) { // close가 더 많으면 안되기때문에 open으로 옮겨준다.
					close--;
					open++;
					result++;
				}
			}
			
			while(true) { // open과 close가 같아질 때까지 open에서 빼고 close에 더해준다.
				if(open==close) {
					break;
				}
				open--;
				close++;
				result++;
			}
			// 답 출력
			tc++;
			System.out.println(tc+". "+result);
		}	
	}
}
