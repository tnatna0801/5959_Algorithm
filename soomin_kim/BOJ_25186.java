import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ_25186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long max = 0;
        long sum = 0;
        for(int i = 0; i<n; i++){
            int cloth = Integer.parseInt(st.nextToken());
            max = Math.max(max, cloth);
            sum += cloth;
        }

        StringBuilder sb = new StringBuilder();

        if(max > sum-max && sum != 1) sb.append("Unhappy");
        else sb.append("Happy");

        System.out.println(sb);
    }
}
