import java.util.*;
import java.io.*;

public class BOJ2841 {
	static int N, P, count;
	static ArrayList<Stack<Integer>> gui;
	
	public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
		
        st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		// 기타 6줄의 프렛 값
		gui = new ArrayList<>();

		for(int i=0; i<6; i++) {
			gui.add(new Stack<>());
			gui.get(i).add(0);
		}
		
		count = 0;
		
		for(int i=0; i<N; i++) {
			
			// 줄의 번호, 프렛의 번호
			st = new StringTokenizer(br.readLine(), " ");
			int j = Integer.parseInt(st.nextToken())-1;
			int p = Integer.parseInt(st.nextToken());
			
			// 현재 줄에 저장된 프렛 번호 < 이동해야 하는 프렛 번호
			// 덮어 씌운다
			int num = gui.get(j).peek();
			
			if(num < p) {
				gui.get(j).add(p);
				count += 1;
			}
			
			// 현재 줄에 저장된 프렛 번호 > 이동해야 하는 프렛 번호
			// 같거나 작아질 때까지 꺼낸다
			// 같으면 넘어가고
			// 작아지면 덮어씌운다
			else if(num > p) {
				while(gui.get(j).size() > 1 && gui.get(j).peek() >= p) {
					 num = gui.get(j).pop();
					 count += 1;
				}
				
				if(num == p) {
					gui.get(j).add(p);
					count -= 1;
				}
				else {
					gui.get(j).add(p);
					count += 1;
				}
			}
			// 현재 줄에 저장된 프렛 번호 = 이동해야 하는 프렛 번호
			// 넘어간다
		}
		
		System.out.println(count);
	}
}
