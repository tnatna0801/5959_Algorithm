import java.io.*;
import java.util.*;

public class BOJ2784 {
	static String[] arr = new String[6]; // 입력받는 단어 6개
	static boolean[] visitx = new boolean[6]; // 가로 단어 선택된거
	static boolean[] visity = new boolean[3]; // 세로 선택된거
	static int check;
	static String[] strx = new String[3]; // 가로 단어 3개 선택
	static String[] stry = new String[3]; // 세로 단어 3개 선택

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 6; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr);

		// 가로 단어 3개 고르기
		for (int i = 0; i < 6; i++) {
			visitx[i] = true;
			strx[0] = arr[i];
			for (int j = 0; j < 6; j++) {
				if (visitx[j]) {
					continue;
				}
				strx[1] = arr[j];
				visitx[j] = true;
				for (int k = 0; k < 6; k++) {
					if (visitx[k]) {
						continue;
					}
					visitx[k] = true;
					strx[2] = arr[k];
					stry[0] = "";
					stry[1] = "";
					stry[2] = "";
					// 문자 세로로 단어 고르기
					for(int n=0; n<3; n++) {
						for(int m=0; m<3; m++) {
							stry[n] += strx[m].charAt(n);
						}
					}
					Arrays.sort(stry);

					check = 0;
					visity[0] = false;
					visity[1] = false;
					visity[2] = false;

					// 가로에 안뽑힌 단어로 세로 골라서 존재하는 단어인지 비교
					for (int l = 0; l < 6; l++) {
						if (visitx[l]) {
							continue;
						}
						for (int m = 0; m < 3; m++) {
							if (visity[m]) {
								continue;
							}
							if (arr[l].equals(stry[m])) {
								visity[m] = true;
								++check;
								break;
							}
						}
					}
					// 모든 단어가 퍼즐에 다 있다면
					if (check == 3) {
						bw.write(strx[0]+"\n"+strx[1]+"\n"+strx[2]);
						bw.flush();
						return;
					}
					visitx[k] = false;
				}
				visitx[j] = false;
			}
			visitx[i] = false;
		}
		bw.write("0");
		bw.flush();
		bw.close();
	}
}
