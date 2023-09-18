import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] in; // 입력받는 시그널 배열
	static int signalLength; // 시그널 한 행의 길이
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 시그널 배열의 크기
		signalLength = N / 5; // 시그널 한 행의 길이 입력
		in = br.readLine().toCharArray(); // 시그널 입력
		StringBuilder sb = new StringBuilder(); // 출력을 위한 StringBuilder
		int cnt = 0; // 숫자의 가로 길이 (숫자를 나타내는 한 행의 길이)
		for (int i = 0; i < signalLength; i++) {
			boolean isEmpty = true;
			for (int j = 0; j < 5; j++) { // 한 열씩 검토
				if (in[signalLength * j + i] == '#')
					isEmpty = false;
			}
			if (isEmpty) { // 만일 해당 열이 비어있을 경우
				// 1
				if (cnt == 1) { // 숫자의 행 길이가 1일 경우
					sb.append(1); // 행 길이가 1인 것은 1밖에 없기 때문에 1을 StringBuilder에 넣습니다
				} else if (cnt == 3) { // 숫자의 행 길이가 3일 경우
					sb.append(whatNum(i-3)); // 어떤 숫자인지 구별해주는 함수 호출 후, 해당 숫자를 StringBuilder에 넣습니다
				}
				cnt = 0; // 다음 시그널을 위해 행 크기 0으로 초기화
				continue; // 다음 열로 넘어갑니다
			}
			cnt++; // 해당 열이 비어있지 않은 경우, 숫자를 나타내는 시그널이므로, 숫자의 행 길이를 늘립니다
		}
		// 마지막에 열이 비어있지 않았을 경우를 대비하여 카운팅을 마지막까지 검토, 검토 후는 반복문 내의 로직과 동일
		if (cnt == 1) {
			sb.append(1);
		} else if (cnt == 3) {
			sb.append(whatNum(signalLength-3));
		}
		System.out.println(sb); // 최종 시그널 출력
	}
	
	// 어떤 숫자인지 구별해주는 함수
	static int whatNum(int idx) { // 시그널이 시작하는 첫 인덱스를 매개변수로 입력
		// 시그널을 살펴보면 특정 숫자만이 가지고있는 다른 특징이 존재합니다.
		//이런 특징을 활용하여 모두 검토하지 않고 해당 특징만 검토하여 어떤 숫자인지 구별합니다
		// 4
		if(in[idx+1]=='.')
			return 4;
		// 7
		if(in[idx+2*signalLength]=='.')
			return 7;
		// 0
		if(in[idx+1+2*signalLength]=='.')
			return 0;
		// 2
		if(in[idx+2+3*signalLength]=='.')
			return 2;
		// 3
		if(in[idx+signalLength]=='.')
			return 3;
		if(in[idx+2+signalLength]=='.') {
			// 5
			if(in[idx+3*signalLength]=='.')
				return 5;
			// 6
			return 6;
		}
		// 9
		if(in[idx+3*signalLength]=='.')
			return 9;
		// 8
		return 8;
	}
}
