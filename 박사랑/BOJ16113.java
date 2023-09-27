import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16113 {
    static char[][] sig;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String input=br.readLine();
        // 시그널 sig에 입력받기
        sig=new char[5][N/5];
        int start=0;
        for(int i=0;i<5;i++){
            sig[i]=input.substring(start,start+N/5).toCharArray();
            start+=N/5;
        }

        StringBuilder sb = new StringBuilder();
        int idx=0;
        while(idx<N/5){
            if(sig[0][idx]=='#') { // 숫자가 써져있음
                int num = check_num(idx);
                if (num == 1) {
                    idx += 2;
                } else {
                    idx += 4;
                }
                sb.append(num);
            }else{
                idx++;
            }
        }
        System.out.print(sb.toString());
    }

    public static int check_num(int idx){
        if(idx==(N/5-1)) return 1;
        if(sig[0][idx+1]=='.'){ // 1 또는 4
            if(sig[3][idx]=='.'){
                return 4;
            }
            return 1;
        }
        // ** 1또는 4가 아닌 경우**
        StringBuilder sb=new StringBuilder();
        String[] nums=new String[10];
        nums[0] = "####.##.##.####";
        nums[2] = "###..#####..###";
        nums[3] = "###..####..####";
        nums[5] = "####..###..####";
        nums[6] = "####..####.####";
        nums[7] = "###..#..#..#..#";
        nums[8] = "####.#####.####";
        nums[9] = "####.####..####";

        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                sb.append(sig[i][idx+j]); // 3*3칸에 쓰여있는 문자를 모두 더한다
            }
        }
        for(int i=0;i<=9;i++){
            if(i==1||i==4) continue;
            if(sb.toString().equals(nums[i])){ // 숫자 문자열과 비교해서 어떤 숫자인지 알아냄
                return i;
            }
        }
        return -1;
    }
}
