import java.util.*;

public class BOJ10819 {
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int num[] = new int[N];
        max = -100*N;

        for(int i=0; i<N; i++)
            num[i] = sc.nextInt();

        // 조합을 구해서 계산해 본다
        permutation(new int[N], num,0, 0, N);

        System.out.println(max);
    }

    static void permutation(int arr[], int num[], int index, int flag, int N) {
        if(index == N) {
            // 최댓값이면 저장한다
            int result = calcSum(arr, num, N);

            if(result > max)
                max = result;

            return;
        }

        for(int i=0; i<N; i++) {
            if((flag & (1<<i)) == 0) {
                arr[index] = i;

                permutation(arr, num,index+1, (flag|(1<<i)), N);
            }
        }
    }

    static int calcSum(int arr[], int num[], int N) {
        int sum = 0;

        for(int i=1; i<N; i++)
            sum += Math.abs(num[arr[i-1]]-num[arr[i]]);

        return sum;
    }
}
