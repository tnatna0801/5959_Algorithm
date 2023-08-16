package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_5397 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		Stack<Character> ans, moment;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			
			sb=new StringBuilder();
			ans = new Stack<>();
			moment = new Stack<>();
			char[] in = br.readLine().toCharArray();
			int cur = 0;

			for (char c : in) {
				if(c=='<') {
					if(ans.isEmpty())	continue;
					else {
						char tmp=ans.pop();
						moment.push(tmp);
					}
				}else if(c=='>') {
					if(!moment.isEmpty()) {
						char tmp=moment.pop();
						ans.push(tmp);
					}
				}else if(c=='-') {
					if(!ans.isEmpty()) {
						ans.pop();
					}
					
				}else {
					ans.push(c);
				}
			}
			while(!moment.isEmpty()) {
				ans.push(moment.pop());
			}
			while(!ans.isEmpty()){
				sb.append(ans.pop());
			}
			System.out.println(sb.reverse().toString());

		}

	}
}
