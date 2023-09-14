import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static int f, s, g, u, d;
    static int[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 현재 위치와 가야할 위치가 동일 하다면!!
        if(s == g) {
            System.out.println(0);
            return;
        }
        // 다르다면
        else {
            visit = new int[f+1];
            //움직이기
            move();
        }

        // 출력
        if(visit[g] == 0) System.out.println("use the stairs");
        else System.out.println(visit[g]-1);


    }

    public static void move(){
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visit[s] = 1;

        while(!q.isEmpty()){
            int current = q.poll();

            //종료조건: 도착지에 도달하면 종료
            if(current == g){
                return;
            }
            
            int nextUp = current + u; // 위층으로 올ㄹ라가기
            if(nextUp <= f && visit[nextUp] == 0 )  {
                visit[nextUp] = visit[current] + 1; //방문처리 및 버튼 누른 횟수 저장
                q.add(nextUp);
            }

            int nextDown = current - d;  //내려가기
            if(nextDown > 0 && visit[nextDown] == 0 ) {
                visit[nextDown] = visit[current] + 1;
                q.add(nextDown);
            }
        }
    }
}
