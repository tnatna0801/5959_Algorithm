import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {

    static int N, result;
    static int[] arr, per;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        per=new int[N];
        visit=new boolean[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        result=Integer.MIN_VALUE;
        permutaion(0);
        System.out.println(result);
    }

    public static void permutaion(int depth){
        if(depth==N){
            // 식의 값 계산
            int sum=0;
            for(int i=0;i<N-1;i++){
                sum+=Math.abs(per[i]-per[i+1]);
            }
            result=Math.max(result,sum);
            return;
        }
        for(int i=0;i<N;i++) {
            if(!visit[i]){
                visit[i]=true;
                per[depth]=arr[i];
                permutaion(depth+1);
                visit[i]=false;
            }
        }
    }
}
