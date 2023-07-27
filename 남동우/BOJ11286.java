import java.io.*;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)){
                return Integer.compare(o1, o2);
            }
            return Double.compare(Math.abs(o1), Math.abs(o2));
        });

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(!pq.isEmpty()){
                    bw.write(pq.poll() + "\n");
                }else{
                    bw.write("0\n");
                }
            }else{
                pq.add(input);
            }
        }
        bw.flush();
        bw.close();
    }
}
