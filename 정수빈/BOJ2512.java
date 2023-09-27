import java.util.*;

public class BOJ2512 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		int budget = sc.nextInt();
		
		// 모든 요청이 배정 가능한 경우 요청 금액을 그대로 배정
		// 그럴 수 없는 경우 특정 정수 상한액 계산해 최대 상한액까지만 배정
			
		Arrays.sort(arr);
		
		// 모든 요청이 배정 가능한지 확인하고
		if(getSum(arr, budget, arr[N-1])) {
			System.out.println(arr[N-1]);
			return;
		}
			
		// 그럴 수 없는 경우 이분 탐색으로 상한액을 정한다
		System.out.println(binarySearch(arr, budget, 0, arr[N-1]));
	}
	
	static boolean getSum(int[] arr, int budget, int n) {
		int sum = 0;
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i] > n) // 넘을 경우 n 으로 제한해서 계산한다
				sum += n;
			else
				sum += arr[i];
			
			if(budget < sum) // 예산을 넘으면 false
				return false;
		}
		
		return true; // 예산 안에 되면 true
	}
	
	// 검사 범위는 0 ~ 최댓값
	// 최솟값을 찾는다
	static int binarySearch(int[] arr, int budget, int start, int end) {
		int result = 0;
		
		while(start <= end) {
			int mid = (start+end)/2;
			//System.out.println(start + " ~ " + end + " result:"+result);
			
			if(getSum(arr, budget, mid)) {
				start = mid+1;
				result = mid;
			}
			else {
				end = mid-1;
			}
		}
		
		return result;
	}
}
