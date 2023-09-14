import java.util.*;

public class BOJ17503 {
    static int K, N, M;
    static long min, maxValue, beers[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  
	    N = sc.nextInt(); // 맥주 종류 K개 중
	    M = sc.nextInt(); // N개 선호도 합 M 이상 
	    K = sc.nextInt();
	    min = Integer.MAX_VALUE; // 간 레벨의 최솟값
	    maxValue = 0;
	    
	    beers = new long[K][2];
	    for(int i=0; i<K; i++) {
	        beers[i][0] = sc.nextInt();
	        beers[i][1] = sc.nextInt();
	        
	        if(maxValue < beers[i][0])
	        	maxValue = beers[i][0];
	    }
	
	    // 도수 레벨이 더 적은 순서대로 정렬한다
	    Arrays.sort(beers, (o1,o2)->((int)(o1[1]-o2[1])));
	    
	    // 최대와 최소를 범위로 삼아 이진 탐색을 진행한다
	    binarySearch((int)beers[0][1], (int)beers[K-1][1]);
	
	    if(min == Integer.MAX_VALUE)
	        System.out.println(-1);
	    else
	        System.out.println(min);
    }

	static void binarySearch(int min_v, int max_v) {
	    while(min_v < max_v) {
	    	int mid = (min_v+max_v)/2;
	    	//System.out.println(mid);
	    	// bfs 성공했을 경우 간 레벨을 더 최소화 시켜 본다
	    	if(bfs(mid)) {
	        	min = mid;
	        	max_v = mid;
	    	}
	    	// 실패했을 경우 간 레벨을 올려 본다
	    	else {
	    		min_v = mid+1;
	    	}
	    }
	}
	static boolean bfs(int n) {
	    // max의 값이 가장 작은 것부터 한다.
	    Queue<long[]> q = new PriorityQueue<>((o1,o2)->(int)((long)o1[2]-(long)o2[2]));
	    //Queue<long[]> q = new ArrayDeque<>();
	
	    // num, sum, max, count
	    for(int i=0; i<N; i++)
	    	q.add(new long[]{i, beers[i][0], beers[i][0], 1});
	
	    while(!q.isEmpty()) {
	        long[] beer = q.poll();
	
	        // max의 min 보다 크면 넘어간다
	        if (min < beer[2]) continue;
	        // 부족할 수밖에 없는 합은 상시 거른다
	        if(M > beer[1]+(N-beer[3])*maxValue) continue;
	
	        if (beer[3] == N) {
	        	// 최소 간 레벨이 작으면서도, 선호도는 M 이상이어야 한다
	            if(beer[1] >= M)
	                return true;
	            continue;
	        }
	
	        for (int i = (int)beer[0] + 1; i < K; i++) {
	            // 이진 탐색 mid 이하 범위 제한
	            if(n < beers[i][1]) break;
	
	            // max의 min 보다 크면 넘어간다
	            if (min < beers[i][1]) continue;
	
	            System.out.println("i:" + i + " min:"+ min + " b0:" + beer[0] + " b1:" + beer[1] + " b2:" + beer[2] + " b3:" + beer[3]);
	
	            if (beer[2] < beers[i][1])
	                q.add(new long[]{i, beer[1] + beers[i][0], beers[i][1], beer[3] + 1});
	            else
	                q.add(new long[]{i, beer[1] + beers[i][0], beer[2], beer[3] + 1});
	        }
	    }
	
	    return false;
	}
}
