import java.util.*;

public class BOJ4889 {   
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 0;  
		
		while(true) {             
			String str = sc.next(); 
			
			if(str.contains("-"))
				break;
			
			int n = str.length();             
			int count = 0;             
			Stack<Character> s = new Stack<>();  
			
			for(int i = 0; i < n; i++) {                 
				char c = str.charAt(i);   
				
				// 문자열이 { 이면 스택에 넣는다
				if(c == '{')                 
					s.add(c);
				else {                   
					// 문자열이 } 이면 스택에서 뺀다                      
					// 비어 있으면 { 로 변경해 저장한다          
					if(s.isEmpty()) {                              
						count++;                         
						s.add('{');                     
					}     
					// 안 비어 있으면 꺼낸다
					else {   
						s.pop();
					}
				} 
			}
			
			System.out.println((++T) + ". " + (count + s.size()/2));
		} 
	}
}
