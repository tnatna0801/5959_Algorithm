import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_2302 {
    public static int[] arr;
    public static void dp(int n) {
        arr[0] = arr[1] = 1;
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        dp(n);

        int result = 1;
        int left = 1;
        int right = n;

        for(int i=0; i<m; i++) {
            right = Integer.parseInt(br.readLine());
            result *= arr[right-left];
            left = right + 1;
        }
        result *= arr[n+1-left];

        System.out.println(result);

    }
}