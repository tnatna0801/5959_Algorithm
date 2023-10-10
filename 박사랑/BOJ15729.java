import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] light=new int[N];
        int[] result=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            light[i]=Integer.parseInt(st.nextToken());
        }

        int cnt=0;
        for(int i=0;i<N;i++){
            if(light[i]!=result[i]){ // 같지 않음
                cnt++;
                for(int j=0;j<3;j++){
                    if(i+j>=N) break;
                    result[i+j]= result[i+j]==0 ? 1:0;
                }
            }
        }
        System.out.println(cnt);
    }
}
