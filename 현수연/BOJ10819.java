import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
	static int N, arr[], maxSum;
	static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N 입력
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        	arr[i]=Integer.parseInt(st.nextToken()); // 배열 입력
        dfs(0,0,0); // 재귀함수호출
        System.out.println(maxSum); // 최종 최대값을 출력
        
    }
    // 재귀로 순열 탐색을 진행합니다
    static void dfs(int cnt, int pre, int sum) {
    	if(cnt==N) { // 마지막 노드까지 갔을 경우
    		maxSum=maxSum>sum?maxSum:sum; // 최대값일 경우 갱신한 뒤 return
    		return;
    	}
    	for(int i=0;i<N;i++) {
    		if(visited[i]) continue; // 방문했으면 continue
    		visited[i]=true; // 안했으면 방문 체크
    		if(cnt>0) // 첫 배열은 연산을 진행하지 않으므로 해당 경우를 빼고 연산
    			sum+=Math.abs(arr[i]-pre);
    		dfs(cnt+1, arr[i], sum); // 재귀
    		if(cnt>0)
    			sum-=Math.abs(arr[i]-pre);
    		visited[i]=false;
    	}
    }
}