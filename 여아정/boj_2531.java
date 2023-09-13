package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2531 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> many;//최종 결과에 사용될 Set
		
		//입력 받기
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int max = Integer.MIN_VALUE;// 결과 값 넣을 것

		List<Integer> list = new ArrayList<>();//벨트 위 초밥값 넣을 list
		ArrayDeque<Integer> q = new ArrayDeque<>();//최대종류를 찾기위한 Queue

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));// 값 받아오기
		}

		for (int i = 0; i < k; i++) {//처음 초기  0~에서 k개 넣기
			q.add(list.get(i));// 슬라이딩을 위해서 Queue에 넣기
		}

		many = new HashSet<>(q);//새로운 Set을 만들어서 완성 시킨 하나의 경우의 수 넣기
		many.add(c);//쿠폰으로 받는 c의 초밥 종류도 추가한다
		max = Math.max(max, many.size());

		int now = k;// 다음에 넣어줄 idx

		for (int i = 0; i < n; i++) {//그 다음 경우의 수를 위한 반복
			if (now == list.size()) {//마지막 idx의 경우 0으로 돌려준다
				now = 0;
			}

			q.poll();//가장 앞의 값 빼기
			q.add(list.get(now));//다음 값 넣기
			
			many = new HashSet<>(q);//새로운 Set을 할당하여 q를 넣어준다
			many.add(c);//쿠폰으로 받는 c의 초밥 종류도 추가한다
			max = Math.max(max, many.size());//최대값을 매번 갱신해준다

			now++;//idx 추가
		}
		
		System.out.println(max);//결과
	}
}
