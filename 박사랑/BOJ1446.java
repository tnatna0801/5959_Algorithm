import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1446 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());

        // 인접 행렬
        int[][] adj=new int[D+1][D+1];
        for(int i=0;i<=D;i++){
            for(int j=0;j<=D;j++){
                adj[i][j]=10000*10000; // 1억으로 초기화
            }
        }


        for(int i=0;i<N;i++){ // 지름길 입력받기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            if(end>D) continue; // end가 D를 넘어가면 무효
            adj[start][end]=Math.min(adj[start][end],dis); // start와 end가 같은 지름길이 여러개면 그 중에 dis가 제일 짧은 거 선택
        }

        for(int i=0;i<D;i++){
            if(adj[i][i+1]>1){ // i에서 i+1로 가는 비용을 1로 해주기
                adj[i][i+1]=1;
            }
        }

        int[][] dis=new int[D+1][D+1]; // i행에서 j열로 가는 비용
        for(int i=0;i<=D;i++) {
            for(int j=0;j<=D;j++){
                dis[i][j]=10000*10000; // 1억으로 초기화
            }
        }

        // 0번째행 채우기
        for(int i=0;i<=D;i++){ // 0에서 가는 방법
            if(adj[0][i]!=10000*10000){ // 가는 길이 있음
                dis[0][i]=adj[0][i];
            }
        }

        for(int i=1;i<=D;i++){
            dis[i][i]=dis[i-1][i];
            for(int j=i+1;j<=D;j++){
                // 최소 비용 갱신하기
                dis[i][j]=Math.min(dis[i-1][j],dis[i][i]+adj[i][j]);
            }
        }
        System.out.println(dis[D][D]);
    }
}
