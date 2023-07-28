package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class boj_11286 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer>q=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1)==Math.abs(o2)) {//절대값이 같을 경우
					if(o1<o2) {//음수를 우선순위로
						return -1;
					}
					return 1;
				}else {
					return Math.abs(o1)-Math.abs(o2);
				}
			}
		});
		
		int n=Integer.parseInt(bf.readLine());
		int input;
		
		for(int i=0;i<n;i++) {
			input=Integer.parseInt(bf.readLine());
			if(input!=0) {//0아닐때 q에 넣음
				q.add(input);
			}else {//0이 입력될 시 반환
				Integer ans=q.poll();
				if(ans!=null) {
					System.out.println(ans);
				}else {
					System.out.println(0);//poll이 null 일 경우 0으로 출력
				}
			}
		}

	}
}
	