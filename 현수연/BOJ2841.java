import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static class Guitar{ // 스택값을 가지고있는 기타 클래스입니다
		private Stack<Integer> p;
		public Guitar() { // 생성자에서 플랫 번호 스택을 하나 만들어냅니다
			p = new Stack<>();
		}
		// 이 아래는 스택연산을 함수로 만들어줬습니다...(알고리즘 문제에선 굳이 싶긴함)
		public void setP(int p) {
			this.p.push(p);
		}
		public int getP() {
			return this.p.peek();
		}
		public int popP() {
			return this.p.pop();
		}
		public boolean isEmptyP() {
			return this.p.isEmpty();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]); // N의 개수를 입력 받습니다
		int P = Integer.parseInt(in[1]); // P를 입력 받습니다
		int n, p, cnt=0; // 앞으로 순차적으로 입력받게될 줄번호와 플랫번호 변수입니다. cnt는 손가락이 움직이는 카운팅 수 입니다
		Guitar[] guitars = new Guitar[6]; // 기타 클래스 배열을 만들어 줍니다
		for(int i=0;i<6;i++)
			guitars[i] = new Guitar(); // 줄번호 별로 기타 클래스 객체를 만들어줍니다
		for(int i=0;i<N;i++) {
			in = br.readLine().split(" ");
			n = Integer.parseInt(in[0])-1;
			p = Integer.parseInt(in[1]); // 줄번호와 플랫번호를 차례로 입력받습니다
			if(guitars[n].isEmptyP()) { // 만약에 해당 줄번호 플랫 스택에 아무런 값이 없으면
				guitars[n].setP(p); // 플랫 스택에 push해주고
				cnt++; // 손가락이 움직였으니 카운팅해준 뒤 continue로 나와줍니다
				continue;
			}
			if(guitars[n].getP()>p) { // 만약 플랫 스택에 있는 값이 현재 연주하려는 플랫 보다 클 경우
				while(!guitars[n].isEmptyP()) { // 플랫 스택이 빌 때까지 while문을 돌아줍니다
					if(guitars[n].getP()<=p) // 만일 현재 연주하려는 플랫과 같아지거나 작아지면 break으로 반복문을 멈춥니다
						break;
					guitars[n].popP(); // 플랫 스택이 빌때까지 pop을 반복해줍니다
					cnt++; // 플랫에서 손가락을 뗐으니 움직였기에 카운팅도 해줍니다
				}
			}
			if(guitars[n].isEmptyP()||guitars[n].getP()<p) { // 만약 플랫 스택이 비었거나 플랫 스택에 있는 값이 현재 연주하려는 플랫 보다 작을 경우
				guitars[n].setP(p); // 플랫 스택에 push해주고
				cnt++; // 손가락이 움직였으니 카운팅해줍니다
			}
		}
		System.out.println(cnt); // 위의 과정을 N번 거친 후 최종적으로 손가락이 움직인 값인 cnt을 출력합니다.
	}
}
