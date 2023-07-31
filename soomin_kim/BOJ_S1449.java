import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int L = Integer.parseInt(firstLine[1]) - 1;

        String[] s = br.readLine().split(" ");
        int[] position = new int[1001];

        for(int i = 0; i<N; i++){
            position[Integer.parseInt(s[i])] = 1;
        }

        int tape = 0;
        for(int i = 1; i <position.length; i++){
            if(position[i] == 1){
                i += L;
                tape++;
            }
        }

        System.out.println(tape);
    }
}
