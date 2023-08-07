import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8911 {

    static int[] dr={-1,0,1,0};
    static int[] dc={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            char[] command = br.readLine().toCharArray();
            int min_r = 0, min_c = 0, max_r = 0, max_c = 0, curr_r = 0, curr_c = 0;
            int dir=0;

            for (int i = 0; i < command.length; i++) {
                if (command[i] == 'F') {
                    curr_r+=dr[dir];
                    curr_c+=dc[dir];
                    max_r=Math.max(max_r,curr_r);
                    max_c=Math.max(max_c,curr_c);
                    min_r=Math.min(min_r,curr_r);
                    min_c=Math.min(min_c,curr_c);
                } else if (command[i] == 'B') {
                    curr_r-=dr[dir];
                    curr_c-=dc[dir];
                    max_r=Math.max(max_r,curr_r);
                    max_c=Math.max(max_c,curr_c);
                    min_r=Math.min(min_r,curr_r);
                    min_c=Math.min(min_c,curr_c);
                } else if (command[i] == 'L') { // 방향 바꾸기
                    if(dir==0){
                        dir=3;
                    }else{
                        dir-=1;
                    }
                } else if (command[i] == 'R') { // 방향 바꾸기
                    if(dir==3){
                        dir=0;
                    }else{
                        dir+=1;
                    }
                }
            }
            System.out.println((max_r-min_r)*(max_c-min_c));
        }
    }
}
