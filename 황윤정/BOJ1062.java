import java.util.*;
import java.io.*;

public class BOJ1062 {
	static int N, K;
	static boolean[] visited = new boolean[26]; // a~z까지
	static String[] words; // 입력받은 단어들
	static int result;
	static int depth; // 단어 길이
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new String[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			words[i] = tmp.substring(4, tmp.length()-4); // anta, tica 제거
		}
		
		// 5보다 작으면 a,n,t,i,c 도 몰라서 아무것도 못 읽음
		if(K < 5) {
			System.out.println("0");
			return;
		}
		
		// 이미 알고있는 알파벳 반영
		visited['a'-'a'] = true;
		visited['n'-'a'] = true;
		visited['t'-'a'] = true;
		visited['i'-'a'] = true;
		visited['c'-'a'] = true;
		depth = 5;
		read();
		
		for(int i=0; i<26; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
	static void dfs(int n) {
		// depth가 K만큼 갈 때까지 a~z 방문
		visited[n] = true;
		depth++;
		if(depth == K) {
			read();
		}
		else {
			// 앞에서 찾아본 알파벳은 빼고 탐색
			for(int i=n+1; i<26; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
		}
		visited[n] = false;
		depth--;
	}
	
	static void read() {
		// 단어 한 글자씩 쪼개서 알고 있는 글자인지 확인
		int max = 0;
		char[] word;
		boolean readFlag;
		for(int i=0; i<N; i++) {
			readFlag = true;
			word = words[i].toCharArray();
			for(int j=0; j<word.length; j++) {
				if(!visited[word[j]-'a']) {
					readFlag = false;
					break;
				}
			}
			if(readFlag) {
				max++;
			}
		}
		result = Math.max(max, result);
	}
}
