package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1911 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] uoung = new int[n][2];//웅덩이 값 받을 배열
		
		for (int i = 0; i < n; i++) {//웅덩이 값 input받기
			st = new StringTokenizer(br.readLine());
			uoung[i][0] = Integer.parseInt(st.nextToken());
			uoung[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(uoung, new Comparator<int[]>() {//시작값 기준으로 오름차순 정렬 + 시작값 같으면 뒷 끝값기준으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		int cover = 0;//널판지
		int result = 0;//결과
		
		for (int i = 0; i < n; i++) {//웅덩이 배열 전체 돌기
			if (uoung[i][0] > cover) {//웅덩이 시작 위치가 널판지보다 크면
				cover = uoung[i][0];//널판지 위치를 웅덩이로 해줌
			}
			if (uoung[i][1] > cover) {//웅덩이 끝위치가 널판지보다 크면
				while (uoung[i][1] > cover) {//널판지가 커질때 까지 널판지 한판씩 추가함
					cover += l;
					result++;//추가할때마다 갯수 카운트
				}
			}
		}

		System.out.println(result);//결과 출력
	}

}
