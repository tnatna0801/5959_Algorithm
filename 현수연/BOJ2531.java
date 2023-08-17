import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int d = Integer.parseInt(in[1]);
        int k = Integer.parseInt(in[2]);
        int c = Integer.parseInt(in[3]);
        int[] belt = new int[N];
        int[] chobab = new int[d+1];
        int maxChobab=0;
        for(int i=0;i<N;i++)
            belt[i]=Integer.parseInt(br.readLine());
        int cnt=1;
        chobab[c]++;
        for(int i=0;i<N;i++){
            if(i==0){
                for(int j=0;j<k;j++){
                    if(chobab[belt[j]]==0)
                        cnt++;
                    chobab[belt[j]]++;
                }
            }
            else{
                if(chobab[belt[i-1]]==1)
                    cnt--;
                chobab[belt[i-1]]--;
                int idx=i+k-1;
                if(idx>=N)
                    idx-=N;
                if(chobab[belt[idx]]==0)
                    cnt++;
                chobab[belt[idx]]++;
            }
            maxChobab=Math.max(maxChobab,cnt);
        }
        System.out.println(maxChobab);
    }
}
