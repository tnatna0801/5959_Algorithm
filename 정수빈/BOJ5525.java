import java.util.*;

public class BOJ5525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		String stc = sc.next();
				
		int succ = 0; // 성공하고 있는 자릿수
		int count = 0; // 총 탐색 성공 횟수
		
		for(int i=0; i<M; i++) {
			// 첫 탐색 중
			if(succ == 0) {
				if(stc.charAt(i) == 'I')
					succ += 1;
				else
					succ = 0;
			}
			// 두 칸째 탐색 중 (I **0** I)
			else if(succ%2 == 1){
				if(stc.charAt(i) == 'O')
					succ += 1;
				else
					succ = 1;
			}
			// 세 칸째 탐색 중 (I 0 **I**)
			else {
				if(stc.charAt(i)=='I') {
					if(succ >= N*2)
						count += 1;
					succ += 1;
				}
				else
					succ = 0;
			}
		}
		
		System.out.println(count);
	}
}
