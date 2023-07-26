import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1182 {
    static int count=0;
    static boolean[] visited;
    static int[] nums;

    static int n, s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        s = Integer.parseInt(line1[1]);

        visited = new boolean[n];

        nums = new int[n];
        String[] tmpNums = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(tmpNums[i]);
        }

        find(0, 0);

        // 주어진 s가 0일때 부분수열의 개수가 0인 부분수열의 합과 동일해지기 때문에 따로 처리해준다.
        if(s==0){
            count -= 1;
        }
        System.out.println(count);

    }

    //부분수열을 찾는 함수 => dfs
    public static void find(int sum, int index) {

        if(index == n){ //깊이가 배열의 크기 n이 되었을 때
            if( sum == s ) {
                count++;
            }
            return;
        }

        find(sum+ nums[index], index + 1); // 해당 원소를 더하거나
        find(sum, index+1); // 안더하거나
    }
}

