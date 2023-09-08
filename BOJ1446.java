import java.util.*;

public class BOJ1446 {
	static int N, D, max, route[][], map[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		D = sc.nextInt();
		
		route = new int[N][3];
		// 지름길 저장
		for(int i=0; i<N; i++) {
			route[i][0] = sc.nextInt();
			route[i][1] = sc.nextInt();
			route[i][2] = sc.nextInt();
		}
		
//		for(int i=0; i<N; i++)
//			System.out.println(route[i][0] +  " " + route[i][1] + " " + route[i][2]);

    // 최소 운전 거리 저장 배열
		map = new int[D+1];
		for(int i=0; i<=D; i++) {
			map[i] = i;
		}
		
		bfs();
		
		System.out.println(map[D]);
	}

  // 다익스트라
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
      
			boolean check = false;
			for(int i=0; i<N; i++) {
        // 현재 위치에서 갈 수 있는지, 고속도로를 넘어가는지, 지름길이 고속도로보다 더 짧은지
				if(info[0] > route[i][0] || route[i][1] > D || route[i][1]-route[i][0] < route[i][2]) continue;

				check = true;
				int index = route[i][1] > D ? D : route[i][1]; // D를 벗어나는 것까지 고려해서 작성한 건데 수정 필요
				int dist = info[1]+route[i][0]-info[0]+route[i][2]; // 현재 운전 거리 + 지름길 시작 지점 - 현재 지점 + 지름길 운전 거리
				
				if(map[index] > dist) {
					map[index] = dist;

          // 도달하면 검사할 필요가 없다
					if(index != D) {
						q.add(new int[] {index, dist});
					}
				}
			}

      // D에 도달하진 못한 마지막 지름길일 경우를 걸러낸다
			if(!check) {
				if(map[D] > info[1]+D-info[0])
					map[D] = info[1]+D-info[0];
			}
		}
	}
}
